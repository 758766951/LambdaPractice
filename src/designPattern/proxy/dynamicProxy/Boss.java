package designPattern.proxy.dynamicProxy;

/**
 * Boss类，实现了ReadFile接口，可以批改文件
 */
public class Boss implements ReadFile {
    public void read() {
        System.out.println("I'm reading files.");
    }
}