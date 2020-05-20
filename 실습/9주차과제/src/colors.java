import java.awt.*;
import javax.swing.*;

class MyFrame3 extends JFrame{
    MyFrame3(){
        setTitle("4x4 Color Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //화면 닫기
        Container c = getContentPane();

        c.setLayout(new GridLayout(4,4));

        JLabel [] label = new JLabel [16]; //JLabel 16개 배열

        Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
                Color.PINK, Color.LIGHT_GRAY, Color.WHITE,
                Color.DARK_GRAY, Color.BLACK, Color.ORANGE,
                Color.BLUE,Color.MAGENTA}; //Color 배열 생성

        for(int i=0;i<label.length;i++) {
            label[i] = new JLabel(Integer.toString(i)); //라벨에 문자 입력
            label[i].setOpaque(true);  // 라벨 색깔 불투명 설정
            label[i].setBackground(color[i]); //라벨 배경색 지정
            c.add(label[i]);
        }
        setSize(500,200);//프레임 사이즈
        setVisible(true);//화면에 출력

    }
}
public class colors {

    public static void main(String[] args) {
        MyFrame3 mf = new MyFrame3();
    }

}