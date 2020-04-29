package chapter3;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {
    public static void main(String[] args) {
        /**
         * Predicate<T>接口
         * 1、定义了一个名叫test的抽象方法，它接受泛型T对象，并返回一个boolean
         * boolean test(T t);
         * 2、对应了java的连接符号&&
         *  default Predicate<T> and(Predicate<? super T> other) {
         *         Objects.requireNonNull(other);
         *         return (t) -> test(t) && other.test(t);
         *     }
         * 3、对应了java的连接符号!
         * default Predicate<T> negate() {
         *         return (t) -> !test(t);
         *     }
         * 4、对应了java的连接符号||
         *  default Predicate<T> or(Predicate<? super T> other) {
         *         Objects.requireNonNull(other);
         *         return (t) -> test(t) || other.test(t);
         *     }
         *  5、当做==操作符来使用
         *  static <T> Predicate<T> isEqual(Object targetRef) {
         *         return (null == targetRef)
         *                 ? Objects::isNull
         *                 : object -> targetRef.equals(object);
         *     }
         */

        Predicate<Integer> pre = t->t==2;
        System.out.println(pre.test(2));

        int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<Integer> list=new ArrayList<>();
        for(int i:numbers) {
            list.add(i);
        }
        Predicate<Integer> p1=i->i>5;
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

        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("");
        listOfStrings.add("world");
        listOfStrings.add("hello");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        nonEmpty.stream().forEach(str -> System.out.print(str + " "));
        System.out.println("\n" + "----------end使用Predicate----------");
    }

    /**
     * 使用Predicate
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

}
