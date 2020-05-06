package chapter10;

import chapter1.Apple;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * java.util.Optional<T>用法
 * 封装Optional值的类，变量存在时， Optional类只是对类简单封装。变量不存在时，缺失的值会被建模成一个“空”的Optional对象，由方法Optional.empty()返回。
 */
public class Main {
    public static void main(String[] args) {

//        /**
//         * 1、创建 Optional 对象
//         * Optional.empty()，声明一个空的Optional
//         * Optional.of(值)，依据一个非空值创建Optional， 如果值是一个null，这段代码会立即抛出一个NullPointerException，而不是等到你试图访问对象的属性值时才返回一个错误。
//         * Optional.ofNullable，可接受null的Optional，可以创建一个允许null值的Optional对象
//         */
////        Optional<Car> optCar1 = Optional.empty();
////        System.out.println(optCar1);//Optional.empty
//        Car car1 = null;
////        Optional<Car> optCar2 = Optional.of(car1);
////        System.out.println(optCar2);//java.lang.NullPointerException
//        Car car2 = new Car();
////        Optional<Car> optCar3 = Optional.of(car2);
////        System.out.println(optCar3);//Optional[chapter10.Car@12a3a380]
//        Optional<Car> optCar4 = Optional.ofNullable(car1);
//        Optional<Car> optCar5 = Optional.ofNullable(car2);
//        System.out.println(optCar4);//Optional.empty
//        System.out.println(optCar5);//Optional[chapter10.Car@12a3a380]
//        System.out.println("----------end使用1、创建 Optional对象----------");

        /**
         * 2、map与flatMap
         * map和flatmap的区别
         * map是把结果自动封装成一个Optional，但是flatMap不会对结果用Optional封装。
         */
//        将代码
//        String name = null;
//        if(insurance != null){ name = insurance.getName();}
//        重构为
//        Insurance insurance = new Insurance();
//        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
//        Optional<String> name = optInsurance.map(Insurance::getName);
//        System.out.println(name);//Optional.empty

//        将代码
//        public String getCarInsuranceName(Person person) {
//            return person.getCar().getInsurance().getName();
//        }
////        重构为
        Person person = new Person();
//        Optional<String> name = Optional.ofNullable(person)
//                .map(Person::getCar)
//                .map(Car::getInsurance)
//                .map(Insurance::getName);
//        System.out.println(name);
//        /*上面这段代码无法通过编译，optPerson是Optional<Person>类型的变量，调用map方法应该没有问题。
//        但getCar返回的是一个Optional<Car>类型的对象，这意味着map操作的结果是一个Optional<Optional<Car>>类型的对象。
//        因此，它对getInsurance的调用是非法的，因为最外层的optional对象包含了另一个optional对象的值，
//        而它当然不会支持getInsurance方法。说明你会遭遇了嵌套式optional结构。*/
//        /*而下面这段代码可以通过编译，因为flatMap不会对结果用Optional封装
//        flagMap会用流的内容替换每个新生成的流。换句话说，由方法生成的各个流会被合并或者扁平化为一个单一的流。*/
        Optional<String> name = Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName);
        //System.out.println(name); //???why NullPointerException
        //System.out.println("----------end使用2、map与flatMap ----------");

        /**
         * 3、其他方法
         * get()是这些方法中最简单但又最不安全的方法。如果变量存在，它直接返回封装的变量值，否则就抛出一个NoSuchElementException异常。
         * orElse(T other)，它允许你在Optional对象不包含值时提供一个默认值
         * orElseGet(Supplier<? extends T> other)是orElse方法的延迟调用版， Supplier方法只有在Optional对象不含值时才执行调用。
         * orElseThrow(Supplier<? extends X> exceptionSupplier)和get方法非常类似，它们遭遇Optional对象为空时都会抛出一个异常，但是使用orElseThrow你可以定制希望抛出的异常类型。
         * ifPresent(Consumer<? super T>)让你能在变量值存在时执行一个作为参数传入的方法，否则就不进行任何操作。
         * 使用 filter 剔除特定的值 ，接受一个谓词作为参数。 如果Optional对象的值存在，并且它符合谓词的条件，filter方法就返回其值；否则它就返回一个空的Optional对象。
         */
//        orElse() 和 orElseGet() 的不同之处
//        当对象为空而返回默认对象时，行为并无差异。
//        当 两个 Optional  对象都包含非空值，两个方法都会返回对应的非空值。不过，orElse() 方法仍然创建了 User 对象。与之相反，orElseGet() 方法不创建 User 对象。
//
//        User user = null;
//        User user2 = new User("xm", 18);
//
//        Optional.ofNullable(user).get();//NoSuchElementException
//        Optional.ofNullable(user).orElseThrow(()->new RuntimeException("orElseThrow抛异常啦"));
//
//        User result1 = Optional.ofNullable(user).orElse(user2);
//        User result2 = Optional.ofNullable(user).orElseGet(() -> user2);
//        System.out.println(result1.toString());
//        System.out.println(result2.toString());
//
//        User result1 = Optional.ofNullable(user2).orElse(createNewUser());
//        User result2 = Optional.ofNullable(user2).orElseGet(() -> createNewUser());
//        System.out.println(result1.toString());
//        System.out.println(result2.toString());
//
//        Optional.ofNullable(user).ifPresent(System.out::println);
//        Optional.ofNullable(user2).ifPresent(System.out::println);

//        Optional.ofNullable(user2)
//                .filter(u -> "xm".equals(u.getName()))
//                .ifPresent(x -> System.out.println("ok"));
//        System.out.println("----------end使用3、其他方法---------");

    }

//    public static User createNewUser() {
//        System.out.println("createNewUser");
//        return new User("createNewUser", 13);
//    }

}
