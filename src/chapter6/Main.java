package chapter6;

import chapter1.Apple;
import chapter4_5.Dish;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

//用流收集数据，区分Collection、 Collectors和collect

/**
 * Collection集合类的顶层接口
 * collect终端操作,是一个归约操作
 * Collector收集器接口，接口中方法的实现决定了如何对流执行归约操作,
 * Collectors实用类提供了很多静态工厂方法，可以方便地创建常见收集器的实例
 */
public class Main {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

//        /**
//         * 1、收集器用作高级归约
//         * collect(Collectors.toList())
//         */
//        List<Integer> dishNameLengths = menu.stream()
//                .map(Dish::getName)
//                .map(String::length)
//                .collect(Collectors.toList());
//        System.out.println(dishNameLengths.toString());
//        System.out.println("----------end使用1、收集器用作高级归约----------");

        /**
         * 2、预定义收集器
         * 将流元素归约和汇总为一个值
         * Collectors.counting()
         * Collectors.maxBy和Collectors.minBy,这两个收集器接收一个Comparator参数来比较流中的元素。
         * Collectors类专门为汇总提供了一个工厂方法：Collectors.summingInt。它可接受一个把对象映射为求和所需int的函数，并返回一个收集器
         * Collectors.summingLong和Collectors.summingDouble
         * Collectors.averagingInt，对应的averagingLong和averagingDouble
         * 使用summarizingInt工厂方法返回的收集器, 这个收集器会把所有这些信息收集到一个叫作IntSummaryStatistics的类
         * 连接字符串,joining工厂方法返回的收集器会把对流中每一个对象应用toString方法得到的所有字符串连接成一个字符串
         * 元素分组
         * Collectors.groupingBy
         * Collectors.collectingAndThen把收集器的结果转换为另一种类型,这个工厂方法接受两个参数,要转换的收集器以及转换函数，并返回另一个收集器。
         * 元素分区
         * Collectors.partitioningBy,分区是分组的特殊情况：由一个谓词（返回一个布尔值的函数）作为分类函数，它称分区函数。
         * 它最多可以分为两组——true是一组， false是一组。
         */
////        菜单里有多少种菜
//        long howManyDishes = menu.stream().collect(Collectors.counting());
////        等价于
//        long howManyDishes1 = menu.stream().count();
//        System.out.println(howManyDishes+"--"+howManyDishes1);
//
////        查找流中的最大值和最小值
//        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
//        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
//        mostCalorieDish.ifPresent(x->System.out.println(x.toString()));

//        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
//        System.out.println("totalCalories = "+totalCalories);

//        double avgCalories =  menu.stream().collect(averagingInt(Dish::getCalories));
//        System.out.println("avgCalories = "+avgCalories);
//
////        使用summarizingInt工厂方法返回的收集器, 这个收集器会把所有这些信息收集到一个叫作IntSummaryStatistics的类
//        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
//        System.out.println(menuStatistics.getAverage()+"--"+
//                menuStatistics.getCount()+"--"+menuStatistics.getSum()+"...");
//        System.out.println(menuStatistics);//IntSummaryStatistics{count=9, sum=4200, min=120, average=466.666667, max=800}
//
////        把菜单中所有菜肴的名称连接起来
//        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
//        System.out.println(shortMenu);
////        joining工厂方法有一个重载版本可以接受元素之间的分界符
//        String shortMenu1 = menu.stream().map(Dish::getName).collect(joining(", "));
//        System.out.println(shortMenu1);
//
////        把菜单中的菜按照类型进行分类，有肉的放一组，有鱼的放一组，其他的都放另一组
//        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().
//                collect(groupingBy(Dish::getType));
//        System.out.println(dishesByType.toString());//{FISH=[prawns, salmon], MEAT=[pork, beef, chicken], OTHER=[french fries, rice, season fruit, pizza]}
//
////        把热量不到400卡路里的菜划分为“低热量”（ diet），热量400到700卡路里的菜划为“普通”（ normal），高于700卡路里的划为“高热量”（ fat）。
//        Map<CaloricLevel, List<Dish>> dishesByCaloric = menu.stream().
//                collect(groupingBy(dish -> {
//                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//                    else if (dish.getCalories() <= 700) return
//                            CaloricLevel.NORMAL;
//                    else return CaloricLevel.FAT;
//                }));
//        System.out.println(dishesByCaloric);//{DIET=[chicken, rice, season fruit, prawns], FAT=[pork], NORMAL=[beef, french fries, pizza, salmon]}
//
////        多级分组,双参数版本的Collectors.groupingBy
//        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
//                menu.stream().collect(groupingBy(Dish::getType,groupingBy(dish -> {
//                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//                    else if (dish.getCalories() <= 700) return
//                            CaloricLevel.NORMAL;
//                    else return CaloricLevel.FAT;
//                })));
//        System.out.println(dishesByTypeCaloricLevel);
//        //{MEAT={DIET=[chicken], NORMAL=[beef], FAT=[pork]}, OTHER={DIET=[rice, season fruit], NORMAL=[french fries, pizza]}, FISH={DIET=[prawns], NORMAL=[salmon]}}

////        按子组收集数据,数一数菜单中每类菜有多少个
//        Map<Dish.Type, Long> typesCount = menu.stream().collect(
//                groupingBy(Dish::getType, counting()));
//        System.out.println(typesCount);//{MEAT=3, OTHER=4, FISH=2}
//
////        查找菜单中热量最高的菜肴
//        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().
//                        collect(groupingBy(Dish::getType,
//                        maxBy(comparingInt(Dish::getCalories))));
//        System.out.println(mostCaloricByType);//{MEAT=Optional[pork], FISH=Optional[salmon], OTHER=Optional[pizza]}
//
////        查找每个子组中热量最高的Dish
//        Map<Dish.Type, Dish> mostCaloricByType = menu.stream()
//                .collect(groupingBy(Dish::getType,
//                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)),Optional::get)));
//        System.out.println(mostCaloricByType);//{FISH=salmon, MEAT=pork, OTHER=pizza}
//
////        把菜单按照素食和非素食分开
//        Map<Boolean, List<Dish>> partitionedMenu =
//                menu.stream().collect(partitioningBy(Dish::isVegetarian));
//        System.out.println(partitionedMenu);//{false=[pork, beef, chicken, prawns, salmon], true=[french fries, rice, season fruit, pizza]}
//        List<Dish> vegetarianDishes = partitionedMenu.get(true);
//        System.out.println(vegetarianDishes.toString());

//        将前n个数字按质数和非质数分区
        int n=10;
        Map<Boolean, List<Integer>> partitionPrimes = IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
        System.out.println(partitionPrimes.toString());//{false=[4, 6, 8, 9, 10], true=[2, 3, 5, 7]}

        System.out.println("----------end使用2、预定义收集器----------");


    }

    public enum CaloricLevel {DIET, NORMAL, FAT}

//    判断一个数是否是质数
    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }


}
