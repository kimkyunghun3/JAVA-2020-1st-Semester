/*
 * 파일명 : pkg1.Calc.java, pkg2.Add.java, Div.java, Mul.java, Sub.java
 * 입력 : -
 * 출력 : 연산에 따른 결과 출력
 * 작성일 : 2020년 4월 19일
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
        System.out.print("두 정수와 연산자를 입력하시오>> ");
        Scanner s = new Scanner(System.in);

        int num1 = s.nextInt(); //피연산자1(정수형)
        String cal = s.next();  //연산자
        int num2 = s.nextInt();  //피연산자2 입력(정수형)

        if(cal.equals("+")) { //연산자가 덧셈일 때
            Add temp = new Add(); //Add클래스가 디폴트이므로 같은 패키지 내에서면 접근 가능
            //객체 생성
            temp.setValue(num1, num2);
            System.out.println(temp.calculate()); //덧셈 수행
            System.out.println("hello");
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
        else if(cal.equals("%")){
            System.out.println("잘못된 연산자입니다.");
        }
        else if(num2 ==0){
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }

}