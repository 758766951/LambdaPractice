package designPattern.singletonInstance;

public class Singleton {

    //1.饿汉式，静态随着类的加载而加载，即一进来就创建对象，称为饿汉式
//    private static Singleton instance = new Singleton();
//    private Singleton (){}
//    public static Singleton getInstance() {
//        return instance;
//    }

    //懒汉式，需要的时候才创建
//    private static Singleton instance;
//    private Singleton (){}
//    public static Singleton getInstance(){
//        if(instance==null){
//            instance=new Singleton();
//        }
//        return instance;
//    }


    //懒汉式(线程安全)
    /**
     * 这种写法能够在多线程中很好的工作，但是每次调用getInstance方法时都需要进行同步，
     * 造成不必要的同步开销，而且大部分时候我们是用不到同步的，所以不建议用这种模式。
     */
//    private static Singleton instance;
//    private Singleton() {}
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

        //双重检查模式 （DCL）
//        private volatile static Singleton instance;
//        private Singleton() {}
//        public static Singleton getInstance() {
//            if (instance == null) {
//                synchronized (Singleton.class) {
//                    if (instance == null) {
//                        instance = new Singleton();
//                    }
//                }
//            }
//            return instance;
//        }

    //    静态内部类单例模式
        private Singleton(){  }
        public static Singleton getInstance(){
            return SingletonHolder.sInstance;
        }
        private static class SingletonHolder {
            private static final Singleton sInstance = new Singleton();
        }
}




