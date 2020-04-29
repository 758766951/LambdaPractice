package chapter3;

import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {
        /**
         * BiConsumer<T,U>这个接口接收两个泛型参数，跟Consumer一样，都有一个 accept方法，
         * 只不过，这里的，接收两个泛型参数，对这两个参数做下消费处理；
         * 1、void accept(T t, U u);
         *
         * 2、andThen，接收一个BiConsumer接口，先执行本接口的，再执行传入的参数。
         * default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
         *         Objects.requireNonNull(after);
         *         return (l, r) -> { accept(l, r); after.accept(l, r);
         *         };
         *     }
         */

        BiConsumer<String, String> biConsumer = (x, y) -> {
            System.out.println(x+" "+y);

        };
        BiConsumer<String, String> biConsumer1 = (x, y) -> {
            System.out.println(x+"--"+y);

        };
        biConsumer.andThen(biConsumer1).accept("tpyyes.com ", " java8");


        System.out.println("----------end使用BiConsumer----------");

    }

}
