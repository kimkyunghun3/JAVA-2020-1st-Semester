/*
 * 파일명 : sixFlags.java
 * 입력 : -
 * 출력 : 6개의 국기가 Grid를 통해 각 위치에 출력
 * 작성일 : 2020년 6월 19일
 * 작성자 : 20176088 김경훈
 *
 * Q. 여섯 국기를 Grid에 정확하 위치에 출력하라
 */

import javax.swing.*;
import java.awt.*;


public class sixFlags extends JFrame{

    public sixFlags(){      //화면 구성 부분
        setTitle("sixFlags");       //Title명
        setLayout(new GridLayout(2,3,5,5)); //가로3 세로2 기준으로 구분하여 Grid 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new USFlag());     //각 패널을 add하여 grid에 적용하도록 한다.
        this.add(new CanadaFlag());
        this.add(new IndiaFlag());
        this.add(new UKFlag());
        this.add(new ChinaFlag());
        this.add(new NorwayFlag());
        setSize(400, 200);

        setVisible(true);

    }

    class USFlag extends JPanel {       //US Flag 이미지를 추가하는 패널
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/us.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //패널에 꽉차게 이미지가 저장되도록 설정
        }
    }
    class CanadaFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/canada.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //패널에 꽉차게 이미지가 저장되도록 설정
        }
    }
    class IndiaFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/india.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //패널에 꽉차게 이미지가 저장되도록 설정
        }
    }
    class UKFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/uk.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //패널에 꽉차게 이미지가 저장되도록 설정
        }
    }
    class ChinaFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/china.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //패널에 꽉차게 이미지가 저장되도록 설정
        }
    }
    class NorwayFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/norway.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //패널에 꽉차게 이미지가 저장되도록 설정
        }
    }
    public static void main(String[] args){
        new sixFlags();
    }
}
