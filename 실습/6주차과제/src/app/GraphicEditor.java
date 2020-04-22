package app;

import base.Shape; //외부 패키지의 클래스에 대한 새로운 객체를 생성할 때 import 이용
import derived.Circle;

public class GraphicEditor {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
    }
}