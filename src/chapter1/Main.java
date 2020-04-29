package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Lamada表达式初次体验，排序
public class Main {

    public static void main(String[] args) {
        ArrayList<Apple> list = new ArrayList<>();
        list.add(new Apple(6, "red"));
        list.add(new Apple(3, "red"));
        list.add(new Apple(7, "red"));
        for (Apple a : list) {
            System.out.print(a.getWeight() + ",");
        }
        System.out.println("-------排序后----------");
        Collections.sort(list, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        /**
         * 行为参数化是一个很有用的模式，它可以轻松应对不断变化的需求。
         * 这种模式可以把一个行为（一段代码）封装起来，并通过传递和使用创建的行为将方法的行为参数化，
         * 这种做法类似于策略设计模式（定义一系列的算法,把每一个算法封装起来,并且使它们可相互替换）。
         */
        list.sort(Comparator.comparing(Apple::getWeight));

        for (Apple a : list) {
            System.out.print(a.getWeight() + ",");
        }
    }
}
