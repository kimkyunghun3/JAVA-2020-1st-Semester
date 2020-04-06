/*
 * 파일명 : IncomeTaxCal.java
 * 입력 : -
 * 출력 : 입력한 소득금액에 따른 소득세와 지방세 출력
 * 작성일 : 2020년 4월 7일
 * 작성자 : 20176088 김경훈
 *
 * Q. 2020년 귀속 종합소득세율표를 참고하여 소득 금액별 소득세와 지방소득세를 계산
 */

import java.util.Scanner;

public class IncomeTaxCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("소득금액을 천원단위로 입력하시오> ");
        int incomeaccount = scanner.nextInt();  //입력한 소득금액을 incomeaccount 변수에 저장

        if (incomeaccount <= 12000) {               //2020년 귀속 종합소득세율표에 따라 범위를 지정
            double incometaxsum = incomeaccount * 0.06 - 0;     //범위에 따른 세율을 곱하고 누진세를 뺀다
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");      //지방세는 소득세의 10분의 1의 값 출력
        } else if (incomeaccount > 12000 && incomeaccount < 46000) {
            double incometaxsum = (incomeaccount * 0.15) - 1080;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 46000 & incomeaccount < 88000) {
            double incometaxsum = (incomeaccount * 0.24) - 5220;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 88000 && incomeaccount < 150000) {
            double incometaxsum = (incomeaccount * 0.35) - 14900;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 150000 && incomeaccount < 300000) {
            double incometaxsum = (incomeaccount * 0.38) - 19400;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 300000 && incomeaccount < 500000) {
            double incometaxsum = (incomeaccount * 0.40) - 25400;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 500000) {
            double incometaxsum = (incomeaccount * 0.42) - 35400;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        }
        scanner.close();
    }
}
