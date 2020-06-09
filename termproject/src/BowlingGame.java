/*볼링 게임 프로그램
 * 0) 사용자 id 정하기
 * 1) 사용자가 초보, 중급, 상급이 되는 것은 랜덤
 * 2) 컴퓨터 즉, 게임 난이도 초보, 중급, 상급 중 선택 가능
 * 3) 볼링 규칙에 맞게 게임이 진행된다. 사용자먼저 -> 컴퓨터
 * 4) 우승 결과
 * 5) 또 할 것인지 묻기

 * 파일명 : BowlingGame.java
 * 입력 : 위 규칙에 따른 입력
 * 출력 : 볼링 게임에 따라 점수가 나오며 유저와 상대방의 승부를 통해 승리여부 출력
 * 작성일 : 2020년 6월 9일
 * 작성자 : 20176088 김경훈
 */
import java.util.*;

public class BowlingGame {
    public static void main(String[] args) {
        Random random = new Random();
        PlayBowling user = new PlayBowling();
        Scanner s = new Scanner(System.in);

        int user_level = 0;    //사용자와 컴퓨터의 레벨(초,중,상)
        float user_strike = 0, user_spare = 0; //사용자의 스트라이크, 스페어처리 확률
        byte end = 1; //종료버튼
        String order = null, name = null;  //사용자 게임 명령어
        int frame, i = 0,j = 0, chance = 0; // chance: 핀의 확률

        System.out.println("사용자 이름을 입력하시오");
        name = s.nextLine();
        while(end == 1) {
            ComputerGame com = new ComputerGame();
            int [] user_score = new int [10]; //한 게임의 총점 10개
            byte spare = 0, strike = 0; //스트라이크, 스페어 유무

            System.out.println("!!!!!!!!!!!!볼링 게임 시작!!!!!!!!!!!");
            //1,2)사용자와 컴퓨터 레벨 정함 -> 스트라이크, 스페어 처리  확률이 각각 정해짐(데이터에 기반하여 확률 정함)
            user_level = (int)random.nextInt(10);
            if(user_level < 2) { //사용자가 상급로 랜덤하게 선택된 경우(20%)
                user_spare = 4000;
                user_strike = 5731; //-> **평균과 가까워지기 위해 확률을 더 높임
            }
            else if(user_level < 4) { //사용자가 초보로 랜덤하게 선택된 경우(40%)
                user_spare = 2105; //21.05%
                user_strike = 1000;
            }
            else{ //사용자가 중급으로 랜덤하게 선택된 경우(40%)
                user_spare = 4500;
                user_strike = 4031; //-> **중급 평균과 가까워지기 위해 확률을 더 높임
            }
            System.out.println("상대방의 레벨을 골라봐! (게임 난이도): 0 - 초급, 1 - 중급, 2 - 상급");
            com.computerlevel(Integer.parseInt(s.nextLine()));
            //프레임 시작!
            System.out.println("< " + ++i + " game >");
            System.out.println("핀을 던질 때: pin, 종료하고 싶을 때: end, 다시 시작하고 싶을 때: restart");
            for(frame = 0; frame < 10; frame++) {
                int pin1 = 0, pin2 = 0, pin3 = -1; //핀(1회), 핀(2회), 핀(3회-마지막프레임)
                //1. 핀 두번 던지기 - "pin"이라고 할때 마다
                System.out.print( name +">> ");
                order = s.nextLine();
                if(order.equals("pin")) {
                    chance = random.nextInt(10000);
                    if(user_spare == 2105) { //초보자인 경우(스트라이크 < 스페어 < 나머지)
                        if(chance < user_strike) { //strike인 경우
                            pin1 = 10;
                            pin2 = 0;
                            System.out.println("X");
                        }
                        else if(chance < user_spare) { //spare인 경우
                            pin1 = random.nextInt(10); //스트라이크 제외
                            pin2 = 10 - pin1;
                            if(pin1 == 0) System.out.println("-,/");
                            else System.out.println(pin1 + "," + "/");
                        }
                        else{
                            pin1 = random.nextInt(10); //스트라이크 제외
                            pin2 = random.nextInt(10);
                            while(pin1 + pin2 >= 10) { //스페어 제외
                                pin2 = random.nextInt(11);
                            }
                            if(pin1 == 0 && pin2 != 0) System.out.println("-," + pin2);
                            else if(pin1 != 0 && pin2 == 0) System.out.println(pin1 + ",-");
                            else if(pin1 == 0 && pin2 == 0) System.out.println("-,-");
                            else System.out.println(pin1 + "," + pin2);
                        }
                    }
                    else if(user_spare == 4500) { //중급자인 경우(나머지 < 스트라이크 < 스페어)
                        if(chance < 10000 - (user_strike + user_spare)){
                            pin1 = random.nextInt(10); //스트라이크 제외
                            pin2 = random.nextInt(10);
                            while(pin1 + pin2 >= 10) { //스페어 제외
                                pin2 = random.nextInt(11);
                            }
                            if(pin1 == 0 && pin2 != 0) System.out.println("-," + pin2);
                            else if(pin1 != 0 && pin2 == 0) System.out.println(pin1 + ",-");
                            else if(pin1 == 0 && pin2 == 0) System.out.println("-,-");
                            else System.out.println(pin1 + "," + pin2);
                        }
                        else if(chance < user_strike) { //strike인 경우  -> **중급자 스트라이크가 많이 나와서 트리 이상을 방지해야함!
                            if(strike >= 3) {
                                pin1 = random.nextInt(10); //스트라이크 제외 -> 스페어처리하기!
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
                            pin1 = random.nextInt(10); //스트라이크 제외
                            pin2 = 10 - pin1;
                            if(pin1 == 0) System.out.println("-,/");
                            else System.out.println(pin1 + "," + "/");
                        }

                    }
                    else if(user_spare == 4000) { //상급자인 경우(나머지 < 스페어 < 스트라이크)
                        if(chance < 10000 - (user_strike + user_spare)){
                            pin1 = random.nextInt(10); //스트라이크 제외
                            pin2 = random.nextInt(10);
                            while(pin1 + pin2 >= 10) { //스페어 제외
                                pin2 = random.nextInt(11);
                            }
                            if(pin1 == 0 && pin2 != 0) System.out.println("-," + pin2);
                            else if(pin1 != 0 && pin2 == 0) System.out.println(pin1 + ",-");
                            else if(pin1 == 0 && pin2 == 0) System.out.println("-,-");
                            else System.out.println(pin1 + "," + pin2);
                        }
                        else if(chance < user_spare){ //spare인 경우
                            pin1 = random.nextInt(10); //스트라이크 제외
                            pin2 = 10 - pin1;
                            if(pin1 == 0) System.out.println("-,/");
                            else System.out.println(pin1 + "," + "/");
                        }
                        else{ //strike인 경우 -> **상급자는 특히 스트라이크가 많이 나와서 트리 이상을 방지해야함!
                            if(strike >= 3) {
                                pin1 = random.nextInt(10); //스트라이크 제외
                                pin2 = 10 - pin1;
                                if(pin1 == 0) System.out.println("-,/");
                                else System.out.println(pin1 + "," + "/");
                            }
                            else{
                                pin1 = 10;
                                pin2 = 0;
                                System.out.println("X");
                            }
                        }
                    }
                    user.rollarray(pin1);
                    user.rollarray(pin2);
                }
                else if(order.equals("end"))
                    System.exit(0); //프로그램 종료
                else if(order.equals("restart")) {
                    break; //frame 반복문 나가기 - 이번 게임은 나가기
                }
                else {
                    System.out.println("잘못된 명령어입니다.");
                    frame--;
                    continue;
                }

                //2. 이전에 스트라이크였는지 조사하여 총점 계산 - 단, 현재 스트라이크이면 총점 보류
                if(pin1 != 10 && frame >= 1 && user.rolls[(frame - 1) * 2] == 10) { //스트라이크
                    if(frame >= 2 && user.rolls[(frame - 2) * 2] == 10) { //더블
                        if(frame >= 3 && user.rolls[(frame - 3) * 2] == 10) {  //터키
                            strike--;
                            try {
                                user_score[frame - 3] = user.getScore(user_score[(frame - 3) - 1], frame - 3);
                            }
                            catch(ArrayIndexOutOfBoundsException e) {
                                user_score[frame - 3] = user.getScore(0, frame - 3);
                            }
                        }
                        strike--;
                        try {
                            user_score[frame - 2] = user.getScore(user_score[(frame - 2) - 1], frame - 2);
                        }
                        catch(ArrayIndexOutOfBoundsException e) {
                            user_score[frame - 2] = user.getScore(0, frame - 2);
                        }
                    }
                    strike--;
                    try {
                        user_score[frame - 1] = user.getScore(user_score[(frame - 1) - 1], frame - 1);
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        user_score[frame - 1] = user.getScore(0, frame - 1);
                    }
                }
                //3. 이전에 스페어 처리였는지 조사하여 총점 계산
                if(frame >= 1 && user.rolls[(frame-1) * 2] != 10 && user.rolls[(frame-1) * 2] + user.rolls[(frame-1) * 2 + 1] == 10) {
                    spare--;
                    try {
                        user_score[frame - 1] = user.getScore(user_score[(frame - 1) - 1], frame - 1);
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        user_score[frame - 1] = user.getScore(0, frame - 1);
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
                        user_score[frame] = user.getScore(user_score[frame - 1], frame);
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        user_score[frame] = user.getScore(0, frame);
                    }
                    System.out.println("score = " + user_score[frame]);
                }

                //5. frame8/score[8]까지 총점 계산 완료(단, 현재 스트라이크/트리/더블 보류)
                //   ->**마지막 프레임에 스트라이크 또는 스페러 처리인 경우 총점 보류x 총점 계산!!
                if(frame == 9) {
                    //스트라이크나 스페어인 경우 21번째 핀을 더 던질 수 있다
                    if(pin1 == 10 || pin1 + pin2 == 10) {
                        pin3 = random.nextInt(11); //21번째 핀
                        user.rollarray(pin3);
                        System.out.print("/" + pin3);
                    }
                    if(pin1 == 10) { //마지막 프레임에 스트라이크인 경우
                        if(user.rolls[(frame - 1) * 2] == 10) { //더블인 경우
                            if(user.rolls[(frame - 2) * 2] == 10) { //터키인 경우
                                try {
                                    user_score[frame - 2] = user.getScore(user_score[(frame - 2) - 1], frame - 2);
                                }
                                catch(ArrayIndexOutOfBoundsException e) {
                                    System.out.println("마지막 프레임의 오류 - 터키");
                                    return;
                                }
                            }
                            try {
                                user_score[frame - 1] = user.getScore(user_score[(frame - 1) - 1], frame - 1);
                            }
                            catch(ArrayIndexOutOfBoundsException e) {
                                System.out.println("마지막 프레임의 오류 - 더블");
                                return;
                            }
                        }
                        try { //원 스트라이크인 경우(마지막 프레임만 스트라이크)
                            user_score[9] = user_score[8] + 10 + pin3;
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("마지막 프레임의 번지수 문제 - 스트라이크");
                            return;
                        }
                    }
                    else if(pin1 + pin2 == 10) { //마지막 프레임이 스페어 처리인 경우
                        try {
                            user_score[9] = user_score[8] + 10 + pin3;
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("마지막 프레임의 번지수 문제 - 스페어 처리");
                            return;
                        }
                    }
                }//마지막 frame
                //한 프레임이 끝나면 여태까지 총점, 핀수 보여주기
                try {
                    System.out.println("< " + (frame + 1) + "프레임의 결과 - " + name +">");
                    //핀수 출력
                    for(j = 0;j <= frame;j++) {
                        if(user.rolls[j*2] == 10)  //스트라이크인 경우
                            System.out.print("X   ");
                        else if(user.rolls[j*2] + user.rolls[j*2+1] == 10) { //스페어인 경우
                            if(user.rolls[j*2] == 0) System.out.print("-,/ ");
                            else System.out.print(user.rolls[j*2] + "," + "/ ");
                        }
                        else {
                            if(user.rolls[j*2] == 0 && user.rolls[j*2+1] != 0) System.out.print("-," + user.rolls[j*2+1] + " ");
                            else if(user.rolls[j*2] != 0 && user.rolls[j*2+1] == 0) System.out.print(user.rolls[j*2] + ",- ");
                            else if(user.rolls[j*2] == 0 && user.rolls[j*2+1] == 0) System.out.print("-,- ");
                            else System.out.print(user.rolls[j*2] + "," + user.rolls[j*2+1] + " ");
                        }
                    }
                    if(pin3 != -1) //21번쨰 핀수
                        System.out.print("," + user.rolls[20]);
                    System.out.println();
                    //총점 출력
                    for(j = 0;j <= frame - (spare + strike);j++)
                        System.out.printf("%3d ",user_score[j]);
                    if(pin3 != -1) {//21번쨰 핀수 - 총점 마저 보이기
                        for(int k = j;k <= frame;k++)
                            System.out.printf("%3d ",user_score[k]);
                    }
                    System.out.println();
                }
                catch(ArrayIndexOutOfBoundsException e) {
                    System.out.print("   ");
                }
                //컴퓨터 차례
                System.out.println();
                com.computerplay(frame);
            }//frame반복문
            //우승 결과
            System.out.println(name + "님의 총점 = " + user_score[9]);
            System.out.println("컴퓨터의 총점 = " + com.com_score[9]);
            if(user_score[9] > com.com_score[9])
                System.out.println(name + "님이 우승하셨습니다");
            else if(user_score[9] < com.com_score[9])
                System.out.println("패배했습니다. 컴퓨터의 승리");
            else
                System.out.println("----------------무승부-----------------");

            user.currnetroll = 0;  //초기화

            System.out.println("게임을 그만하시겠습니까? 계속하시려면 1를, 그만하시려면 0를 입력해주세요!");
            end = Byte.parseByte(s.nextLine());
        }


    }

}