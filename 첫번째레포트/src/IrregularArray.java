/*
 * 파일명 : IrregularArray.java
 * 입력 : -
 * 출력 : 행의 개수와 열의 개수 및 데이터에 맞게 값 출력
 * 작성일 : 2020년 4월 일
 * 작성자 : 20176088 김경훈
 *
 * Q. 행의 개수와 열의 개수 및 데이터를 입력하여 불규칙한 배열의 결과를 출력
 */

import java.util.Scanner;


public class IrregularArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("배열의 정보를 입력하시오.");
        System.out.print("행의 개수 > ");
        int row = scanner.nextInt();        //행을 row변수에 넣습니다
        scanner.nextLine();         //enter에 대해서도 처리해줍니다.
        int intArray[][] = new int[row][];          //행을 초기화한 intarray 배열을 만듭니다.
        System.out.println("열의 개수와 데이터를 입력하시오>");
        int rCount = 0;
        while (rCount < row) {          //rCount을 이용하여 변하는 행의 개수에 맞춰서 while문 구상합니다.
            String readline = scanner.nextLine();           //하나의 열 전체를 readline 문자열 변수에 넣습니다.
            String[] newline = readline.split(" ", 2);          //띄어쓰기를 기준으로 나누어서 newline에 넣습니다.
            intArray[rCount] = new int[Integer.parseInt(newline[0])];
            int index = 0;
            for (String elem : newline[1].split(" ")){
                int intElem = Integer.parseInt(elem);
                intArray[rCount][index++] = intElem;
            }
            rCount++;
        }
        System.out.println("불규칙한 배열의 출력 결과");
        int index2 =0;
        while(index2 < row){

            for(int tmp : intArray[index2]){
                System.out.print(tmp+" ");
            }
            System.out.println();
            index2++;
        }

    }
}

