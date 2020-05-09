package chapter11;

import static chapter11.Shop.delay;

//以枚举类型定义的折扣代码
public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    //返回商品打折后的价格
    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }
    private static double apply(double price, Code code) {
        delay();// 模 拟 Discount服务响应的延迟
        return price * (100 - code.percentage) / 100;
    }
}
