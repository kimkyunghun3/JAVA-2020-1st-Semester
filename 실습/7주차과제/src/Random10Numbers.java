/*	Random 클래스를 이용하여 1 ~ 100 사이의 randon 정수를 10개 생성
 *      - Vector에 삽입
 *      - Vector에서 출력(for loop & get 과 while & Iterator 사용)
 */

import java.lang.Math; // Math.random() 사용하기 위해 패키지 import
import java.util.*;

public class Random10Numbers {

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>(10); //정수 값을 다루는 제너릭 백터 생성
        int i;

        for (i = 0; i < 10; i++) {
            int randon = (int) (Math.random() * 100 + 1); //  1 ~ 100 사이의 랜덤한 숫자 생성, +1는 인덱스때문에 추가
            v.add(randon); //제너리 백터에 요소 삽입
        }
        System.out.println("Random number 1 ~ 100, for loop & get :");      //한번만 출력되야 되므로 for 바깥에 출력
        for (i = 0; i < v.size(); i++) { // Vector로부터 정수를 읽어 출력할 때의 첫번째 방법 -> for loop 와 get()
            int number = v.get(i);

            System.out.print(number +" ");
        }
        System.out.println();       //줄넘김
        System.out.println("Random number 1 ~ 100, while loop & iterator :");       //한번만 출력되야 되므로 for 바깥에 출력
        Iterator<Integer> it = v.iterator(); //컬렉션 순차 검색을 위한 Iterator 생성
        while (it.hasNext()) { // Vector로부터 정수를 읽어 출력할 때의 두번째 방법 -> while loop와 Iterator
            int number2 = it.next();

            System.out.print(number2 +" ");
        }
    }

}