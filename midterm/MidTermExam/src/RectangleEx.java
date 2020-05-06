public class RectangleEx {
    int x, y, width, height;

    public RectangleEx(int a, int b) {      //매개변수가 2개인 생성자 생성
        x = a;
        y = b;
        width = a;
        height = b;
    }

    public RectangleEx() {          //매개변수가 없는 생성자 생성
        x = 5;
        y = 5;
        width = 5;
        height = 5;
    }

    public RectangleEx(int a) {     //매개변수가 1개인 생성자 생성
        x = a;
        y = a;
        width = a;
        height = a;

    }

    int recSize() {
        return (width * height);
    }   //사각형 면적을 계산하는 메소드

    void show() {
        System.out.println("Rectangle(" + x + "," + y + ")" + ": " + recSize());    // Rectangle의 크기와 면적을 출력하는 메소드
    }

    boolean contain(RectangleEx r) {        //지정한 Rectangle 안에 다른 Rectangle이 포함되는지 확인하는 Boolean 메소드 구현
        return ((r.x > x && r.x < x + width) && (r.y > y && r.y < y + height) && (r.x + r.width < x + width && r.y + r.height < y + height));
    }

    public String toString() {      //객체를 문자열로 만들어 주는 부분
        return ("Rectangle(" + x + "," + y + ")");
    }

    public static void main(String[] args) {
        RectangleEx r1 = new RectangleEx();     //매개변수가 없는 r1 객체 생성
        RectangleEx r2 = new RectangleEx(6);    // 매개변수가 하나인 r2 객체 생성
        RectangleEx r3 = new RectangleEx(4, 7); // 매개변수가 2개인 r3 객체 생성

        r1.show();      //show 메소드 호출
        r2.show();
        r3.show();
        if (r2.contain(r1))     //조건문을 통해 Rectangle 안에 있는지 확인 후 출력
            System.out.println(r1 + "을 " + r2 + "에 넣을 수 있습니다.");
        else
            System.out.println(r1 + "을 " + r2 + "에 넣을 수 없습니다.");
        if (r2.contain(r3))
            System.out.println(r3 + "을 " + r2 + "에 넣을 수 있습니다.");
        else
            System.out.println(r3 + "을 " + r2 + "에 넣을 수 없습니다.");
    }
}

