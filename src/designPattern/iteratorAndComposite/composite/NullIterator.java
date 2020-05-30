package designPattern.iteratorAndComposite.composite;

import java.util.Iterator;

/**
 *空迭代器，菜单项中是没有什么可以遍历的，如何实现菜单项的createIterator()方法
 *1.返回null,但如果这么做，客户端需要判断语句来判断返回值是否为null
 *2.返回一个空迭代器，hasNext()永远返回false,next返回null,这样客户端不要判断了。
 */
public class NullIterator implements Iterator {
    public Object next(){
        return null;
    }
    public boolean hasNext(){
        return false;
    }
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
