/*	큐 자료구조에 generics 클래스를 선언하여
 *      - String, Integer, Point 큐 함수 삽입
 *      - 입력한 값을 push와 pop 이용하여 출력
 */

import java.util.*;

class GQueue<T> {
    int tos;
    int front;
    Object[] queue;

    public GQueue() {
        tos = 0;
        front = -1;
        queue = new Object[10];
    }

    public void push(T item) {          //push 부분 구현
        if (tos == 20)
            return;

        queue[tos] = item;
        tos++;

        if (!(item instanceof Point)) {
            System.out.print(item + " ");

        }

    }

    public T pop() {            //pop 부분 구현
        if (front == tos) //empty
            return null;
        front++;

        return (T) queue[front];

    }
}

class Point {           //Point 큐 구현
    private Object x;
    private Object y;

    Point(Object x, Object y) {
        this.x = x;
        this.y = y;
        System.out.print("Point (" + x + "," + y + ") ");

    }

    public String toString() {
        return ("Point (" + x + "," + y + ")");
    }

}

public class QueueGenerics {
    public static void main(String[] args) {

        GQueue<String> stringQueue = new GQueue<String>();
        System.out.print("Enqueue : ");
        stringQueue.push("seoul");
        stringQueue.push("busan");
        stringQueue.push("LA");


        System.out.print("\nDequeue : ");
        for (int i = 0; i < 3; i++)
            System.out.print(stringQueue.pop() + " ");

        GQueue<Integer> intQueue = new GQueue<Integer>();
        System.out.print("\nEnqueue : ");
        intQueue.push(1);
        intQueue.push(3);
        intQueue.push(5);
        System.out.print("\nDequeue : ");
        for (int i = 0; i < 3; i++)
            System.out.print(intQueue.pop() + " ");

        GQueue<Point> pointQueue = new GQueue<Point>();
        System.out.print("\nEnqueue : ");
        pointQueue.push(new Point(1, 2));
        pointQueue.push(new Point(3, 5));
        pointQueue.push(new Point(2, 4));
        System.out.print("\nDequeue : ");
        for (int i = 0; i < 3; i++)
            System.out.print(pointQueue.pop() + " ");
    }
}