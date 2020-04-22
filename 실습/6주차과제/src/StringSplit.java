import java.util.Scanner;

public class StringSplit {

    public static void main(String[] args) {
        System.out.print(">> ");
        Scanner scanner2 = new Scanner(System.in);
        String str2 = scanner2.nextLine();

        while(!str2.equals("exit")) {
            String s[] = str2.split(" "); //문자열을 단어로 분리하여 문자열 배열인 s에 저장
            System.out.println("단어 개수는 " + s.length); //단어의 개수 = 문자열 배열의 길이/행의 갯수

            for(int i = 0; i < s.length;i++) {//문자열 배열 s에 접근하여 단어를 출력
                System.out.println(s[i]);
            }
            System.out.print(">> ");
            scanner2 = new Scanner(System.in);
            str2 = scanner2.nextLine();
        }

        System.out.println("종료합니다.");
    }

}