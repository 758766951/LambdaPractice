package designPattern.iteratorAndComposite.composite;


/**
 * 新需求：希望在午餐后加一份餐后甜点的“子菜单”，但是不能真的把它赋值给菜单项数组，因为类型不同，所以不能这么做。当前设计已经无法满足需求了，我们需要某种属性结构可以容纳菜单、子菜单和菜单项。
 * 考虑：组合模式
 */
public class Main {
    public static void main(String[] args){
        /**
         * 测试4： 加入新需求后，使用组合模式重构代码
         * 内部迭代
         */
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU","Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU","Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU","Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU","Dessert of course");

        MenuComponent allMenus = new Menu("ALL MENUS","All Menu combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        //加入菜单项
        dinerMenu.add(new MenuItem("pasta","...",true,3.89));
        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("Apple Pie","...",true,1.59));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
        System.out.println("\n-----测试4结束-------");
        /**
         * 测试5：外部迭代器
         * 使waitress可以游走整个菜单，挑出素食
         * 之前的写法是在MenuComponent类中使用print(),Menu继承并重写print()方法，这是在“内部”自行处理遍历
         * 现在使用一个外部迭代器类CompositeIterator来处理
         */

        waitress.printVegetarianMenu();



    }
}
