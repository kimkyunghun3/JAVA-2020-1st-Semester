/*
 * 파일명 : pkg1.Calc.java, pkg2.Add.java, Div.java, Mul.java, Sub.java
 * 입력 : 예시대로 입력
 * 출력 : 입력한 연산에 따른 결과 출력
 * 작성일 : 2020년 4월 21일
 * 작성자 : 20176088 김경훈
 *
 * Q. ②	pkg1 패키지에 Calc 클래스, pkg2 패키지에 Add, Sub, Mul, Div 클래스를 가지도록 작성하라
 */

package pkg1;

import java.util.Scanner;
//외부 패키지에 접근하기
import pkg2.Add;
import pkg2.Sub;
import pkg2.Mul;
import pkg2.Div;

public class Calc {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.print("두 정수와 연산자를 입력하시오>> ");
            Scanner s = new Scanner(System.in);

            int num1 = s.nextInt(); //피연산자1(정수형)
            String cal = s.next();  //연산자
            int num2 = s.nextInt();  //피연산자2 입력(정수형)

            if (cal.equals("+")) { //연산자가 덧셈일 때
                Add temp = new Add(); //Add클래스가 디폴트이므로 같은 패키지 내에서면 접근 가능
                //객체 생성
                temp.setValue(num1, num2);
                System.out.println(temp.calculate()); //덧셈 수행

            } else if (cal.equals("-")) {   //연산자가 뺄셈일 때
                Sub temp = new Sub();

                temp.setValue(num1, num2);
                System.out.println(temp.calculate());
            } else if (cal.equals("*")) {   //연산자가 곱셈일 때
                Mul temp = new Mul();

                temp.setValue(num1, num2);
                System.out.println(temp.calculate());
            } else if (cal.equals("/")) {   //연산자가 나눗셈일 때
                Div temp = new Div();
                if (num2 == 0)      //0으로 나눌려고 한다면
                    System.out.println("0으로 나눌 수 없습니다.");
                else {
                    temp.setValue(num1, num2);  //0으로 나눈것이 아닐 때
                    System.out.println(temp.calculate());
                }
            } else if (cal.equals("%")) {   //연산자에 없는 것을 사용할 때
                System.out.println("잘못된 연산자입니다.");
            }
        }
    }
}