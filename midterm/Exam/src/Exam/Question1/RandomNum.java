package Exam.Question1;

public class RandomNum {
    static void getRandom(char from, char to) {         //getRandom 문자열 부분 구현
        if (Integer.valueOf(to) instanceof Integer) {
            char alpha = (char) ((Math.random() * (to - from)) + (int) from);     //알파벳과 문자열숫자 부분을 구현
            System.out.print(alpha + " ");
        }
    }

    static void getRandom(int from, int to) {       //getRandom 구현하여 랜덤에 to와 from 곱한 부분 변수로 저장
        int num = (int) (Math.random() * to + from);
        System.out.print(num + " ");
    }

    public static void main(String args[]) {
        for (int i = 0; i < 5; i++)
            getRandom('a', 'z');         //a부터 z까지 랜덤값 5개 출력
        System.out.println();

        int i = 0;
        while (i < 5) {
            getRandom('0', '9');     //0부터 9까지 5개 출력
            ++i;
        }
        System.out.println();

        int j = 0;
        do {
            getRandom(5, 20);           //5부터 20까지 범위에서 5개 출력
            j++;
        }
        while (j < 5);

        System.out.println();

    }
}