package chapter3;

import java.util.*;
import java.util.function.*;

//使用函数式接口Predicate、 Consumer和Function
public class BinaryOperatorTest {
    public static void main(String[] args) {
        /**
         * BinaryOperator<T>接口继承自BiFunciton接口
         * BinaryOperator<T>中有两个静态方法，是用于比较两个数字或字符串的大小。
         * 用于执行lambda表达式并返回一个T类型的返回值
         */
        BinaryOperator<Integer> biMin = BinaryOperator.minBy(Comparator.naturalOrder());
        System.out.println(biMin.apply(2, 3));
        BinaryOperator<Integer> biMax = BinaryOperator.maxBy(Comparator.naturalOrder());
        System.out.println(biMax.apply(2, 3));
        BinaryOperator<Integer> add = (n1, n2) -> n1 + n2;
        //apply方法用于接收参数，并返回BinaryOperator中的Integer类型
        System.out.println(add.apply(2, 3));
        System.out.println("----------end使用BinaryOperator----------");

    }







}
