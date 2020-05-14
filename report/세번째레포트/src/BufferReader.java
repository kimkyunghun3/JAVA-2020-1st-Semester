import java.util.*;
import java.io.*;

public class BufferReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력 파일명: ");
        String f1 = scanner.nextLine();
        System.out.print("출력 파일명: ");
        String f2 = scanner.nextLine();

        File src = new File("C:\\Users\\mk\\eclipse-workspace\\Report4\\" + f1); //읽을 파일
        File dest = new File("C:\\Users\\mk\\eclipse-workspace\\Report4\\" + f2); //출력 파일
        int c;
        int charcount = 0, wordcount = 0, stringcount = 0; //입력 파일에서 문자수, 단어수, 문장수
        char buf[] = new char[1024*10]; //텍스트 파일의 크기가 버퍼보다 작다는 가정
        try {
            //문자수 계산(단, 공백 포함x)
            FileReader fr = new FileReader(src);
            c = fr.read(buf);  //버퍼 크기만큼 읽어오기. c는 실제 읽은 문자수(공백까지 포함)
            charcount = c;    //문자수 계산

            //문자수, 단어수, 문장수 계산
            for(int i=0;i<buf.length;i++) {
                if(buf[i] == ' ' || buf[i] == '.' || buf[i] == '!' || buf[i] == '?') {
                    wordcount++;
                    //. ! ? 다음에 빈칸이 오므로 이를 단어수에서 제외
                    if(buf[i] == ' ' && (buf[i-1] == '.' || buf[i-1] == '!' || buf[i-1] == '?'))
                        wordcount--;
                }
                if(buf[i] == '.' || buf[i] == '!' || buf[i] == '?') //세가지 문자(.  ?  ! )로 끝나면 하나의 문장
                    stringcount++;
                if(buf[i] == ' ')  //공백이 아닌 모든 문자
                    charcount--;
            }
            //출력결과를 파일에 저장
            FileWriter fw = new FileWriter(dest);
            String str1 = Integer.toString(charcount);
            String str2 = Integer.toString(wordcount);
            String str3 = Integer.toString(stringcount);
            fw.write(str1,0,str1.length()); //문자수 저장
            fw.write("\r\n",0,2);
            fw.write(str2,0,str2.length()); //단어수 저장
            fw.write("\r\n",0,2);
            fw.write(str3,0,str3.length()); //문장수 저장

            fr.close();
            fw.close();
        }
        catch(IOException e) {
            System.out.println("입출력 오류");
            return;
        }
        scanner.close();
    }

}