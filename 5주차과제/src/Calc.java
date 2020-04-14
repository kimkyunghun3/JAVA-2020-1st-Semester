import java.util.Scanner;

class Add{
    private int a, b;


    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int calculate() {
        return a + b;
    }
}

class Sub{
    private int a, b;

    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int calculate() {
        return a - b;
    }
}

class Mul{
    private int a, b;

    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int calculate() {
        return a * b;
    }
}

class Div{
    private int a, b;

    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int calculate() {
        return a / b;
    }
}

public class Calc {

    public static void main(String[] args) {
        System.out.print("두 정수와 연산자를 입력하시오>> ");
        Scanner s = new Scanner(System.in);

        int num1 = s.nextInt(); //피연산자1
        String cal = s.next();  //연산자
        int num2 = s.nextInt();  //피연산자2 입력

        if(cal.equals("+")) { //연산자가 덧셈일 때
            Add temp = new Add();

            temp.setValue(num1, num2);
            System.out.println(temp.calculate()); //덧셈 수행
        }
        else if(cal.equals("-")) {
            Sub temp = new Sub();

            temp.setValue(num1, num2);
            System.out.println(temp.calculate());
        }
        else if(cal.equals("*")) {
            Mul temp = new Mul();

            temp.setValue(num1, num2);
            System.out.println(temp.calculate());
        }
        else if(cal.equals("/")) {
            Div temp = new Div();

            temp.setValue(num1, num2);
            System.out.println(temp.calculate());
        }
    }

}