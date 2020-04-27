/*  Scanner 클래스를 사용하여 6개의 학점(A, B, C, D, F)을 문자로 입력
 *     - ArrayList에 저장한 다음
 *     - ArrayList를 검색하여 학점을 점수(A=4.0, B-3.0, C=2.0, D=1.0, F=0)로 변환하여 평균을 출력하는 프로그램
 */

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class AverageGPA {

    public static void main(String[] args) {
        double sum = 0; //학점의 합을 초기화

        System.out.print("6개의 학점을 빈칸으로 분리입력(A/B/C/D/F) >> ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); //입력받은 문자열을 문자열 변수에 옮기기

        StringTokenizer strline = new StringTokenizer(str, " "); //문자열을 " "를 기준으로 토큰으로 나누
        ArrayList<String> arr = new ArrayList<String>(6); //6개의 학점을 한 곳에 저장하는 ArrayList 생성
        for (int i = 0; i < 6; i++)
            arr.add(strline.nextToken()); //자른 6개의 학점을 ArrayList에 저장

        for (int i = 0; i < arr.size(); i++) {
            String num = arr.get(i); //ArrayList에서 학점을 출력

            if (num.equals("A")) //학점에 따른 합계를 계산
                sum += 4.0;
            else if (num.equals("B"))
                sum += 3.0;
            else if (num.equals("C"))
                sum += 2.0;
            else if (num.equals("D"))
                sum += 1.0;
            else if (num.equals("F"))
                sum += 0;
        }

        System.out.println("학점 평균 = " + sum / 6); //학점의 평균 계산
    }

}