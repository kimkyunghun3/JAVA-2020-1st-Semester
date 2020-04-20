import java.util.Scanner;

public class StringTockennizer {

    public static void main(String[] args) {
        System.out.print(">> ");
        Scanner scanner2 = new Scanner(System.in);
        String str2 = scanner2.nextLine();

        while (!str2.equals("exit")) {
            String s[] = str2.split(" ");
            System.out.println("단어 개수는 " + s.length);

            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
            System.out.print(">> ");
            scanner2 = new Scanner(System.in);
            str2 = scanner2.nextLine();
        }

        System.out.println("종료합니다.");
    }

}
