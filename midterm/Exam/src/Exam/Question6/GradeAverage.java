package Exam.Question6;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeAverage {
    public static void main(String args[]) {
        int count = 0;
        while (count != 5) {            //5번 돌리도록 구현
            ArrayList<String> a = new ArrayList<String>();
            Scanner scanner = new Scanner(System.in);
            System.out.print("6개의 학점을 빈칸으로 분리하여 입력하시오 >> ");
            for (int i = 0; i < 6; i++) {           //각 학점을 분리하여 계산하도록 구현
                String grades = scanner.next();
                a.add(grades);
            }
            double average = 0;         //average 초기화
            double sum = 0;         //sum 초기화

            boolean breakpoint = true; //invalid false

            for (int i = 0; i < 6; i++) {
                String grade = a.get(i);
                if (grade.length() > 2) {       //문자가 2개 초과면
                    System.out.println("Invalid grade : " + grade);
                    breakpoint = false;
                    break;

                } else if (grade.charAt(0) == 'E') {        // 0번째 글자가 E인 경우
                    System.out.println("Invalid grade : " + grade);
                    breakpoint = false;

                } else if (grade.length() == 2 && grade.charAt(1) != '+') {     // 글자 수가 2개 그리고 1번째의 문자가 '+'인 경우
                    System.out.println("Invalid grade : " + grade);
                    breakpoint = false;
                    break;
                } else {
                    if (grade.charAt(0) == 'A') {//학점에 따른 합계를 계산
                        sum += 4.0;
                    } else if (grade.charAt(0) == 'B') {
                        sum += 3.0;
                    } else if (grade.charAt(0) == 'C') {
                        sum += 2.0;
                    } else if (grade.charAt(0) == 'D') {
                        sum += 1.0;
                    } else if (grade.charAt(0) == 'F') {
                        sum += 0;
                    }
                }
                if (grade.length() == 2) {      //글자수가 2개 즉 +가 들어간 구간인 경우
                    sum += 0.3;
                }
                average = sum / 6;
            }
            if (breakpoint) {       //만약 breakpoint라면 평균값 출력 하도록 구현
                System.out.print("학점 평균 = " + average);
                System.out.println();
            }
            count++;
        }

    }
}