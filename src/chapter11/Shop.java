package chapter11;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private String name;
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
    public Shop(){}
    public Shop(String shopName){this.name=shopName;}

    private static final Random random = new Random();

//    获取产品的价格，添加折扣代码，以ShopName:price:DiscountCode的格式返回一个String类型的值
    public String getPrice1(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[ random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }


//    获取产品的价格
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
//       // 创建一个代表异步计算的CompletableFuture实例， 它会包含计算的结果
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
////        创建了另一个线程去执行实际的价格计算工作，不等该耗时计算任务结束，直接返回一个Future实例。
//        new Thread( () -> {
//            try {
//                double price = calculatePrice(product);// 在另一个线程中以异步方式执行计算
//                futurePrice.complete(price);// 需长时间计算的任务结束并得出结果时，设置Future的返回值
//            } catch (Exception ex) {
//                futurePrice.completeExceptionally(ex);//completeExceptionally方法将导致CompletableFuture内发生问题的异常抛出
//            }
//        }).start();
//        return futurePrice;

        /**
         * 使用工厂方法supplyAsync创建CompletableFuture
         *  supplyAsync方法接受一个生产者（ Supplier）作为参数，返回一个CompletableFuture对象，该对象完成异步执行后会读取调用生产者方法的返回值。
         *  提供了同样的错误管理机制
         */
        //与上面手动创建的代码完全等价
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    //依据产品的名称，生成一个随机值作为价格
    public double calculatePrice(String product) {

//        delay();
//        return random.nextDouble() * product.charAt(0) + product.charAt(1);
        randomDelay();
        return product.charAt(0) + product.charAt(1);

    }


//    模拟1秒钟延迟
    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    模拟生成0.5秒至2.5秒随机延迟的方法
    public static void randomDelay() {
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
