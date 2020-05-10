package designPattern.observer;

public interface Subject {
    void registerObserver(Observer o);//添加观察者
    void removeObserver(Observer o);//删除观察者
    void  notifyObservers();//通知所有观察者
}
