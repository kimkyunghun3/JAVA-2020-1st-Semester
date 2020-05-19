/*
 * 파일명 : CompareFile.java
 * 입력 : 2개의 파일명 입력
 * 출력 : 입력한 2개의 파일이 같은 파일인지 다른 파일인지 여부 알려주도록 출력
 * 작성일 : 2020년 5월 19일
 * 작성자 : 20176088 김경훈
 *
 * Q. 2개의 파일명을 입력하여 2개의 파일이 같은지 여부 파악하여 출력하라.
 */


import java.io.*;
import java.util.Scanner;

public class CompareFileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileInputStream srcStream = null;
        FileInputStream destStream = null;

        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        while (true) {
            System.out.print("첫번째 파일 이름을 입력하세요>>");
            String src = scanner.nextLine();
            if(src.equals("exit"))
                break;
            System.out.print("두번째 파일 이름을 입력하세요>>");
            String dst = scanner.nextLine();

            System.out.println(src + "와 " + dst + "를 비교합니다.");

            try {
                srcStream = new FileInputStream(src); // 버퍼 입력 스트림에 연결
                destStream = new FileInputStream(dst); // 버퍼 출력 스트림에 연결
                if (compareFiles(srcStream, destStream))
                    System.out.println("파일이 같습니다.");
                else
                    System.out.println("파일이 다릅니다.");

                if (srcStream != null) srcStream.close();
                if (destStream != null) destStream.close();
            } catch (IOException e) {
                System.out.println("입출력 오류가 발생했습니다.");
            }


        }
        System.out.println("프로그램을 종료합니다.");
        scanner.close();

    }

    private static boolean compareFiles(FileInputStream src, FileInputStream dest) throws IOException {
        byte[] srcBuf = new byte[1024]; // 1KB 버퍼
        byte[] destbuf = new byte[1024];  // 1KB 버퍼

        int srcCount=0, destCount;
        while (true) {
            srcCount = src.read(srcBuf, 0, srcBuf.length); // src 스트림에서 srcBuf 크기만큼 읽기
            destCount = dest.read(destbuf, 0, destbuf.length); // dest 스트림에서 destBuf 크기만큼 읽기
            if (srcCount != destCount) // 읽어들인 바이트 수가 다르면 파일이 다름
                return false;

            if(srcCount == -1)
                break; // 파일 끝에 도달함

            for (int i=0; i<srcCount; i++) {
                if (srcBuf[i] != destbuf[i]) // 읽은 바이트들 비교
                    return false;
            }
        }
        return true;
    }
}