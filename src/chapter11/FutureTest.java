package chapter11;

import java.util.concurrent.*;

public class FutureTest {
    /**
     * 1、Future 接口
     * Future接口在Java 5中被引入，设计初衷是对将来某个时刻会发生的结果进行建模。
     * 它建模了一种异步计算，返回一个执行运算结果的引用，当运算结束后，这个引用被返回给调用方。
     * Future 接口的局限性:很难表述Future结果之间的依赖性，将计算的结果与另一个查询操作结果合并
     */

    public static void main(String[] args) {
        // 创建ExecutorService，通过 它 你 可以向 线 程 池提交任务
        ExecutorService executor = Executors.newCachedThreadPool();
        // 向ExecutorService提交一个Callable对象
        Future<Double> future = executor.submit(new Callable<Double>() {
            //以异步方式在新的线程中执行耗时的操作
            public Double call() {
                return doSomeLongComputation();
            }
        });
        doSomethingElse(); // 异步操作进行的同时，你可以做其他的事情
        try {
            // 获取异步操作的结果， 如果最终被阻塞， 无法得到结果， 那么在最多等待1秒钟之后退出
            Double result = future.get(1, TimeUnit.SECONDS);
        } catch (ExecutionException ee) {
            System.out.println("计算抛出一个异常");
        } catch (InterruptedException ie) {
            System.out.println("当前线程在等待过程中被中断");
        } catch (TimeoutException te) {
            System.out.println("在Future对象完成之前超过已过期");
        }finally {
            System.exit(0);
        }
    }

    public static Double doSomeLongComputation(){
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        整形数(integral types)除以0会抛出异常
//        浮点数(floating-point types)除以0结果是infinity
//        double res = 1.5 *2.0;
        double res = 1/0;
        System.out.println("output: doSomeLongComputation--"+res);
        return res;
    }

    public static void doSomethingElse(){
        System.out.println("output: doSomethingElse");
    }
}
