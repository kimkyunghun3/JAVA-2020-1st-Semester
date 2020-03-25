import java.util.Scanner;

public class Assignment {
    public static void main(String args[]) {
        System.out.println("입력하세요");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();
        System.out.println(name);

        int number = scanner.nextInt();
        System.out.println(number);

        boolean bool = scanner.nextBoolean();
        System.out.println(bool);

        scanner.close();

    }

}
