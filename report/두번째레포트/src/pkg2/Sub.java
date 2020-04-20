package pkg2;

public class Sub {
    int a, b;

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int calculate() {
        return a - b;
    }
}