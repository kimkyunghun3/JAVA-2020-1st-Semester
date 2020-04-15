import java.util.Scanner;

public class Assignment3 {
    public static void main(String args[]) {
        System.out.println("점 (x,y)의 좌표를 입력시오");
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if ((x >= 100) && (y >= 100) && (x <= 200) && (y <= 200)) {
            System.out.println("(" + x + "," + y + ")" + "은 사각형 (100,100)과 (200,200)안에 있습니다.");

        } else {
            System.out.println("(" + x + "," + y + ")" + "은 사각형 안에 없습니다.");
        }
    }


}
