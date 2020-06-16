import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class FlagAnimation extends JFrame {

    int x=0;
    int y=0;
    public FlagAnimation(String flag_animation) {
        setTitle("Flag Animation");
        setContentPane(new MousePanel());
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

    class MousePanel extends JPanel {
        public MousePanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }

            });
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,20, 100,60,40,this);

        }
    }

    public static void main(String[] args){
        // Create a frame
        JFrame frame = new FlagAnimation("Flag Animation");

        // Display the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
        new FlagAnimation("Flag Animation");

    }
}

