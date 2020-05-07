package Exam.Question5;

class GQueue<T> {
    int tos, front;
    Object[] queue;

    // 기본 값(매개변수 x)
    public GQueue() {
        tos = 0;
        front = -1;
        queue = new Object[10];
    }

    //push 클래스
    public void push(T item) {
        if (tos == 10)
            return;
        System.out.print(item + " ");
        queue[tos] = item;
        tos++;
    }
    //pop 클래스
    public T pop() {
        if (front == tos)
            return null;

        front++;
        return (T) queue[front];
    }

    public T getFront() {
        return (T) queue[front+1];
    }
}

class Circle {
    private int x, y, radius;
    //매개 변수 포함한 생성자 생성
    Circle (int x, int y, int radius) {
        this.x =x;
        this.y = y;
        this.radius = radius;
    }

    public double getSize() {
        return radius*radius*3.14;
    }
    public String toString() {      //toString 함수를 이용하여 문자열 출력(주소값이 아닌)
        return "Circle("+x+","+y+","+radius+")";
    }
}

public class MyQueue {
    public static void main(String args[]) {
        GQueue<Character> charGQueue = new GQueue<Character>(); //문자열 파트
        System.out.print("Enqueue(Character) : ");
        charGQueue.push('X');      // 푸시
        charGQueue.push('Y');
        charGQueue.push('Z');
        System.out.println();

        System.out.print("Dequeue(Character) : ");
        for (int i = 0; i < 3; i++)
            System.out.print(charGQueue.pop() + " ");      //하나씩 pop 하며 출력
        System.out.println();
        System.out.println();


        //Boolean 파트
        GQueue<Boolean> booleanGQueue = new GQueue<Boolean>();
        System.out.print("Enqueue(Boolean) : ");
        booleanGQueue.push(true);
        booleanGQueue.push(true);
        booleanGQueue.push(false);
        System.out.println();

        System.out.print("Dequeue(Boolean) : ");
        for (int i = 0; i < 3; i++)
            System.out.print(booleanGQueue.pop() + " ");    //하나씩 pop 하며 출력
        System.out.println();
        System.out.println();


        // Circle 파트
        GQueue<Circle> circleGQueue = new GQueue<Circle>();
        System.out.print("Enqueue(Circle) : ");
        circleGQueue.push(new Circle(1,1,2));       //객체 만들면서 push
        circleGQueue.push(new Circle(3,5,10));
        circleGQueue.push(new Circle(2,4,5));

        System.out.print("\nDequeue(Circle) : ");
        for (int i = 0; i < 3; i++) {
            double size = circleGQueue.getFront().getSize();        //원의 크기 나타내는 부분
            System.out.print(circleGQueue.pop()+":" + size + " ");
        }
        System.out.println();
        System.out.println();


    }
}