package designPattern.iteratorAndComposite;

import java.util.Iterator;

public class DinerMenu implements Menu{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT","(Frakin') Bacon with lettuce & tomato on whole weate",true,2.99);
        addItem("BLT","Bacon with lettuce & tomato on whole weate",false,2.99);
        addItem("Soup of the day","Soup of the day,with a side of potato salad",false,3.29);
        addItem("Hotdog","A hot dog,...",true,3.05);


    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        if(numberOfItems>=MAX_ITEMS){
            System.err.println("Sorry,menu is full");
        }else{
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

//    public MenuItem[] getMenuItems(){
//        return menuItems;
//    }
    //用下面的方法改写上面的方法，上面的方法会暴露内部实现
    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }

    //其他菜单方法
}
