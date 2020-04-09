class Cal {
    public Cal() {} //class Cal의 생성자

    public double sum(double x, double y) {
        return (x + y);
    }
}

public class CalSum {
    public static void main(String[] args) {
        Cal c = new Cal(); //Cal 객체 생성

        System.out.println("sum(10, 20) = " + c.sum(10, 20)); //객체 c의 sum매소드 사용
        System.out.println("sum(10.0, 20.0) = " + c.sum(10.0, 20.0));
        System.out.println("sum(10.0, 20) = " + c.sum(10.0, 20));

    }

}