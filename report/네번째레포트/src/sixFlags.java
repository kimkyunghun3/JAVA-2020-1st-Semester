import javax.swing.*;
import java.awt.*;


public class sixFlags extends JFrame{

    public sixFlags(){      //화면 구성 부분
        setTitle("sixFlags");
        setLayout(new GridLayout(2,3,5,5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new USFlag());
        this.add(new CanadaFlag());
        this.add(new IndiaFlag());
        this.add(new UKFlag());
        this.add(new ChinaFlag());
        this.add(new NorwayFlag());
        setSize(400, 200);

        setVisible(true);

    }

    class USFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/us.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //사이즈에 맞게 이미지 들어가도록 설정
        }
    }
    class CanadaFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/canada.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //사이즈에 맞게 이미지 들어가도록 설정
        }
    }
    class IndiaFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/india.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //사이즈에 맞게 이미지 들어가도록 설정
        }
    }
    class UKFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/uk.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //사이즈에 맞게 이미지 들어가도록 설정
        }
    }
    class ChinaFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/china.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //사이즈에 맞게 이미지 들어가도록 설정
        }
    }
    class NorwayFlag extends JPanel {
        private ImageIcon icon = new ImageIcon("/Users/eddy/Desktop/norway.gif"); //이미지 추가
        private Image img = icon.getImage();
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0,getWidth(),getHeight(),this); //사이즈에 맞게 이미지 들어가도록 설정
        }
    }
    public static void main(String[] args){
        new sixFlags();
    }
}
