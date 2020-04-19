/*
 * 파일명 : RectangleAssignment.java
 * 입력 : -
 * 출력 : 입력에 맞는 사각형 면적, 둘레 출력
 * 작성일 : 2020년 4월 19일
 * 작성자 : 20176088 김경훈
 *
 * Q. 사각형을 나타내는 Rectangle 클래스를 작성하라.
 */

import java.util.Scanner;

class Rectangle {
    double width, height; //가로,세로
    String color; //색깔 선언

    Rectangle() { //디폴트 값의 사각형을 위한 무인자 생성자
        width = 1; //default =1로 선언
        height = 1; // default =1
        color = "white"; //default = white로 선언
    }

    Rectangle(double width, double height) { //위의 가로와 세로의 사각형 생성자
        this(); //디폴트 값(멤버 변수 초기화)
        this.width = width; //맴버변수를 매개변수로 초기화
        this.height = height;
    }

    Rectangle(double line) { //주어진 가로와 세로의 사각형을 위한 생성자
        this();
        width = line;
        height = line;
    }

    public double getArea() { //직사각형의 면적 계산 공식
        return (width * height);
    }

    public double getPerimeter() { //직사각형 둘레의 계산 공식
        return 2 * (width + height);
    }

}

public class RectangleAssignment {

    public static void main(String[] args) {
        Rectangle[] r = new Rectangle[3]; //객체 배열에 대한 레퍼런스 변수 선언
        Scanner scanner = new Scanner(System.in);
        //가로, 세로, 색깔 입력 받기
        System.out.print("가로>>");
        double width = scanner.nextDouble();
        System.out.print("세로>>");
        double height = scanner.nextDouble();
        System.out.print("색깔>>");
        String color = scanner.next();

        r[0] = new Rectangle(); //기본 생성자로 객체 생성
        r[1] = new Rectangle(width, height); //가로,세로 매개변수인 생성자로 객체 생성
        r[2] = new Rectangle(width); //가로나 세로인 하나의 길이만 받는 생성자로 객체 생성

        for (int i = 0; i < r.length; i++)
            System.out.println((i + 1) + ". 면적 = " + r[i].getArea() + ", 둘레 = " + r[i].getPerimeter());
    }

}