package designPattern.iteratorAndComposite.composite;

import java.util.Iterator;
import java.util.Stack;

//之前的写法是在MenuComponent类中使用print(),这是在“内部”自行处理遍历
//现在使用一个外部迭代器类CompositeIterator来处理
public class CompositeIterator implements Iterator {
    Stack stack = new Stack();

    //将所有要遍历的顶层组合的迭代器传入，使用栈存储
    public CompositeIterator(Iterator iterator){
        stack.push(iterator);
    }

    public Object next(){
        if(hasNext()){
            Iterator iterator = (Iterator)stack.peek();
            MenuComponent component = (MenuComponent)iterator.next();
            if(component instanceof Menu){
                stack.push(component.createIterator());
            }
            return component;
        }else{
            return null;
        }
    }


    public boolean hasNext(){
        if (stack.isEmpty())
            return false;
        else{
            //否则，从栈顶取出迭代器，看看是否还有下一个元素，若没有，就将其弹出堆栈，然后递归地调用hasNext
            Iterator iterator = (Iterator)stack.peek();
            if(!iterator.hasNext()){
                stack.pop();
                return hasNext();
            }else
                return true;
        }
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }
}
