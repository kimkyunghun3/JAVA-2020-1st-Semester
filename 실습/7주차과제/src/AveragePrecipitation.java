/* 	Vector 켈랙션을 이용하여 강수량의 평균을 유지 관리하는 프로그램
 *  강수량 입력하여 Vector에 추가
 *  현재 입력된 모든 강수량, 평균을 출력
 */

import java.util.Scanner;
import java.util.*;

public class AveragePrecipitation {

    public static void main(String[] args) {
        System.out.print("강수량 입력 (0 입력시 종료) >> ");
        Scanner s = new Scanner(System.in); //강수량 입력 변수에 저장
        String str = s.next();
        int precipitation = Integer.parseInt(str); //입력받은 강수량(문자열)을 정수로 변환
        int sum = 0;  //강수량 총합 초기화

        Vector<Integer> vec = new Vector<Integer>(); //Vector 생성
        vec.add(precipitation); //Vector에 요소(강수량) 삽입
        Iterator<Integer> it = vec.iterator(); //Vector를 순차 탐색하기 위해 Iterator<Integer> 사용

        while (precipitation != 0) { //0입력 전까지 무한 반
            while (it.hasNext()) {
                int it_rain = it.next();
                sum += it_rain;
                System.out.print(it_rain + " ");
            }
            System.out.println();
            System.out.println("현재평균 " + sum / vec.size()); //현재평균 = 총합 / Vector의 현재 요소 갯수복(현재 입력개수 파악)

            System.out.print("강수량 입력 (0 입력시 종료) >> ");
            s = new Scanner(System.in);
            str = s.next();
            precipitation = Integer.parseInt(str);
            sum = 0;  //강수량 총합을 0으로 초기화

            vec.add(precipitation);
            it = vec.iterator(); //iterator 객체
        }
    }

}