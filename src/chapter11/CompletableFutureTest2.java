package chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static chapter11.Quote.parse;
import static java.util.stream.Collectors.toList;

//实现折扣服务
public class CompletableFutureTest2 {
    static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
            new ThreadFactory() {
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true); //使用守护线程——这种方式不会阻止程序的关停
                    return t;
                }
            });
    public static void main(String[] args) throws Exception {
        /**
         * 对多个异步任务进行流水线操作
         */

        /**
         * 测试1：以最简单的方式实现使用Discount服务的findPrices方法,顺序阻塞式执行
         * Done in 8224 msecs
         */
        /**
         * 测试2：改进上一个测试，使用CompletableFuture实现findPrices方法
         * CompletableFuture API提供 thenCompose方法，允许你对两个异步操作进行流水线，第一个操作完成时，将其结果作为参数传递给第二个操作。
         * Done in 2196 msecs
         */
//        long start = System.nanoTime();
//        System.out.println(findPrices("myPhone27S"));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");

//        /**
//         * 测试3：利用Java 7的方法合并两个Future对象
//         */
//        ExchangeService exchangeService = new ExchangeService();
//        Shop shop = new Shop("My shop");
//        String product = "myPhone27S";
//        ExecutorService executor = Executors.newCachedThreadPool();
//        final Future<Double> futureRate = executor.submit(new Callable<Double>() {
//            public Double call() {
//                return exchangeService.getRate(Money.EUR, Money.USD);
//            }
//        });
//        Future<Double> futurePriceInUSD = executor.submit(new Callable<Double>() {
//            public Double call() throws ExecutionException, InterruptedException {
//                double priceInEUR = shop.getPrice(product);
//                return priceInEUR * futureRate.get();
//            }
//        });
//        System.out.println("合并两个Future对象:"+ futurePriceInUSD.get());
//
//        /**
//         * 测试4：合并两个独立的CompletableFuture对象
//         * thenCombine方法，它接收名为BiFunction的第二参数，这个参数定义了当两个CompletableFuture对象完成计算后，结果如何合并。
//         * 将两个完全不相干的CompletableFuture对象的结果整合起来，不同于thenCompose方法，不希望等到第一个任务完全结束才开始第二项任务。
//         * 与测试3相比，代码的可读性更好
//         */
//        Future<Double> futurePriceInUSD1 = CompletableFuture.supplyAsync(() -> shop.getPrice(product))
//                .thenCombine(CompletableFuture.supplyAsync(() -> exchangeService.getRate(Money.EUR, Money.USD)),
//                        (price, rate) -> price * rate);
//        System.out.println("合并两个独立的CompletableFuture对象:" + futurePriceInUSD1.get());

        /**
         * 测试5：响应 CompletableFuture 的 completion 事件
         *  希望尽快将不同商店中的商品价格呈现给你的用户，而不是像之前那样，等所有的数据都完备之后再呈现。
         *  只要有商店返回商品价格就在第一时间显示返回值，不再等待那些还未返回的商店（有些甚至会发生超时）
         *  CompletableFuture 的thenAccept方法 ， 它接收CompletableFuture执行完毕后的返回值做参数
         *
         * thenAccept方法已经定义了如何处理CompletableFuture返回的结果，一旦CompletableFuture计算得到结果，它就返回一个CompletableFuture<Void>。
         * 所以， map操作返回的是一个Stream<CompletableFuture<Void>>。对这个<CompletableFuture-<Void>>对象，能做的事非常有限，只能等待其运行结束，不过这也是你所期望的。
         * 你还希望能给最慢的商店一些机会，让它有机会打印输出返回的价格。为了实现这一目的，可以把构成Stream的所有CompletableFuture<Void>对象放到一个数组中，等待所有的任务执行完成。
         *
         *  allOf工厂方法接收一个由CompletableFuture构成的数组，数组中的所有CompletableFuture对象执行完成之后，它返回一个CompletableFuture<Void>对象,
         * ，用户可能会困惑是否后面还有一些价格没有返回，使用这个方法，可以在执行完毕之后打印输出一条消息“All shops returned results or timed out”。
         * BestPrice price is 218.5 (done in 1669 msecs)
         * LetsSaveBig price is 184.0 (done in 1860 msecs)
         * MyFavoriteShop price is 230.0 (done in 2707 msecs)
         * BuyItAll price is 230.0 (done in 2799 msecs)
         * All shops have now responded in 2800 msecs
         */
        long start = System.nanoTime();
        CompletableFuture[] futures = findPricesStream("myPhone27S")
                .map(f -> f.thenAccept(s -> System.out.println(s + " (done in " +((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in "+ ((System.nanoTime() - start) / 1_000_000) + " msecs");
    }

    public static Stream<CompletableFuture<String>> findPricesStream(String product) {
//        测试5：响应 CompletableFuture 的 completion 事件
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice1(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }


    public static List<String> findPrices(String product) {
//        测试2：使用CompletableFuture实现findPrices方法
        List<CompletableFuture<String>> priceFutures = shops.stream()
                //以异步方式取得每个shop中指定产品的原始价格
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice1(product), executor))
                //Quote对象存在时，对其返回的值进行转换
                .map(future -> future.thenApply(Quote::parse))
                //使用另一个异步任务构造期望的Future，申请折扣
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(toList());
        //等待流中的所有Future执行完毕，并提取各自的返回
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());

//        //测试1：以最简单的方式实现使用Discount服务的findPrices方法,顺序阻塞式执行
//        return shops.stream()
//                .map(shop -> shop.getPrice1(product)) // 取得每个shop对象中商品的原始价格
//                .map(Quote::parse)    // 在Quote对 象 中对shop返回的字符串进行转换
//                .map(Discount::applyDiscount) // 联系Discount服务，为每个Quote申请折扣
//                .collect(toList());
    }
}
