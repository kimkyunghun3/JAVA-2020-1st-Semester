import java.util.Scanner;

public class Assignment5 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        float c;
        System.out.println("연산>>");
        float a=scanner.nextFloat();
        String op=scanner.next();
        float b=scanner.nextFloat();


        switch (op)
        {
            case "+":
                c=a+b;
                System.out.printf("%.1f+%.1f의 계산 결과는 %.1f",a,b,c);
                break;

            case "-":
                c=a-b;
                System.out.printf("%.1f-%.1f의 계산 결과는 %.1f",a,b,c);
                break;

            case "*":
                c=a*b;
                System.out.printf("%.1f*%.1f의 계산 결과는 %.1f",a,b,c);
                break;

            case "/":
                if(b!=0)
                {
                    c=a/b;
                    System.out.printf("%.1f/%.1f의 계산 결과는 %.1f",a,b,c);
                }
                else {System.out.println("0으로 나눌수 없습니다.");}
                break;

        }
        scanner.close();
    }

}

