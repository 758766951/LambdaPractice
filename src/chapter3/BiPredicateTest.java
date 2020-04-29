package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BiPredicateTest {
    public static void main(String[] args) {
        /**
         * Predicate是个断言式接口其参数是<T,boolean>，也就是给一个参数T，返回boolean类型的结果。
         * 1、boolean test(T t);
         * 2、对应了java的三个连接符号&&
         * default Predicate<T> and(Predicate<? super T> other) {
         *         Objects.requireNonNull(other);
         *         return (t) -> test(t) && other.test(t);}
         *  3、对应了java的三个连接符号!
         *  default Predicate<T> negate() {
         *         return (t) -> !test(t);}
         *  4、对应了java的三个连接符号||
         *d efault Predicate<T> or(Predicate<? super T> other) {
         *         Objects.requireNonNull(other);
         *         return (t) -> test(t) || other.test(t);}
         *  5、可以当做==操作符来使用
         *  static <T> Predicate<T> isEqual(Object targetRef) {
         *         return (null == targetRef)? Objects::isNull: object -> targetRef.equals(object); }
         */
        BiPredicate<String,Integer> biPredicate=(str,i)->i.equals(str.length());
        System.out.println(biPredicate.test("hello",5));

        int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<Integer> list=new ArrayList<>();
        for(int i:numbers) {
            list.add(i);
        }
        Predicate<Integer> p1= i->i>5;
        Predicate<Integer> p2=i->i<20;
        Predicate<Integer> p3=i->i%2==0;
        List test1=list.stream().filter(p1.and(p2).and(p3)).collect(Collectors.toList());
        System.out.println(test1.toString());//[6, 8, 10, 12, 14]
        List test2=list.stream().filter(p1.and(p2).and(p3.negate())).collect(Collectors.toList());
        System.out.println(test2.toString());//[7, 9, 11, 13, 15]
        List test3=list.stream()
                .filter(p1.and(p2).and(p3.negate()).and(Predicate.isEqual(7)))
                .collect(Collectors.toList());
        System.out.println(test3.toString());//[7]
        System.out.println("----------end使用BiPredicate----------");

    }
}
