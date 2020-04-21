/*
 * 파일명 : Shapes.java
 * 입력 : -
 * 출력 : 반지름과 면적 나오도록 출력
 * 작성일 : 2020년 4월 21일
 * 작성자 : 20176088 김경훈
 *
 * Q. 인터페이스 Shape을 구현한 클래스 Circle을 작성하라
 */

interface Shape {           //Shape 인터페이스 구현
    final double PI = 3.14;
    void draw();
    double getArea();
    default public void redraw() {      //redraw할 수 있도록 구현
        draw();
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void draw() {        //draw 구현
        System.out.print("다시 그립니다. "+"반지름이 " + radius + "인 원입니다.\n");
    }

    public double getArea() {
        return radius*radius*PI;
    }
}

public class Shapes {
    public static void main(String[] args) {
        Shape donut = new Circle(10);       //객체 생성
        donut.redraw();     //다시 draw하도록 실행
        System.out.println("면적은 " + donut.getArea());
    }
}