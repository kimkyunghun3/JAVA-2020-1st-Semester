import java.util.StringTokenizer;
import java.util.Scanner;

public class StringTockennizer {

    public static void main(String[] args) {
        System.out.print(">> ");
        Scanner scanner1 = new Scanner(System.in);
        String str1 = scanner1.nextLine();

        while (!str1.equals("exit")) { //"exit"를 입력할 때까지 무한 반복
            StringTokenizer st = new StringTokenizer(str1, " ");

            System.out.println("단어 개수는 " + st.countTokens()); //countTokens(): 토큰의 갯수 새기
            while (st.hasMoreTokens())
                System.out.println(st.nextToken()); //nextToken(): 다음 토큰의 내용 반환 즉, 문자열을 단어로 분리

            System.out.print(">> ");
            scanner1 = new Scanner(System.in); //입력 받기
            str1 = scanner1.nextLine(); //입력을 문자열로 옮기기
        }
        System.out.println("종료합니다.");

    }

}