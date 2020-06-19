/*
 * 파일명 : FlagAnimation.java
 * 입력 : 마우스 클릭
 * 출력 : 정해진 위치에 국기를 출력하고 400ms마다 5픽셀시 올라가도록 구현( 마우스 클릭 시 해당 위치로 국기가 이동)
 * 작성일 : 2020년 6월 19일
 * 작성자 : 20176088 김경훈
 *
 * Q. 국기를 출력하고 2개의 애니메이션을 구현하라(Timer를 이용하여 지정한 시간마다 위치가 오르도록 구현 + 마우스 클릭 시 해당 위치로 이미지가 이동)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlagAnimation extends JFrame {

    int x=0;
    int y=0;
    public FlagAnimation(String flag_animation) {
        setTitle("Flag Animation");
//        setContentPane(new MousePanel());
        this.add(new USFlag());
    }
    class USFlag extends JPanel {       //US Flag 이미지를 추가하는 패널
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/us.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 20, 100,60,40,this);
        }
    }

//    class MousePanel extends JPanel {
//        public MousePanel() {
//            addMouseListener(new MouseAdapter() {
//                @Override
//                public void mousePressed(MouseEvent e){
//                    x = e.getX();
//                    y = e.getY();
//                    repaint();
//                }
//
//            });
//        }
//
////        public void paintComponent(Graphics g){
////            super.paintComponent(g);
////            g.drawImage(img,20, 100,60,40,this);
////
////        }
//    }

    public static void main(String[] args){
        // Create a frame
        JFrame frame = new FlagAnimation("Flag Animation");

        // Display the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);


    }
}

