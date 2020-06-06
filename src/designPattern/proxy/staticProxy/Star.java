package designPattern.proxy.staticProxy;

/**
 * 真实角色
 */
public class Star implements People{

    public void sign() {
        System.out.println("我正在签合同");
    }
}
