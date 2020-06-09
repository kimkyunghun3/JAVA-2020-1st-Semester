/*
* 파일명 : PlayBowling.java
* 입력 : -
* 출력 : 볼링 게임을 실행하기 위해 필요한 기본적인 함수들 구현(출력은 볼링게임에서)
* 작성일 : 2020년 6월 9일
* 작성자 : 20176088 김경훈
*
*/
public class PlayBowling {
    int [] rolls = new int [21];
    int currnetroll = 0;

    //핀 횟수 배열
    public void rollarray(int pins) {
        rolls[currnetroll++] = pins;
    }
    //총점 구하는 함수
    public int getScore(int past_score, int currentframe) {
        int getscore = past_score;
        int i = currentframe * 2; //현재 횟수

        if(rolls[i] == 10 && rolls[i+2] != 10) {//원 스트라이크
            getscore += (10 + rolls[i+2] + rolls[i+3]);
        }
        else if(rolls[i] == 10 && rolls[i+2] == 10 && rolls[i+4] != 10) { //투 스트라이크
            getscore += (10 + 10 + rolls[i+4]);
        }
        else if(rolls[i] == 10 && rolls[i+2] == 10 && rolls[i+4] == 10) { //트리 스트라이크
            getscore += 10 * 3;
        }
        else if(rolls[i] + rolls[i+1] == 10) { //스트라이크가 아닌 스페어 처리
            getscore += (10 + rolls[i+2]);
        }
        else { //일반적인 경우
            getscore += (rolls[i] + rolls[i+1]);
        }
        return getscore;
    }
}