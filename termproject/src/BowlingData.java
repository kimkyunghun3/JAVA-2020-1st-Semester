/*  	(초보자 평균)100점에 근접하도록 하려면 스페어 처리와 스트라이크 각각의 개수의 확률을 정해야 한다.
 * 		랜덤으로 게임을 100번정도 진행시켜서 스페어 처리가 몇 개일 때, 스트라이크가 몇 개일 때 점수가 100점에 가까워지는 지에 대한 데이터 수집용 클래스
 *      cf)한 게임 = 10번의 프레임
 *
 * 파일명 : BowlingData.java
 * 입력 : -
 * 출력 : 초보자 중급자 상급자에 따른 스페어, 스트라이크 확률을 구하여 txt 파일에 저장
 * 작성일 : 2020년 6월 9일
 * 작성자 : 20176088 김경훈
 *
 * 수준에 따른 스페어, 스트라이크 확률을 구하는 파일
 */

import java.util.*;
import java.io.*;

public class BowlingData {
    public static void main(String[] args) {
        int MAX_NUM = 1000; //게임 최대 몇번 돌리지
        ArrayList<Integer> spare_count = new ArrayList<Integer>(MAX_NUM); //한 게임당 스페어 처리 개수
        ArrayList<Integer> strike_count = new ArrayList<Integer>(MAX_NUM);  //한 게임당 스트라이크 개수
        ArrayList<Integer> totalScore = new ArrayList<Integer>(MAX_NUM); //한 게임당 총점 배열
        int pin1 = 0, pin2 = 0, pin3 = 0; //핀(1회), 핀(2회), 핀(3회-마지막프레임)
        int spare = 0, strike = 0; //한 게임의 스페어 처리와 스트라이크 개수 저장
        int[] score = new int[10]; //한 게임의 총점 10개
        int i, frame;

        Random rand = new Random();
        PlayBowling data = new PlayBowling();

        //볼링을 100번 수행하여 데이터 수집
        for (i = 0; i < MAX_NUM; i++) {
            System.out.println("< " + (i + 1) + " game >");
            for (frame = 0; frame < 10; frame++) {
                //1. 핀 두번 던지기
                pin1 = rand.nextInt(11);
                if (pin1 != 10) { //스트라이크를 친 경우 다음 핀은 던질 필요x
                    pin2 = rand.nextInt(11);
                    while (pin1 + pin2 > 10) {
                        pin2 = rand.nextInt(11);
                    }
                } else pin2 = 0;
                data.rollarray(pin1);
                data.rollarray(pin2);
                System.out.print(pin1 + "/" + pin2 + " ");

                //2. 이전에 스트라이크였는지 조사하여 총점 계산 - 단, 현재 스트라이크이면 총점 보류
                if (pin1 != 10 && frame >= 1 && data.rolls[(frame - 1) * 2] == 10) { //스트라이크
                    if (frame >= 2 && data.rolls[(frame - 2) * 2] == 10) { //더블
                        if (frame >= 3 && data.rolls[(frame - 3) * 2] == 10) {  //터키
                            try {
                                score[frame - 3] = data.getScore(score[(frame - 3) - 1], frame - 3);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                score[frame - 3] = data.getScore(0, frame - 3);
                            }
                        }
                        try {
                            score[frame - 2] = data.getScore(score[(frame - 2) - 1], frame - 2);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            score[frame - 2] = data.getScore(0, frame - 2);
                        }
                    }
                    try {
                        score[frame - 1] = data.getScore(score[(frame - 1) - 1], frame - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        score[frame - 1] = data.getScore(0, frame - 1);
                    }
                }
                //3. 이전에 스페어 처리였는지 조사하여 총점 계산
                if (frame >= 1 && data.rolls[(frame - 1) * 2] != 10 && data.rolls[(frame - 1) * 2] + data.rolls[(frame - 1) * 2 + 1] == 10) {
                    try {
                        score[frame - 1] = data.getScore(score[(frame - 1) - 1], frame - 1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        score[frame - 1] = data.getScore(0, frame - 1);
                    }
                }

                //4. 현재 frame의 총점 계산(모든 프레임에서!)
                if (pin1 == 10) //이번에 스트라이크인 경우 - 총점 보류
                    strike++;
                else if (pin1 + pin2 == 10) //이번에 스페어 처리인 경우 - 총점 보류
                    spare++;
                else { //이번에 아무것도 아닌 경우 - 총점 계산
                    try {
                        score[frame] = data.getScore(score[frame - 1], frame);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        score[frame] = data.getScore(0, frame);
                    }
                }

                //5. frame8/score[8]까지 총점 계산 완료(단, 현재 스트라이크/트리/더블 보류)
                //   ->**마지막 프레임에 스트라이크 또는 스페러 처리인 경우 총점 보류x 총점 계산!!
                if (frame == 9) {
                    //스트라이크나 스페어인 경우 21번째 핀을 더 던질 수 있다
                    if (pin1 == 10 || pin1 + pin2 == 10) {
                        pin3 = rand.nextInt(11); //21번째 핀
                        data.rollarray(pin3);
                        System.out.print("/" + pin3);
                    }
                    if (pin1 == 10) { //마지막 프레임에 스트라이크인 경우
                        if (data.rolls[(frame - 1) * 2] == 10) { //더블인 경우
                            if (data.rolls[(frame - 2) * 2] == 10) { //터키인 경우
                                try {
                                    score[frame - 2] = data.getScore(score[(frame - 2) - 1], frame - 2);
                                } catch (ArrayIndexOutOfBoundsException e) {
                                    System.out.println("마지막 프레임의 오류 - 터키");
                                    return;
                                }
                            }
                            try {
                                score[frame - 1] = data.getScore(score[(frame - 1) - 1], frame - 1);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("마지막 프레임의 오류 - 더블");
                                return;
                            }
                        }
                        try { //원 스트라이크인 경우(마지막 프레임만 스트라이크)
                            score[9] = score[8] + 10 + pin3;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("마지막 프레임의 번지수 문제 - 스트라이크");
                            return;
                        }
                    } else if (pin1 + pin2 == 10) { //마지막 프레임이 스페어 처리인 경우
                        try {
                            score[9] = score[8] + 10 + pin3;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("마지막 프레임의 번지수 문제 - 스페어 처리");
                            return;
                        }
                    }
                }
            }//frame반복문

            //한 게임 종류 후 스페어 처리, 스트라이크, 총 점수 정리
            System.out.println();
            for (int j = 0; j < 10; j++)
                System.out.print(score[j] + "  ");
            System.out.println();
            spare_count.add(spare);
            strike_count.add(strike);
            totalScore.add(score[9]);

            data.currnetroll = 0; //한 게임 지났으므로 핀 회수 초기화
            spare = 0;
            strike = 0;
        }//한 게임(i반복문)
        //총 데이터를 바탕으로 각 점수의 스트라이크 및 스페어 처리 확률을 구해서 파일에 출력 ->spare_count, strike_count, totalScore
        int easy_spare = 0, easy_strike = 0, easy_count = 0; //초보자 총 스페어 처리와 스트라이크 개수, 초보자 갯수
        int middle_spare = 0, middle_strike = 0, middle_count = 0;
        //*단, 상급자의 경우 나오는 확률이 극히 드물므로 중급을 통해 유추값을 차용하고자 함!
        for (i = 0; i < MAX_NUM; i++) {
            if (totalScore.get(i) >= 80 && totalScore.get(i) <= 120) { //1. 초급(100)인 경우의 스트라이크, 스페어 개수
                easy_spare += spare_count.get(i);
                easy_strike += strike_count.get(i);
                easy_count++;
            } else if (totalScore.get(i) >= 130 && totalScore.get(i) <= 170) { //2. 중급(150)인 경우
                middle_spare += spare_count.get(i);
                middle_strike += strike_count.get(i);
                middle_count++;
            }
        }
        try {
            FileWriter fout = new FileWriter("C:\\Users\\mk\\eclipse-workspace\\Project\\bowlingdata.txt");
            fout.write("초보자");
            fout.write("\r\nspare: " + Double.toString(easy_spare) + "  strike: " + Double.toString(easy_strike) + "  count: " + Double.toString(easy_count));
            fout.write("\r\n스페어처리 확률 = " + Double.toString((double) easy_spare / easy_count / 10 * 100) + "%");
            fout.write("\r\n스트라이크 확률 = " + Double.toString((double) easy_strike / easy_count / 10 * 100) + "%");
            fout.write("\r\n중급자");
            fout.write("\r\nspare: " + Double.toString(middle_spare) + "  strike: " + Double.toString(middle_strike) + "  count: " + Double.toString(middle_count));
            fout.write("\r\n스페어처리 확률 = " + Double.toString((double) middle_spare / middle_count / 10 * 100) + "%");
            fout.write("\r\n스트라이크 확률 = " + Double.toString((double) middle_strike / middle_count / 10 * 100) + "%");

            fout.close();
        } catch (IOException e) {
            System.out.println("파일 입출력 오류");
        }
    }//main함수
}