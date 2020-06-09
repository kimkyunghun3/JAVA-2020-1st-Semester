import javax.swing.*;
import java.awt.*;


public class DisplayImage extends JFrame{
    private MyP panel = new MyP();
    public DisplayImage(){
        setTitle("DisplayImage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 200);
        setVisible(true);

    }

    class MyP extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/us.gif");
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this);
        }
    }
    public static void main(String[] args){
        new DisplayImage();
    }
}
