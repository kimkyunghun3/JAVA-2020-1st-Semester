/*
 * 파일명 : FlagAnimation.java
 * 입력 : 마우스로 클릭
 * 출력 : 정해진 위치에 국기를 출력하고 400ms마다 5픽셀시 올라가도록 구현( 마우스 클릭 시 해당 위치로 국기가 이동)
 * 작성일 : 2020년 6월 20일
 * 작성자 : 20176088 김경훈
 *
 * Q. 국기를 출력하고 2개의 애니메이션을 구현하라(Timer를 이용하여 지정한 시간마다 위치가 오르도록 구현 + 마우스 클릭 시 해당 위치로 이미지가 이동)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FlagAnimation extends JFrame implements MouseListener {

    int x=20;           //초기에 위치 설정
    int y=100;
    int width = 60;         //이미지 넓이와 높이 설정
    int height = 40;
    USFlag flagPanel;

    public FlagAnimation(String flagAnimation) {
        setTitle(flagAnimation);
        setLayout(null);

        flagPanel = new USFlag();
        this.add(flagPanel);

        Timer flagMovementTime = new Timer(400, new panelMovementEvent());      //지정한 시간에 따라 이동하도록 설정
        flagMovementTime.start(); //움직이기 시작

        addMouseListener(this); //마우스 작동하도록 설정
    }

    class USFlag extends JPanel {       //US Flag 이미지를 추가하는 패널
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/us.gif"); //이미지 추가
        private Image img = icon.getImage();
        USFlag() {
            setBounds(x, y, width, height);
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0, width, height, this);
        }
    }

    class panelMovementEvent implements ActionListener {        //이동하는 행동 구현
        public void actionPerformed(ActionEvent e) {
            y -= 5;
            flagPanel.setBounds(x, y, width, height);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY() - height / 2; //마우스 클릭시 클릭한 곳으로 이동하도록 위치 설정
        flagPanel.setBounds(x, y, width, height);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // 액션이 없다
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // 액션이 없다
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 액션이 없다
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // 액션이 없다
    }

    public static void main(String[] args){
        //프레임 만들기
        JFrame frame = new FlagAnimation("Flag Animation");
        // 프레임 보여지기
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); //프레임을 가운데 놓도록 설정
        frame.setVisible(true);
    }
}