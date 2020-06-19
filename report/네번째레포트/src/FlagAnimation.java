/*
 * 파일명 : FlagAnimation.java
 * 입력 : 마우스로 클릭
 * 출력 : 정해진 위치에 국기를 출력하고 400ms마다 5픽셀시 올라가도록 구현( 마우스 클릭 시 해당 위치로 국기가 이동)
 * 작성일 : 2020년 6월 19일
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

    int x=20;
    int y=100;
    int width = 60;
    int height = 40;
    USFlag flagPanel;

    public FlagAnimation(String flagAnimation) {
        setTitle(flagAnimation);
        setLayout(null);

        flagPanel = new USFlag();
        this.add(flagPanel);

        Timer flagMovementTime = new Timer(400, new panelMovementEvent());
        flagMovementTime.start();

        addMouseListener(this);
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

    class panelMovementEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            y -= 5;
            flagPanel.setBounds(x, y, width, height);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY() - height / 2; // 왜 빼줘야하는지는 모르곘음 그냥 위치 이상해서 빼서 맞췄음..
        flagPanel.setBounds(x, y, width, height);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // no action
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // no action
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // no action
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // no action
    }

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