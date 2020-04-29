package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        /**
         * Consumer<T>
         * 1、定义了一个名叫accept的抽象方法，它接受泛型T的对象，没有返回（ void）
         * void accept(T t);
         * 2、先做本接口的accept操作，然后在做传入的Consumer类型的参数的accept操作
         *     default Consumer<T> andThen(Consum e r<? super T> after) {
         *         Objects.requireNonNull(after);
         *         return (T t) -> { accept(t); after.accept(t); };
         *     }
         */
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);// 12
            System.out.println(a + "_");// 12_
        };
        consumer.accept(10);

        Consumer<Integer> name = e -> System.out.println(e*2);
        Consumer<Integer> square = e -> System.out.println(e*e);
        name.andThen(square).accept(3);// 6 9

        forEach(Arrays.asList(1, 2, 3, 4, 5),
                (Integer i) -> System.out.print(i + " ")
        );
        System.out.println("\n" + "----------end使用Consumer----------");
    }
    /**
     * 使用Consumer
     */
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }

}
