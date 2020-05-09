package chapter11;

public enum Money {
    EUR(0),
    USD(1);
    private int value;
    Money(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
