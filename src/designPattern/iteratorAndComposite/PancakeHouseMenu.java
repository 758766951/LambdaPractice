package designPattern.iteratorAndComposite;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu{
    ArrayList menuItems;

    public PancakeHouseMenu(){
        menuItems = new ArrayList();
        addItem("K&B's Pancake Breakfast","Pancake with scrambled eggs",true,2.99);
        addItem("Regular Pancake Breakfast","Pancake with fried eggs,sauage",false,2.99);
        addItem("Blueberry Pancakes","Pancake made with fresh blueberries",true,3.49);
        addItem("Waffles","Waffles,with your choice of blueberries or strawberries",true,3.59);


    }
    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        menuItems.add(menuItem);
    }

//    public ArrayList getMenuItems(){
//        return menuItems;
//    }
    //用下面的方法改写上面的方法，上面的方法会暴露内部实现
    public Iterator createIterator(){
        return menuItems.iterator();
    }
    //其他菜单方法
}
