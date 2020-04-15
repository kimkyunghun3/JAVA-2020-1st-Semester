import java.util.Scanner;

abstract class Converter {
    abstract protected double convert(double src);
    abstract protected String srcString();
    abstract protected String destString();
    protected double ratio; //

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(srcString() + "을 " + destString() + "로 바꿉니다.");
        System.out.print(srcString() + "을 입력하세요>> ");
        double val = scanner.nextDouble();
        double res = convert(val);
        System.out.println("변환 결과: " + res + destString() + " 입니다");
        scanner.close();
    }
}

class Km2Mile extends Converter {

    Km2Mile(double ratio) {
        this.ratio = ratio;
    }

    protected double convert(double src) {
        return (src / ratio);
    }

    protected String srcString() {
        return "Km";
    }

    protected String destString() {
        return "mile";
    }

}

public class ConverterAssignment {

    public static void main(String[] args) {
        Km2Mile toMile = new Km2Mile(1.6);
        toMile.run();

    }

}