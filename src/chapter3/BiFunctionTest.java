package chapter3;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionTest {
    public static void main(String[] args) {
        /**
         * BiFunction<T, U, R>，
         * 1、R apply(T t, U u);接收两个参数T、U，返回一个值R对象
         * 2、先执行本身然后将结果作为传入函数的参数执行返回
         *  default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
         *         Objects.requireNonNull(after);
         *         return (T t, U u) -> after.apply(apply(t, u));
         *     }
         *
         */
        BiFunction<Integer,Integer,Integer> biFunction = (x, y) -> x+y;
        Integer apply2 = biFunction.apply(1, 2);
        System.out.println(apply2);

        BiFunction<Integer,Integer,Integer> multiple = (x, y) -> x*y;
        Function<Integer,Integer> square = x -> x*x;
        Integer res = multiple.andThen(square).apply(2,3);
        System.out.println(res);//3 36
        System.out.println("----------end使用BiFunction----------");

    }
}
