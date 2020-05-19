/*
 * 파일명 : BufferReader.java
 * 입력 : 입력 파일명과 출력 파일명 입력
 * 출력 : 입력 파일을 읽어서 출력 파일에 입력 파일의 문장 수, 문장 수, 단어 수를 저장하고 화면에 각 수를 출력하라.
 * 작성일 : 2020년 5월 19일
 * 작성자 : 20176088 김경훈
 *
 * Q. 입력 파일명의 파일을 읽고 출력 파일에 문자 수, 문장 수, 단어 수를 저장하라.
 */

import java.util.*;
import java.io.*;

public class BufferReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력 파일명: ");
        String f1 = scanner.nextLine();
        System.out.print("출력 파일명: ");
        String f2 = scanner.nextLine();

        File src = new File(f1); //읽을 파일

        int c;
        int charcount = 0, wordcount = 0, stringcount = 0; //입력 파일에서 문자수, 단어수, 문장수
        char buf[] = new char[1024 * 10]; //텍스트 파일의 크기가 버퍼보다 작다는 가정

        try {
            //문자수 계산(단, 공백 포함x)
            FileReader fr = new FileReader(src);
            c = fr.read(buf);  //버퍼 크기만큼 읽어오기. c는 실제 읽은 문자수(공백까지 포함)
            charcount = c;    //문자수 계산

            //문자수, 단어수, 문장수 계산
            for (int i = 0; i < buf.length; i++) {
                if (buf[i] == ' ' || buf[i] == '.' || buf[i] == '!' || buf[i] == '?') {
                    wordcount++;
                    //. ! ? 다음에 빈칸이 오므로 이를 단어수에서 제외
                    if (buf[i] == ' ' && (buf[i - 1] == '.' || buf[i - 1] == '!' || buf[i - 1] == '?'))
                        wordcount--;
                }
                if (buf[i] == '.' || buf[i] == '!' || buf[i] == '?') //세가지 문자(.  ?  ! )로 끝나면 하나의 문장
                    stringcount++;
                if (buf[i] == ' ')  //공백이 아닌 모든 문자
                    charcount--;
            }

            //출력결과를 파일에 저장
            FileWriter fw = new FileWriter(f2);
            String str1 = Integer.toString(charcount);
            String str2 = Integer.toString(wordcount);
            String str3 = Integer.toString(stringcount);
            System.out.println("문자 수는 "+ str1+"개 입니다.");
            System.out.println("단어 수는 "+str2+"개 입니다.");
            System.out.println("문장 수는 "+str3+"개 입니다.");
            fw.write(str1, 0, str1.length()); //문자수 저장
            fw.write("\r\n", 0, 2);
            fw.write(str2, 0, str2.length()); //단어수 저장
            fw.write("\r\n", 0, 2);
            fw.write(str3, 0, str3.length()); //문장수 저장

            fr.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("입출력 오류");
            return;
        }
        scanner.close();
    }


}
