package Exam.Question4;


import java.util.Scanner;

public class ReverseNum implements RevInterface {
    public int reverse(int input) {
        int[] reversechange = new int[String.valueOf(input).length()]; // 한 글자씩 담을 char형 배열 선언 - 문자열의 길이만큼

        for (int i = 0; i < reversechange.length; i++) {
            reversechange[i] = input % 10; // 문자열을 한 글자씩 담는다.
            input /= 10;
        }
        System.out.print("reversed number: ");      //거꾸로 되는 부분 출력
        for (int i = 0; i < reversechange.length; i++) {
            System.out.print(reversechange[i]);
        }
        System.out.println();       //띄어쓰기
        return 0;
    }

    public static void main(String[] args) {
        ReverseNum reverse = new ReverseNum();
        Scanner numbers = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = numbers.nextLine();

        while (isInteger(input)) {
            int number = Integer.parseInt(input);
            reverse.reverse(number); // 메소드 호출
            System.out.print("Enter a number: ");
            input = numbers.nextLine();
        }
        System.out.println("프로그램을 종료합니다.");
    }

    public static boolean isInteger(String num) {
        try {
            Integer.parseInt(num);    // int 형으로 변환해보고
            return true;                      // 이상없으면 true를 리턴
        } catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return false;                    // 이상 있으면 false를 리턴
        }
    }
}