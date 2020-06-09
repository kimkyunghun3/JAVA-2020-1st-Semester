import javax.swing.*;
import java.awt.*;


public class FigurePanelEx extends JFrame {
    public FigurePanelEx() {
        setTitle("FigurePanelEx");
        setLayout(new GridLayout(2, 3, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        this.add(new xPanel());
        this.add(new blueRectanglePanel());
        this.add(new redRoundRectanglePanel());
        this.add(new blackOvalPanel());
        this.add(new blueFilledRectanglePanel());
        this.add(new redFilledRoundRectanglePanel());
        setVisible(true);
    }

    class xPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.BLACK);
            g.drawLine(10, 10, width - 10, height - 10);
            g.drawLine(width - 10, 10, 10, height - 10);
        }
    }

    class blueRectanglePanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.BLUE);
            g.drawRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        }
    }

    class redRoundRectanglePanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.RED);
            g.drawRoundRect((int)(0.1*width), (int)(0.1*height), (int) (0.8 * width), (int) (0.8 * height), 20, 30);
        }
    }

    class blackOvalPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.BLACK);
            g.drawOval((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        }
    }

    class blueFilledRectanglePanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.BLUE);
            g.fillRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
            g.drawRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        }
    }

    class redFilledRoundRectanglePanel extends JPanel {
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
