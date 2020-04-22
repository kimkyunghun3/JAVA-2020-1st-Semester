class Circle{
    int x, y; //원의 중심
    int radius; //원의 반지름

    public Circle(int x, int y, int radius) { //Circle클래스의 생성자함수
        this.x =x;
        this.y = y;
        this.radius = radius;
    }

    public String toString() { //"Circle(2,3) 반지름5"와 같이 객체 출력하는 함수 재작성
        return "Circle(" + x + "," + y + ") 반지름" + radius;
    }

    public boolean equals(Object obj) {
        Circle p = (Circle)obj;
        if(x == p.x && y == p.y) return true;//두 객체의 중심이 같으면 true 출력
        else return false; //두 객체의 중심이 다르면 false 출력
    }
}

public class CircleApp {

    public static void main(String[] args) {
        Circle a = new Circle(2,3,5); // 중심 (2,3)에 반지름 5인 원
        Circle b = new Circle(2,3,30); // 중심 (2,3)에 반지름 30인 원
        System.out.println("원 a : " + a);
        System.out.println("원 b : " + b);
        if(a.equals(b))
            System.out.println("같은 원");
        else
            System.out.println("서로 다른 원");
    }

}