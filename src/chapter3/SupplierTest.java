package chapter3;

import chapter1.Apple;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        /**
         * supplier<T>接口定义了一个叫作get的方法，它接受一个泛型T的对象，
         * 并返回一个泛型T的对象。
         * 每次调用get()方法时都会调用构造方法创建一个新对象。
         */
        //创建Supplier容器，声明为Apple类型，此时并不会调用对象的构造方法，即不会创建对象
        //等价于 Supplier<Apple> apple=() -> new Apple()，使用默认构造
        Supplier<Apple> apple = Apple::new;
        //调用get()方法，此时会调用对象的构造方法，即获得到真正对象
        Apple a1 = apple.get();
        System.out.println(a1.toString());
        System.out.println("----------end使用Supplier,默认构造----------");
        //如果想使用带一个参数的构造函数，适合Function接口
        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(310);
        System.out.println(a2.toString());
        System.out.println("----------end使用Function,单参数默认构造----------");
        //如果想使用带两个参数的构造函数，适合Function接口
        //等价于(color, weight) -> new Apple(color, weight);
        BiFunction<Integer, String, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(310, "red");
        System.out.println(a3.toString());
        System.out.println("----------end使用BiFunction,双参数默认构造----------");
        //如果是多个参数构造可以自己创建一个接口TriFunction<T, U, V, R>
        TriFunction<Integer, String, Boolean, Apple> c4 = Apple::new;
        Apple a4 = c4.apply(310, "red", true);
        System.out.println(a4.toString());
        System.out.println("----------end使用自定义TriFunction,多参数构造----------");
    }
}
