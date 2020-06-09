import javax.swing.*;
import java.awt.*;


public class FigurePanelEx extends JFrame {
    private MP panel = new MP();

    public FigurePanelEx() {
        setTitle("FigurePanelEx");
        setLayout(new GridLayout(2, 3, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(400, 200);
        setVisible(true);

    }

    class MP extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getSize().width;
            int height = getSize().height;

            g.setColor(Color.BLACK);
            g.drawLine(10, 10, width - 10, height - 10);
            g.drawLine(width - 10, 10, 10, height - 10);
            g.setColor(Color.BLUE);
            g.drawRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
            g.setColor(Color.RED);
            g.drawRoundRect(20, 20, 120, 80, 40, 60);
            g.setColor(Color.BLACK);
            g.drawOval((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
            g.setColor(Color.BLUE);
            g.fillRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
            g.drawRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
            g.setColor(Color.RED);
            g.fillRoundRect(20, 20, 120, 80, 20, 40);
            g.drawRoundRect(20, 20, 120, 80, 20, 40);
        }
    }

    public static void main(String[] args) {
        new FigurePanelEx();
    }
}
