package derived;

import base.Shape; //외부 패키지의 Shape클래스를 상속받기 위해 가지고 옴

public class Circle extends Shape { //외부 패키지에 있는 GraphicEditor클래스에서 접근하기 위해서 접근 지정자 = public
    public void draw() { System.out.println("Circle"); }
}