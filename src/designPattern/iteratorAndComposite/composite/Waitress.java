package designPattern.iteratorAndComposite.composite;

 import java.util.Iterator;
 public class Waitress {
     MenuComponent allMenus;

     public Waitress(MenuComponent allMenus) {
         this.allMenus = allMenus;
     }

     public void printMenu(){
        allMenus.print();
    }

     public void printVegetarianMenu(){
         Iterator iterator = allMenus.createIterator();
         System.out.println("\nVEGETARIAN MENU");
         while(iterator.hasNext()){
             MenuComponent menuComponent = (MenuComponent)iterator.next();
//             if(menuComponent instanceof MenuItem){
//                 if(menuComponent.isVegetarian())
//                     menuComponent.print();
//             }
//         try catch是一种处理错误的方法，而不是程序逻辑的方法，用在此处可能不恰当
//         但用下面的写法替代上面的方法，是为了保持客户端的透明性
             try {
                 if(menuComponent.isVegetarian())
                     menuComponent.print();
             }catch (UnsupportedOperationException ex){}

         }
     }
}
