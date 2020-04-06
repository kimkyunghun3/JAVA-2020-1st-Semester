/*
 * 파일명 : FindCharactersYear.java
 * 입력 : -
 * 출력 : 입력 년도의 60갑자 해 출력
 * 작성일 : 2020년 4월 7일
 * 작성자 : 20176088 김경훈
 *
 * Q. 년도를 입력받아 60갑자로 무슨 해인지 출력하는 프로그램을 구현
 */


import java.util.Scanner;

public class FindCharactersYear {
    public static void main(String[] args) {
        String[] tennumbers = {"경","신", "임", "계", "갑", "을", "병", "정", "무", "기"};  //십간 십진수를 하나의 배열에 저장
        String[] twelvenumbers = {"신","유", "술", "해", "자", "축", "인", "묘", "진", "사", "오", "미"}; //12진수를 하나의 배열에 저장
        Scanner scan = new Scanner(System.in);
        int nYear = 0;
        System.out.print("년도를 입력하시오> ");
        nYear = scan.nextInt(); //입력한 년도를 nYear 변수에 저장
        System.out.print(nYear + "년은 \"");
        System.out.println(tennumbers[(nYear % 10)] + twelvenumbers[(nYear % 12)] +'"'+"년입니다"); //십진수와 12진수를 활용하여 공식 구현
        scan.close();
    }
}
