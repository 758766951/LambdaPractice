package chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.util.stream.Collectors.toList;

//查找一个list中四个商店中同一种商品的价格测试
public class CompletableFutureTest1 {
    static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    public static void main(String[] args) {
//        查询多个在线商店，依据给定的产品或服务找出最低的价格

        /**
         * CompletableFuture类,它实现了Future接口,使用了Lambda表达式以及流水线的思想
         * CompletableFuture和Future的关系就跟Stream和Collection的关系一样
         */

//        //测试1：CompletableFuture类手动创建和工厂方法supplyAsync创建测试
//        Shop shop = new Shop("BestShop");
//        long start = System.nanoTime();
//        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
//        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
//        System.out.println("Invocation returned after " + invocationTime+ " msecs");
////        执行更多任务，比如查询其他商店
//        doSomethingElse();
////        在计算商品价格的同时
//        try {
//            double price = futurePrice.get();// 从Future对象中读取价格，如果价格未知，会发生阻塞
////            double price = futurePrice.get(5, TimeUnit.SECONDS);//TimeoutException
//            System.out.printf("Price is %.2f%n", price);
//        } catch (Exception e) {
//            System.out.println("output:"+e.getMessage());
//            throw new RuntimeException(e);
//
//        }
//        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
//        System.out.println("Price returned after " + retrievalTime + " msecs");

        /**
         * 测试2：顺序查找一个list中四个商店中同一种商品的价格
         * Done in 4213 msecs， findPrices方法的执行时间仅比4秒钟多了那么几毫秒，
         * 因为对这4个商店的查询是顺序进行的，并且一个查询操作会阻塞另一个，每一个操作都要花费大约1秒左右的时间计算请求商品的价格。你怎样才能改进这个结果呢？
         */
        /**
         * 测试3：改进上一个测试，使用并行流对请求进行并行操作
         * Done in 1181 msecs
         */
        /**
         * 测试4：改进上一个测试,使用 CompletableFuture 发起异步请求
         * Done in 2202 msecs,此时会发现，该版本会比使用并行流对请求进行并行操作慢，只是比顺序执行阻塞版本快
         * 原因：它们内部采用的是同样的通用线程池，默认都使用固定数目的线程，具体线程数取决于Runtime.getRuntime().availableProcessors()的返回值。
         * 然而， CompletableFuture允许你对执行器（ Executor）进行配置，尤其是线程池的大小，让它以更适合应用需求的方式进行配置，满足程序的要求，
         * 而这是并行流API无法提供的。
         */
        /**
         * 测试5：改进上一个测试,使用定制的执行器
         * 创建一个线程池，线程池中线程的数目为 100和商店数目二者中较小的一个值
         *  Done in 1178 msecs
         *  如果你进行的是计算密集型的操作，并且没有I/O，那么推荐使用Stream接口
         *  如果你并行的工作单元还涉及等待I/O的操作（包括网络连接等待），那么使用CompletableFuture灵活性更好
         */
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");




    }

//
//    public static List<String> findPrices(String product) {

//    }


    public static List<String> findPrices(String product) {
//        测试5：改进上一个测试,使用定制的执行器
        //创建一个线程池，线程池中线程的数目为 100和商店数目二者中较小的一个值
        //Java程序无法终止或者退出一个正在运行中的线程，所以最后剩下的那个线程会由于一直等待无法发生的事件而引发问题。
        // 与此相反，如果将线程标记为守护进程，意味着程序退出时它也会被回收。这二者之间没有性能上的差异。
        final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true); //使用守护线程——这种方式不会阻止程序的关停
                        return t;
                    }
                });

        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)), executor))
                .collect(toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());

//        List<CompletableFuture<String>> priceFutures = shops.stream()
//                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f",
//                        shop.getName(), shop.getPrice(product))))
//                .collect(toList());
////        CompletableFuture类中的join方法和Future接口中的get有相同的含义，并且也声明在Future接口中，
////        它们唯一的不同是join不会抛出任何检测到的异常。
//        return priceFutures.stream().map(CompletableFuture::join).collect(toList());

//        测试3：改进上一个测试，使用并行流对请求进行并行操作
//               return shops.parallelStream()
//                .map(shop -> String.format("%s price is %.2f",shop.getName(), shop.getPrice(product)))
//                .collect(toList());

//        测试2：顺序查找一个list中四个商店中同一种商品的价格
//        return shops.stream()
//                .map(shop -> String.format("%s price is %.2f",shop.getName(), shop.getPrice(product)))
//                .collect(toList());


    }



//    public static void doSomethingElse(){
//        System.out.println("doSomethingElse:fruit shop");
//    }
}
