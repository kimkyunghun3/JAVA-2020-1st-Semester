import javax.swing.*;
import java.awt.*;


public class DisplayImage extends JFrame{
    private MyP panel = new MyP();
    public DisplayImage(){      //화면 구성 부분
        setTitle("DisplayImage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 200);
        setVisible(true);

    }

    class MyP extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/us.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //사이즈에 맞게 이미지 들어가도록 설정
        }
    }
    public static void main(String[] args){
        new DisplayImage();
    }
}
