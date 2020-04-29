package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        /**
        * Function<T, R>接口定义了一个叫作apply的方法，它接受一个泛型T的对象，并返回一个泛型R的对象。
        * 1、R apply(T t);将Function对象应用到输入的参数上，然后返回计算结果。
        * 2、compose函数传入的函数首先被调用，得到的结果作为当前Function的入参使用
        * default <V > Function < V, R > compose(Function < ? super V, ? extends T > before){
        * Objects.requireNonNull(before);
        * return (V v) -> apply(before.apply(v));
        * }
        * 3、andThen是和compose相反的操作，当前Function首先被调用，得到的结果作为参数after的入参，调用after。
        * default <V > Function < T, V > andThen(Function < ? super R, ? extends V > after){
        * Objects.requireNonNull(after);
        * return (T t) -> after.apply(apply(t));
        * }
        * 4、对接受的元素，不做处理
        *static <T > Function < T, T > identity() {
        *return t -> t;
        *}
        */

        Function<Integer, Integer> name = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;
        int value1 = name.compose(square).apply(3);
        System.out.println("compose value1=" + value1);//18
        int value2 = name.andThen(square).apply(3);
        System.out.println("andThen value2=" + value2);//36

        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("hello");
        System.out.println("identity: "+identity);

        List<Integer> fuList = map(
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length()
        );
        fuList.stream().forEach(i -> System.out.print(i + " "));
        System.out.println("\n" + "----------end使用Function----------");
    }
    /**
     * 使用Function
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}
