/*
 * 파일명 : FindPrimes.java
 * 입력 : -
 * 출력 : 각 줄의 10개씩 소수 50개 출력
 * 작성일 : 2020년 4월 7일
 * 작성자 : 20176088 김경훈
 *
 * Q. 각 줄에 10개씩 소수 50개를 출력
 */

public class FindPrimes
{
    public static boolean isPrime(int x)
    {
        for (int i = 2; i <= Math.sqrt(x); i++) {       //어떤수의 약수는 그 수의 제곱근보다 작거나 같은 수에서 나온 애들만 찾으면 나머지를 찾을 수 있습니다.
            if (x % i == 0) {           //1을 제외하고 자기 자신을 나눌 수 있느 수가 존재하지 않아야 합니다.
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int currentNumber = 2;          //1을 제외하고 시작해야 합니다.
        int primesCount = 0;

        while (primesCount < 50) {
            if (isPrime(currentNumber)) {
                primesCount++;          //소수의 수를 하나씩 증가시킵니다.

                System.out.print (currentNumber + " ");
                if (primesCount % 10 == 0) {            //10개가 입력되면 한 칸 띄우기 출력하도록 구현합니다.
                    System.out.println();
                }
            }

            currentNumber++;
        }
    }
}