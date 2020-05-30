package designPattern.iteratorAndComposite;

import java.util.ArrayList;
import java.util.Iterator;

//该类用于结合现有的两个餐厅，打印各种菜单
public class Waitress {
//    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
//    ArrayList breakfastItems = pancakeHouseMenu.menuItems;
//
//    DinerMenu dinerMenu = new DinerMenu();
//    MenuItem[] lunchItems = dinerMenu.getMenuItems();
//
//    public void printPancakeHouseMenu(){
//        for(int i=0;i<breakfastItems.size();i++){
//            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
//            System.out.println(menuItem.toString());
//        }
//    }
//    public void printDinerMenu(){
//        for(int i=0;i<lunchItems.length;i++){
//            MenuItem menuItem = lunchItems[i];
//            if(menuItem!=null)
//               System.out.println(menuItem.toString());
//        }
//    }

    ArrayList menus;
    public Waitress(ArrayList menus){
        this.menus = menus;
    }
    public void printMenu(){
        Iterator menuIterator = menus.iterator();
        while (menuIterator.hasNext()){
            Menu menu = (Menu)menuIterator.next();
            printMenu(menu.createIterator());
        }
    }
//     Menu pancakeHouseMenu ;
//     Menu dinerMenu;
//
//     public Waitress(Menu pancakeHouseMenu,Menu dinerMenu){
//         this.pancakeHouseMenu = pancakeHouseMenu;
//         this.dinerMenu  = dinerMenu;
//     }

//     public void printMenu(){
//         Iterator pancakeIterator = pancakeHouseMenu.createIterator();
//         Iterator dinerIterator = dinerMenu.createIterator();
//         System.out.println("MENU\n----\nBREAKFAST");
//         printMenu(pancakeIterator);
//         System.out.println("\nLUNCH");
//         printMenu(dinerIterator);
//     }

    public void printMenu(Iterator iterator){
         while (iterator.hasNext()){
             MenuItem menuItem = (MenuItem)iterator.next();
             System.out.println(menuItem.toString());
         }
    }
}
