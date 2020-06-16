/*
* 파일명 : ComputerGame.java
* 입력 : -
* 출력 : 컴퓨터가 게임하는 부분(출력은 BowlingGame.java 파일에서 출력됨)
* 작성일 : 2020년 6월 11일
* 작성자 : 20176088 김경훈
*
* 상대방인 컴퓨터가 게임하는 클래스
*/
import java.util.*;

public class ComputerGame {
    PlayBowling com = new PlayBowling();
    Random r = new Random();
    float com_strike = 0, com_spare = 0; //컴퓨터의 스트라이크, 스페어처리 확률
    int [] com_score = new int [10];
    private int i = 0,j = 0, chance = 0; // chance: 핀의 확률
    byte spare = 0, strike = 0; //스트라이크, 스페어 유무

    //컴퓨터 레밸에 따라 스트라이크, 스페어처리 확률 정하는 함수
    public void computerlevel(int level) {
        if(level == 0) {
            com_spare = 2105;
            com_strike = 1000;
        }
        else if(level == 1) {
            com_spare = 4500;
            com_strike = 4031;
        }
        else if(level == 2) {
            com_spare = 4000;
            com_strike = 5731;
        }
    }

    public void computerplay(int frame) {
        int pin1 = 0, pin2 = 0, pin3 = -1; //핀(1회), 핀(2회), 핀(3회-마지막프레임)
        //1. 핀 두번 던지기
        chance = r.nextInt(10000);
        System.out.println("컴퓨터>>");
        if(com_spare == 2105) { //초보자인 경우(스트라이크 < 스페어 < 나머지)
            if(chance < com_strike) { //strike인 경우
                pin1 = 10;
                pin2 = 0;
                System.out.println("X");
            }
            else if(chance < com_spare) { //spare인 경우
                pin1 = r.nextInt(10); //스트라이크 제외
                pin2 = 10 - pin1;
                if(pin1 == 0) System.out.println("-,/");
                else System.out.println(pin1 + "," + "/");
            }
            else{
                pin1 = r.nextInt(10); //스트라이크 제외
                pin2 = r.nextInt(10);
                while(pin1 + pin2 >= 10) { //스페어 제외
                    pin2 = r.nextInt(11);
                }
                if(pin1 == 0 && pin2 != 0) System.out.println("-," + pin2);
                else if(pin1 != 0 && pin2 == 0) System.out.println(pin1 + ",-");
                else if(pin1 == 0 && pin2 == 0) System.out.println("-,-");
                else System.out.println(pin1 + "," + pin2);
            }
        }
        else if(com_spare == 4500) { //중급자인 경우(나머지 < 스트라이크 < 스페어)
            if(chance < 10000 - (com_strike + com_spare)){
                pin1 = r.nextInt(10); //스트라이크 제외
                pin2 = r.nextInt(10);
                while(pin1 + pin2 >= 10) { //스페어 제외
                    pin2 = r.nextInt(11);
                }
                if(pin1 == 0 && pin2 != 0) System.out.println("-," + pin2);
                else if(pin1 != 0 && pin2 == 0) System.out.println(pin1 + ",-");
                else if(pin1 == 0 && pin2 == 0) System.out.println("-,-");
                else System.out.println(pin1 + "," + pin2);
            }
            else if(chance < com_strike) { //strike인 경우
                if(strike >= 3) {
                    pin1 = r.nextInt(10); //스트라이크 제외 - 스페어처리하기!
                    pin2 = 10 - pin1;
                    if(pin1 == 0) System.out.println("-,/");
                    else System.out.println(pin1 + "," + "/");
                }
                else {
                    pin1 = 10;
                    pin2 = 0;
                    System.out.println("X");
                }
            }
            else { //spare인 경우
                pin1 = r.nextInt(10); //스트라이크 제외
                pin2 = 10 - pin1;
                if(pin1 == 0) System.out.println("-,/");
                else System.out.println(pin1 + "," + "/");
            }

        }
        else if(com_spare == 4000) { //상급자인 경우(나머지 < 스페어 < 스트라이크)
            if(chance < 10000 - (com_strike + com_spare)){
                pin1 = r.nextInt(10); //스트라이크 제외
                pin2 = r.nextInt(10);
                while(pin1 + pin2 >= 10) { //스페어 제외
                    pin2 = r.nextInt(11);
                }
                if(pin1 == 0 && pin2 != 0) System.out.println("-," + pin2);
                else if(pin1 != 0 && pin2 == 0) System.out.println(pin1 + ",-");
                else if(pin1 == 0 && pin2 == 0) System.out.println("-,-");
                else System.out.println(pin1 + "," + pin2);
            }
            else if(chance < com_spare){ //spare인 경우
                pin1 = r.nextInt(10); //스트라이크 제외
                pin2 = 10 - pin1;
                if(pin1 == 0) System.out.println("-,/");
                else System.out.println(pin1 + "," + "/");
            }
            else{ //strike인 경우
                if(strike >= 3) {
                    pin1 = r.nextInt(10); //스트라이크 제외
                    pin2 = 10 - pin1;
                    if(pin1 == 0) System.out.println("-,/");
                    else System.out.println(pin1 + "," + "/");
                }
                else {
                    pin1 = 10;
                    pin2 = 0;
                    System.out.println("X");
                }
            }
        }
        com.rollarray(pin1);
        com.rollarray(pin2);
        //2. 이전에 스트라이크였는지 조사하여 총점 계산 - 단, 현재 스트라이크이면 총점 보류
        if(pin1 != 10 && frame >= 1 && com.rolls[(frame - 1) * 2] == 10) { //스트라이크
            if(frame >= 2 && com.rolls[(frame - 2) * 2] == 10) { //더블
                if(frame >= 3 && com.rolls[(frame - 3) * 2] == 10) {  //터키
                    strike--;
                    try {
                        com_score[frame - 3] = com.getScore(com_score[(frame - 3) - 1], frame - 3);
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        com_score[frame - 3] = com.getScore(0, frame - 3);
                    }
                }
                strike--;
                try {
                    com_score[frame - 2] = com.getScore(com_score[(frame - 2) - 1], frame - 2);
                }
                catch(ArrayIndexOutOfBoundsException e) {
                    com_score[frame - 2] = com.getScore(0, frame - 2);
                }
            }
            strike--;
            try {
                com_score[frame - 1] = com.getScore(com_score[(frame - 1) - 1], frame - 1);
            }
            catch(ArrayIndexOutOfBoundsException e) {
                com_score[frame - 1] = com.getScore(0, frame - 1);
            }
        }
        //3. 이전에 스페어 처리였는지 조사하여 총점 계산
        if(frame >= 1 && com.rolls[(frame-1) * 2] != 10 && com.rolls[(frame-1) * 2] + com.rolls[(frame-1) * 2 + 1] == 10) {
            spare--;
            try {
                com_score[frame - 1] = com.getScore(com_score[(frame - 1) - 1], frame - 1);
            }
            catch(ArrayIndexOutOfBoundsException e) {
                com_score[frame - 1] = com.getScore(0, frame - 1);
            }
        }

        //4. 현재 frame의 총점 계산(모든 프레임에서!)
        if(pin1 == 10) { //이번에 스트라이크인 경우 - 총점 보류
            strike++;
            System.out.println("score = strike");
        }
        else if(pin1 + pin2 == 10) { //이번에 스페어 처리인 경우 - 총점 보류
            spare++;
            System.out.println("score = spare");
        }
        else { //현재 아무것도 아닌 경우 - 총점 계산
            try {
                com_score[frame] = com.getScore(com_score[frame - 1], frame);
            }
            catch(ArrayIndexOutOfBoundsException e) {
                com_score[frame] = com.getScore(0, frame);
            }
            System.out.println("score = " + com_score[frame]);
        }

        //5. frame8/score[8]까지 총점 계산 완료(단, 현재 스트라이크/트리/더블 보류)
        //   ->**마지막 프레임에 스트라이크 또는 스페러 처리인 경우 총점 보류x 총점 계산!!
        if(frame == 9) {
            //스트라이크나 스페어인 경우 21번째 핀을 더 던질 수 있다
            if(pin1 == 10 || pin1 + pin2 == 10) {
                pin3 = r.nextInt(11); //21번째 핀
                com.rollarray(pin3);
                System.out.print("/" + pin3);
            }
            if(pin1 == 10) { //마지막 프레임에 스트라이크인 경우
                if(com.rolls[(frame - 1) * 2] == 10) { //더블인 경우
                    if(com.rolls[(frame - 2) * 2] == 10) { //터키인 경우
                        try {
                            com_score[frame - 2] = com.getScore(com_score[(frame - 2) - 1], frame - 2);
                        }
                        catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("마지막 프레임의 오류 - 터키");
                            return;
                        }
                    }
                    try {
                        com_score[frame - 1] = com.getScore(com_score[(frame - 1) - 1], frame - 1);
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println("마지막 프레임의 오류 - 더블");
                        return;
                    }
                }
                try { //원 스트라이크인 경우(마지막 프레임만 스트라이크)
                    com_score[9] = com_score[8] + 10 + pin3;
                }
                catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("마지막 프레임의 번지수 문제 - 스트라이크");
                    return;
                }
            }
            else if(pin1 + pin2 == 10) { //마지막 프레임이 스페어 처리인 경우
                try {
                    com_score[9] = com_score[8] + 10 + pin3;
                }
                catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("마지막 프레임의 번지수 문제 - 스페어 처리");
                    return;
                }
            }
        }//마지막 frame
        //한 프레임이 끝나면 여태까지 총점, 핀수 보여주기
        try {
            System.out.println("< " + (frame + 1) + "프레임의 결과 - 컴퓨터 >");
            //핀수 출력
            for(j = 0;j <= frame;j++) {
                if(com.rolls[j*2] == 10) //스트라이크인 경우
                    System.out.print("X   ");
                else if(com.rolls[j*2] + com.rolls[j*2+1] == 10) { //스페어인 경우
                    if(com.rolls[j*2] == 0) System.out.print("-,/ ");
                    else System.out.print(com.rolls[j*2] + "," + "/ ");
                }
                else {
                    if(com.rolls[j*2] == 0 && com.rolls[j*2+1] != 0) System.out.print("-," + com.rolls[j*2+1] + " ");
                    else if(com.rolls[j*2] != 0 && com.rolls[j*2+1] == 0) System.out.print(com.rolls[j*2] + ",- ");
                    else if(com.rolls[j*2] == 0 && com.rolls[j*2+1] == 0) System.out.print("-,- ");
                    else System.out.print(com.rolls[j*2] + "," + com.rolls[j*2+1] + " ");
                }
            }
            if(pin3 != -1) //21번쨰 핀수
                System.out.print("," + com.rolls[20]);
            System.out.println();
            //총점 출력
            for(j = 0;j <= frame - (spare + strike);j++)
                System.out.printf("%3d ",com_score[j]);
            if(pin3 != -1) {
                for(int k = j;k <= frame;k++)
                    System.out.printf("%3d ",com_score[k]);
            }
            System.out.println();
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.print("   ");
        }
        System.out.println();
    }
}