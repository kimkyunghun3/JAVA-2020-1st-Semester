/*
 * 파일명 : FindPrimes.java
 * 입력 : -
 * 출력 : 각 줄의 10개씩 소수 50개 출력
 * 작성일 : 2020년 4월 일
 * 작성자 : 20176088 김경훈
 *
 * Q. 각 줄에 10개씩 소수 50개를 출력
 */

public class FindPrimes
{
    public static boolean isPrime(int x)
    {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int currentNumber = 2;
        int primesCount = 0;

        while (primesCount < 50) {
            if (isPrime(currentNumber)) {
                primesCount++;

                System.out.print (currentNumber + " ");
                if (primesCount % 10 == 0) {
                    System.out.println();
                }
            }

            currentNumber++;
        }
    }
}