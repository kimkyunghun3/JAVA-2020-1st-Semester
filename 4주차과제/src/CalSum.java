class Cal {
    public Cal() {}

    public double sum(double x, double y) {
        return (x + y);
    }
}

public class CalSum {
    public static void main(String[] args) {
        Cal c = new Cal();

        System.out.println("sum(10, 20) = " + c.sum(10, 20));
        System.out.println("sum(10.0, 20.0) = " + c.sum(10.0, 20.0));
        System.out.println("sum(10.0, 20) = " + c.sum(10.0, 20));

    }

}