import java.util.Scanner;

public class FindCharactersYear {
    public static void main(String[] args) {
        String[] tennumbers = {"신", "임", "계", "갑", "을", "병", "정", "무", "기", "경"};
        String[] twelvenumbers = {"유", "술", "해", "자", "축", "인", "묘", "진", "사", "오", "미", "신"};
        Scanner scan = new Scanner(System.in);
        int nYear = 0;
        System.out.print("년도를 입력하시오> ");
        nYear = scan.nextInt();
        System.out.print(nYear + "년은 \"");
        System.out.println(tennumbers[(nYear % 10) - 1] + twelvenumbers[(nYear % 12) - 1] + "\"년입니다");
        scan.close();
    }
}
