/*
 * 파일명 : CountWordEx.java
 * 입력 : 특정 문자를 입력
 * 출력 : 특정 문자로 시작하거나 끝나는 단어와 단어의 수를 출력
 * 작성일 : 2020년 5월 19일
 * 작성자 : 20176088 김경훈
 *
 * Q. input.txt파일에 포함된 내용을 읽어서 특정 문자로 시작하거나 끝나는 단어를 검색하여 그 수와 단어를 출력하라.
 */




import CountWordInterface.CountWordInterface;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

// 인터페이스 부분
class CountWord implements CountWordInterface {
    // 단어 배열 생성
    public String[] makeWordArray() {
        String[] wordArr = new String[0];
        String getLine = "";
        FileReader f_r = null;
        try {
            f_r = new FileReader("/Users/eddy/Documents/JavaClass/input.txt");  //파일 읽기 경로 설정

            int c;
            while ((c = f_r.read()) != -1) {
                getLine += (char) c;  // 읽어서 한 문장으로 만듬

                // 문장을 StringTokenizer 클래스를 통해 나눔
                StringTokenizer word = new StringTokenizer(getLine, "., -()");
                wordArr = new String[word.countTokens()];

                // 나눈 단어 배열을 하나씩 넣음
                for (int i = 0; i < wordArr.length; i++) {
                    wordArr[i] = word.nextToken();
                    wordArr[i] = wordArr[i].trim();  //trim를 통해 앞 뒤 공백을 제거
                }
            }
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
        return wordArr;
    }

    // 단어 배열 출력
    public void printWordArray(String[] wordArr) {
        System.out.println("단어들의 배열을 1줄에 7개의 단어씩 나열합니다.");
        System.out.println("**********************************************************************");
        int count = 0;

        for (int i = 0; i < wordArr.length; i++) {
            count++; // 하나씩 늘리며 단어 세기 추가

            // 한 줄에 단어 7개씩 출력하는 부분
            if (count % 7 == 0) {
                System.out.print("  " + wordArr[i]);
                System.out.println();

            } else {
                System.out.print("  " + wordArr[i]);
            }
        }
        System.out.println();
        System.out.println("**********************************************************************");
    }


    public int countCWord(char c, boolean head, String[] arr) {
        int num = 0;
        if (head) {
            for (int i = 0; i < arr.length - 1; i++) { // 배열 마지막에 공백이 있으므로 길이의 -1를 해줌
                if (c == Character.toLowerCase(arr[i].charAt(0))) {
                    System.out.print(arr[i] + " ");
                    num++;
                }
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (c == Character.toLowerCase(arr[i].charAt(arr[i].length() - 1))) {
                    System.out.print(arr[i] + " ");
                    num++;
                }
            }
            System.out.println();
        }
        return num;
    }
}

public class CountWordEx {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        CountWord count = new CountWord();
        String[] arr = count.makeWordArray();
        count.printWordArray(arr);
        System.out.println("특정 문자로 시작하거나 끝나는 단어를 검색합니다.");
        System.out.print("검색하려는 문자를 입력하시오. 종료하려면 'exit'을 입력하시오 >> ");
        String s = scanner.next();      //하나씩 읽는다
        while (!s.equals("exit")) {     //exit가 나올 때 까지 반복
            char c = s.charAt(0);
            boolean head;
            System.out.println("\n" + c + "로 시작하는 단어를 검색합니다.");
            head = true;        //true = c로 시작하는 단어를 의미
            int num = count.countCWord(c, head, arr);
            System.out.println(c + "로 시작하는 단어의 수는 " + num + " 입니다");
            System.out.println("\n" + c + "로 끝나는 단어를 검색합니다.");
            head = false;       //false = c로 끝나는 단어 의미
            int num2 = count.countCWord(c, head, arr);
            System.out.println(c + "로 끝나는 단어의 수는 " + num2 + " 입니다\n");
            System.out.println("특정 문자로 시작하거나 끝나는 단어를 검색합니다.");
            System.out.print("검색하려는 문자를 입력하시오. 종료하려면 'exit'을 입력하시오 >> ");
            s = scanner.next();
        }
        System.out.println("프로그램을 종료합니다.");

    }
}