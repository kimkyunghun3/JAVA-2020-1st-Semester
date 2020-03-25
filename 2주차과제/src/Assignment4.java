import java.util.Scanner;

public class Assignment4 {
    public static void main(String args[]) {
        System.out.println("연산>> ");
        Scanner scanner = new Scanner(System.in);

        int number1 = scanner.nextInt();
        String help = scanner.next();
        int number2 = scanner.nextInt();
        int a;

        if( help.equals("+")) {
            a = number1 + number2;
            System.out.println(number1+"+"+number2+"의 계산 결과는 "+ a);
        }
        else if( help.equals("-")) {
            a = number1 - number2;
            System.out.println(number1+"-"+number2+"의 계산 결과는 "+ a);
        }
        else if(help.equals("*")) {
            a = number1 * number2;
            System.out.println(number1+"*"+number2+"의 계산 결과는 "+ a);
        }
        else if(help.equals("/")) {
            if (number2 == 0)
                System.out.println("0으로 나눌 수 없습니다.");
            else
                System.out.println("나눗셈 결과 : " + (number1/number2));
        }

        scanner.close();

    }
}

