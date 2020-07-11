package Question2;

import javax.swing.*;
import java.awt.*;

public class RectangleAndCircle extends JFrame {

    public RectangleAndCircle() {
        setTitle("Graphics 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);        //레이아웃 설정
        this.add(new panel());
        setSize(250, 200);      //사이즈 설정
        setVisible(true);
    }

    class panel extends JPanel {
        panel () {
            setBounds(0, 0, 250, 200);
        }

        public void paintComponent(Graphics g) {        //3가지 구현 부분
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawString("자바 크래픽", 20, 20);     //글자 구현

            g.setColor(Color.RED);
            g.drawRect(30, 30, 80, 80);     //사각형 구현

            g.setColor(Color.GREEN);
            g.fillOval(120, 30, 80, 80);        //원 구현
            g.drawOval(120, 30, 80, 80);
        }
    }

    public static void main(String[] args) {
        new RectangleAndCircle();

    }
}