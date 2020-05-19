//import java.io.*;
//import java.util.*;
//
//public class InputOutput {
//
//    public static void main(String[] args) {
//        System.out.print("입력 파일과 출력 파일을 입력하시오 >> ");
//        Scanner scanner = new Scanner(System.in);
//        String src_str = scanner.next(); //복사할 파일의 이름
//        String dest_str = scanner.next(); //복사 당하는 파일의 이름
//        File src = new File("/Users/eddy/Documents/" + src_str); //복사할 대상 이미지
//        File dest = new File("/Users/eddy/Documents/" + dest_str); //복사하는 곳
//
//        try {
//            FileInputStream fi = new FileInputStream(src); //파일 입력 스트림
//            FileOutputStream fo = new FileOutputStream(dest); //파일 출력 스트림
//            long tenPercent = src.length() / 10; //파일의 10%의 크기
//            long progress = 0; //파일 10%될 때 까지 읽은 누적 바이트 수
//
//            System.out.println(src_str + " 를 " + dest_str + "로 복사합니다. \n10% 마다 *를 출력합니다.");
//            byte[] buf = new byte[1024]; //한 번 읽은 단위
//            int numRead = 0;//읽은 바이트 수
//
//            while(true) {
//                numRead = fi.read(buf,0,buf.length); //버퍼의 크기만큼 읽기
//                fo.write(buf,0,buf.length); //파일에 쓰기
//                if(numRead == -1) {//파일 끝에 도달함
//                    if(progress > 0) //지난 번에 읽었지만 10%애 도달하지 않아 *가 출력되지 못한 경우
//                        System.out.print("*");
//                    break;
//                }
//
//                progress += numRead;
//                if(progress >= tenPercent) { //만약에 10%에 도달하면
//                    System.out.print("*");
//                    progress -= tenPercent;
//                }
//            }
//            fi.close();
//            fo.close();
//        }
//        catch(IOException e) {
//            System.out.println("파일 복사 오류");
//        }
//
//    }
//
//}