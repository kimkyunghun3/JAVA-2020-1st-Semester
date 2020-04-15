import java.util.Scanner;

public class Assignment2 {
    public static void main(String args[]) {
        System.out.println("정수 3개를 입력하세요 ");
        Scanner scanner = new Scanner(System.in);

        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        int a;
        if (number1 > number2 && number1 < number3 || number1 < number2 && number1 > number3) {
            a = number1;
            System.out.println("중간 값은 " + a);
        }

        else if(number2 > number3 && number2 < number1 || number2 < number3 && number2 > number1) {
            a = number2;
            System.out.println("중간 값은 " + a);
        }
        else if(number3 > number1 && number3 < number2 || number3 < number1 && number3 > number2) {
            a = number3;
            System.out.println("중간 값은 " + a);
        }


    }
}
