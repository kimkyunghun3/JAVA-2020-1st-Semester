import java.util.Scanner;

public class RandomGame {
    public static void main(String[] args) {
        System.out.println("Guess a magic number between 0 and 100");
        Scanner scanner = new Scanner(System.in);
        double randomValue = Math.random();

        int intValue = (int) (randomValue * 100) + 1;
        while (true) {
            System.out.println("Enter your guess:");
            int guess = scanner.nextInt();
            if (guess == intValue) {
                System.out.println("yes, the number is " + guess);
                break;
            } else if (guess > intValue) {
                System.out.println("your guess it too high");
            } else if (guess < intValue) {
                System.out.println("your guess is too low");
            }
        }
        scanner.close();
    }
}
