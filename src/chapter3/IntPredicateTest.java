package chapter3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class IntPredicateTest {
    public static void main(String[] args) {
        //原始类型特化，避免装箱操作
        // IntPredicate
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;//无装箱
        System.out.print(evenNumbers.test(1000) + "--");
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 0;//有装箱
        System.out.print(oddNumbers.test(1000));
        System.out.println("\n" + "----------end使用IntPredicate----------");

    }
}