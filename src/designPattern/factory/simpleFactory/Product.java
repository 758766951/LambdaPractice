package designPattern.factory.simpleFactory;

public interface Product {
    /**
     * 假设生产的都是农作物
     */

    /**
     * 种植
     */
    void plant();
    /**
     * 生长
     */
    void grow();
    /**
     * 收获
     */
    void harvest();
}
