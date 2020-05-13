import java.io.*;
import java.util.*;

public class File {
    public static void writeToFile(FileReader fr, FileWriter fw) {
        int c;
        try {
            while((c = fr.read()) != -1) {
                fw.write((char)c); //파일에 있는 문자를 다른 파일에 하나씩 삽입
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
        catch(IOException e) {
            System.out.println("입출력 오류입니다.");
        }
    }

    public static void main(String[] args) {
        System.out.print("첫번째 파일이름을 입력하세요 >> ");
        Scanner scanner = new Scanner(System.in);
        String first_str = scanner.nextLine();
        System.out.print("두번째 파일이름을 입력하세요 >> ");
        String sec_str = scanner.nextLine();

        FileReader fReader = null;
        FileWriter fWriter = null;
        int c;
        try {
            fReader = new FileReader(first_str); //첫번째 파일 스트림 열기
            fWriter = new FileWriter("append.txt"); //합치는 파일
            writeToFile(fReader, fWriter); //첫번째 파일을 읽어 합치는 파일에 기록
            fReader.close();

            fReader = new FileReader(sec_str); //두번째 스트림 열기
            writeToFile(fReader, fWriter); //두번째 파일을 읽어 합치는 파일에 연이어 기록

            fReader.close();
            fWriter.close();
            System.out.println("프로젝트 폴더 밑에 append.txt 파일을 생성합니다.");
        }
        catch(FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
        catch(IOException e) {
            System.out.println("입출력 오류입니다.");
        }

    }

}