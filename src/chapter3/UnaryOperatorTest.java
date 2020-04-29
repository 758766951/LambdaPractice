package chapter3;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {
    public static void main(String[] args) {
        /**
         * 使用UnaryOperator
         * UnaryOperator<T>接口继承Function接口，Funtion接口接收T对象返回R对象
         * 1、这个接口定义了一个静态方法，返回泛型对象的本身；
         *     static <T> UnaryOperator<T> identity() {
         *         return t -> t;
         *     }
         */
        UnaryOperator<Integer> dda = x -> x + 1;
        System.out.println(dda.apply(10));// 11
        UnaryOperator<String> ddb = x -> x + 1;
        System.out.println(ddb.apply("aa"));// aa1
        System.out.println("----------end使用UnaryOperator----------");
    }


}
