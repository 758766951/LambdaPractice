package chapter2;

import chapter1.Apple;

import java.util.ArrayList;
import java.util.List;

//行为参数化，循序渐进实现filter
public class Main {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(600, "red"));
        list.add(new Apple(300, "green"));
        list.add(new Apple(700, "green"));

//        List<Apple> res1 = filterApples(list, "green");
//        res1.stream().forEach(System.out::println);

//        List<Apple> res2 = filterApples(list, "green", 300, false);
//        res2.stream().forEach(System.out::println);

//        List<Apple> res3 = filterApples(list, new AppleGreenColorPredicate());
//        res3.stream().forEach(System.out::println);

//        /**
//         *      第四次尝试：使用匿名类
//         *      直接内联参数化filterapples方法的行为，此法不易理解，且笨重占用很多空间
//         */
//        List<Apple> res4 = filterApples(list, new ApplePredicate() {
//            public boolean test(Apple apple) {
//                return "red".equals(apple.getColor());
//            }
//        });
//        res4.stream().forEach(System.out::println);

//        //第五次尝试： Lambda 表达式
//        List<Apple> res5 = filterApples(list, (Apple apple) -> "red".equals(apple.getColor()));
//        res5.stream().forEach(System.out::println);


//        现在你可以把filter方法用在香蕉、桔子、Integer或是String的列表上了。这里有一个使用Lambda表达式的例子：
        List<Apple> res6 = filter(list, (Apple apple) -> "red".equals(apple.getColor()));
        res6.stream().forEach(System.out::println);

    }

    /*
     * 第一次尝试：筛选绿色苹果-->筛选绿色的苹果
     * 普通写法，函数调用，但随着需求变动，筛选越来越多的属性，代码扩展性差
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 第二次尝试：需要一种比添加很多参数更好的方法来应对变化的需求。
     * 根据flag判断使用哪种策略
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color,
                                           int weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 第三次尝试：根据抽象条件筛选
     * 让我们后退一步来看看更高层次的抽象。创建一个接口ApplePredicate，
     * 两个实现类AppleHeavyWeightPredicate和AppleGreenColorPredicate
     * 根据筛选属性不同，实现筛选不同属性的类
     * 但是，该怎么利用ApplePredicate的不同实现呢？你需要filterApples方法接受ApplePredicate对象，
     * 对Apple做条件测试。这就是行为参数化：让方法接受多种行为（或战略）作为参数，并在内部使用，来完成不同的行为。
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory)
            if (p.test(apple))
                result.add(apple);
        return result;
    }

    /**
     * 第六次尝试：将 List 类型抽象化
     * 目前，filterApples方法还只适用于Apple。
     * 还可以将List类型抽象化，从而超越眼前要处理的问题。
     * 创建接口Predicate<T>
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}

