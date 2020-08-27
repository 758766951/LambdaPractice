package chapter4_5;

import java.util.*;
import java.util.stream.Stream;

// 流的使用
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
//         * 1、筛选和切片
//         * 用谓词筛选filter方法
//         * 筛选各异的元素distinct方法
//         *  截短流limit(n)方法
//         *  跳过元素skip(n)方法,返回一个扔掉了前n个元素的流。
//         */
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
//        numbers.stream()
//                .filter(i -> i % 2 == 0)
//                .distinct()
//                .limit(2)
//                .forEach(System.out::println);
//
//        List<Dish> dishes1 = menu.stream()
//                .filter(d -> d.getCalories() > 300)
//                .skip(2)
//                .collect(toList());
//        System.out.println(dishes1.toString());
//        System.out.println("----------end使用1、筛选和切片----------");
//
//        /**
//         * 2、映射
//                * map方法，接受一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素。
//         * 流的扁平化,flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流。
//         */
//        //提取流中菜肴的名称
//        List<String> dishNames = menu.stream()
//                .map(Dish::getName)
//                .collect(toList());
//        System.out.println(dishNames.toString());
//        //找出每道菜的名称有多长
//        List<Integer> dishNameLengths = menu.stream()
//                .map(Dish::getName)
//                .map(String::length)
//                .collect(toList());
//        System.out.println(dishNameLengths.toString());
//
//        List<String> words = Arrays.asList("Hello","World");
//        List<String> uniqueCharacters =
//                words.stream()
//                        .map(w -> w.split(""))
//                        .flatMap(Arrays::stream)
//                        .distinct()
//                        .collect(Collectors.toList());
//        System.out.println(uniqueCharacters.toString());
//        System.out.println("----------end使用2、映射----------");
//
//        /**
//         * 3、查找与匹配
//         * anyMatch方法,流中是否有一个元素能匹配给定的谓词
//         * allMatch方法，流中的元素是否都能匹配给定的谓词
//         * noneMatch方法，流中没有任何元素与给定的谓词匹配
//         * findAny方法将返回当前流中的任意元素
//         * findFirst方法，查找第一个元素
//         */
//        if(menu.stream().anyMatch(Dish::isVegetarian)){
//            System.out.println("The menu is (somewhat) vegetarian friendly!!");
//        }
//        System.out.println("----------end使用anyMatch----------");
//
//        boolean isHealthy1 = menu.stream()
//                .allMatch(d -> d.getCalories() < 1000);
//        System.out.println(isHealthy1);
//        System.out.println("----------end使用allMatch----------");
//
//        boolean isHealthy2 = menu.stream()
//                .noneMatch(d -> d.getCalories() >= 1000);
//        System.out.println(isHealthy2);
//        System.out.println("----------end使用noneMatch----------");
//
//        Optional<Dish> dish = menu.stream()
//                        .filter(Dish::isVegetarian)
//                        .findAny();
//        dish.ifPresent(d -> System.out.println(d.getName()));
//        System.out.println("----------end使用findAny----------");
//
//        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5,6);
//        Optional<Integer> firstSquareDivisibleByThree =
//                someNumbers.stream()
//                        .map(x -> x * x)
//                        .filter(x -> x % 3 == 0)
//                        .findFirst(); // 9
//        firstSquareDivisibleByThree.ifPresent(System.out::println);
//        System.out.println("----------end使用findFirst----------");
//        System.out.println("----------end使用3、查找与匹配----------");

        /**
         * 4、归约
         * reduce方法,将流归约成一个值
         */
////        元素求和
////        reduce接受两个参数：一个初始值，这里是0； 一个BinaryOperator<T>来将两个元素结合起来产生一个新值
//        List<Integer> numbers = Arrays.asList(1, 2, 3);
//        int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
//        System.out.println(sum1);//6
////        无初始值
////        reduce还有一个重载的变体，它不接受初始值，但是会返回一个Optional对象：
//        Optional<Integer> sum2 = numbers.stream().reduce((a, b) -> (a + b));
//        System.out.println(sum2);
////        最大值和最小值
//        Optional<Integer> max = numbers.stream().reduce(Integer::max);
//        Optional<Integer> min = numbers.stream().reduce(Integer::min);
//        System.out.println("max="+max+",min="+min);
//
////        用map和reduce方法数一数流中有多少个菜
////        把流中每个元素都映射成数字1，然后用reduce求和。这相当于按顺序数流中的元素个数。
//        int count = menu.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
//        System.out.println("用map和reduce方法数一数流中有多少个菜--"+count);
//        System.out.println("----------end使用4、归约----------");

        /**
         * 5、数值流
         * 避免了暗含的装箱成本
         * 原始类型特化流接口：IntStream、 DoubleStream和LongStream
         * 将流转换为特化版本：mapToInt、 mapToDouble和mapToLong
         * 补充：Optional原始类型特化版本： OptionalInt、 OptionalDouble和OptionalLong
         * 生成某个范围内的数值，range和rangeClosed。这两个方法都是第一个参数接受起始值，第二个参数接受结束值。但range是不包含结束值的，而rangeClosed则包含结束值。
         */
//        int calories = menu.stream()
//                .mapToInt(Dish::getCalories)
//                .sum();
//        System.out.println("calories = "+calories);
//
//        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
//        Stream<Integer> menu1 = intStream.boxed();//转换回对象流
//        List<Integer> caloriesSortList = menu1.sorted().collect(toList());
//        System.out.println("caloriesSortList"+caloriesSortList.toString());

//        补充：Optional原始类型特化版本： OptionalInt、 OptionalDouble和OptionalLong
//        计算IntStream中的最大元素,如何区分没有元素的流和最大值真的是0的流呢?
//        IntStream中的max()方法返回值只能是OptionalInt类型，防止出现空集
//        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
//        int max = maxCalories.orElse(1);
//        System.out.println("max="+max);

//        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
//                .filter(n -> n % 2 == 0);
//        System.out.println(evenNumbers.count());//从 1 到 100 有50个偶数
//
////        数值流应用：勾股数
//        Stream<int[]> pythagoreanTriples =IntStream.rangeClosed(1, 100)
//                        .boxed()
//                        .flatMap(a -> IntStream.rangeClosed(a, 100)
//                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
//                        );
//        pythagoreanTriples.limit(5)
//                .forEach(t ->System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
//        System.out.println("----------end使用5、数值流----------");

        /**
         * 6、构建流
         * 由值创建流,静态方法Stream.of，通过显式值创建一个流。它可以接受任意数量的参数。
         * 使用empty得到一个空流
         * 由数组创建流,静态方法Arrays.stream从数组创建一个流。它接受一个数组作为参数。
         * 由文件生成流,java.nio.file.Files中的很多静态方法都会返回一个流
         * 如：Files.lines，它会返回一个由指定文件中的各行构成的字符串流
         * 由函数生成流：静态方法Stream.iterate和Stream.generate。这两个操作可以创建所谓的无限流：不像从固定集合创建的流那样有固定大小的流。
         * generate不是依次对每个新生成的值应用函数的。它接受一个Supplier<T>类型的Lambda提供新的值。
         */
//        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
//        stream.map(String::toUpperCase).forEach(System.out::println);

//        Stream<String> emptyStream = Stream.empty();
//        emptyStream.map(String::toUpperCase).forEach(System.out::println);

//        int[] numbers = {2, 3, 5};
//        int sum = Arrays.stream(numbers).sum();
//        System.out.println(sum);
//
//        文件中内容为
//         hello world java8 lambda
//        hi idea
//        long uniqueWords = 0;
//        try (Stream<String> lines =
//                        Files.lines(Paths.get("D:\\a.txt"), Charset.defaultCharset())) {
//                uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
//                    .distinct()
//                    .count();
//                System.out.println(uniqueWords);//6
//        } catch (IOException e) {
//        }
//
//        Stream.iterate(0, n -> n + 2)
//                .limit(10)
//                .forEach(System.out::println);

////        斐波拉契数列
//        Stream.iterate(new int[]{0, 1},t -> new int[]{t[1], t[0]+t[1]})
//                .limit(20)
//                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        System.out.println("----------end使用6、构建流----------");
    }
}
