import javax.swing.*;
import java.awt.*;


public class FigurePanelEx extends JFrame {
    public FigurePanelEx() {
        setTitle("FigurePanelEx");
        setLayout(new GridLayout(2, 3, 5, 5)); //GridLayout사용하도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        this.add(new xPanel());             //각 패널마다 add하도록 구현
        this.add(new blueRectanglePanel());
        this.add(new redRoundRectanglePanel());
        this.add(new blackOvalPanel());
        this.add(new blueFilledRectanglePanel());
        this.add(new redFilledRoundRectanglePanel());
        setVisible(true);
    }

    class xPanel extends JPanel {           //xpanel 설정
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.BLACK);
            g.drawLine(10, 10, width - 10, height - 10);
            g.drawLine(width - 10, 10, 10, height - 10);
        }
    }

    class blueRectanglePanel extends JPanel {       //blue 직사각형 구현
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.BLUE);
            g.drawRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        }
    }

    class redRoundRectanglePanel extends JPanel {       //레드 직사각형 구현
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.RED);
            g.drawRoundRect((int)(0.1*width), (int)(0.1*height), (int) (0.8 * width), (int) (0.8 * height), 20, 30);
        }
    }

    class blackOvalPanel extends JPanel {       //검정 oval 구현
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.BLACK);
            g.drawOval((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        }
    }

    class blueFilledRectanglePanel extends JPanel {     //블루색 꽉찬 직사각형 구현
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.BLUE);
            g.fillRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
            g.drawRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        }
    }

    class redFilledRoundRectanglePanel extends JPanel {     //빨간색 꽉찬 직사각형 구현
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.RED);
            g.fillRoundRect((int)(0.1*width), (int)(0.1*height), (int)(0.8 * width), (int)(0.8 * height), 20,30);
            g.drawRoundRect((int)(0.1*width), (int)(0.1*height), (int)(0.8 * width), (int)(0.8 * height), 20,30);
        }
    }

    public static void main(String[] args) {
        new FigurePanelEx();
    }
}
