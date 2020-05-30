package designPattern.iteratorAndComposite;


import java.util.ArrayList;

/**
 *例子：需求，合并对象村餐厅和对象村煎饼屋
 * 对象村餐厅的设计，MenuItem类包含名字，描述，是否是素食，价格，使用ArrayList存储菜单，可以轻易扩展菜单项
 * 对象村煎饼屋的设计，使用固定长度数组存储菜单MenuItem类
 * 考虑1：每次打印不同需求的菜单时，遍历这两个集合或者数组，取出菜单项打印，如果另外合并一家或多家餐厅，则需要遍历多个集合或数组，这样变成了针对具体实现类编码，而不是接口了，扩展不便。
 * 考虑2：使用迭代器模式
 */
public class Main {
    public static void main(String[] args){
        /**
         * 测试1：使用for循环遍历搜索
         */
//        Waitress waitress = new Waitress();
//        waitress.printPancakeHouseMenu();
//        waitress.printDinerMenu();

        /**
         * 测试2：迭代器模式改写后
         */
//        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
//        DinerMenu dinerMenu = new DinerMenu();
//        Waitress waitress = new Waitress(pancakeHouseMenu,dinerMenu);
//        waitress.printMenu();
        /**
         * 测试3：简化waitress写法，当有多个菜单合并时不需要修改waitress代码了
         */
        ArrayList menus = new ArrayList();
        menus.add(new PancakeHouseMenu());
        menus.add(new DinerMenu());
        Waitress waitress = new Waitress(menus);
        waitress.printMenu();


     }
}
