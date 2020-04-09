import java.util.Scanner;

class Dictionary {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word) {
        String answer = "";

        for (int i = 0; i < 5; i++) {
            if (kor[i].equals(word)) {
                answer = eng[i];
                break;
            }
        }
        return answer;
    }
}

public class Assignment4 {

    public static void main(String[] args) {
        Dictionary a = new Dictionary();

        System.out.println("한영 단어 검색 프로그램입니다.");
        System.out.print("한글 단어> ");
        Scanner scanner = new Scanner(System.in);
        String k = scanner.next();

        while (!k.contentEquals("그만")) {
            System.out.println(k + "은 " + a.kor2Eng(k));

            System.out.print("한글 단어> ");
            scanner = new Scanner(System.in);
            k = scanner.next();
        }

        scanner.close();
    }

}