import java.awt.*;
import javax.swing.*;

class MyFrame2 extends JFrame{
    MyFrame2(){
        setTitle("Show BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //화면 닫기
        Container c = getContentPane();
        c.setLayout(new BorderLayout(5,10)); //BorderLayout로 배치 -> 5픽셀, 10 픽셀

        //팬에 컴퍼넌트를 북,남,동,서 방향으로 배치하기
        c.add(new JButton("North"),BorderLayout.NORTH);
        c.add(new JButton("West"),BorderLayout.WEST);
        c.add(new JButton("Center"),BorderLayout.CENTER);
        c.add(new JButton("East"),BorderLayout.EAST);
        c.add(new JButton("South"),BorderLayout.SOUTH);

        setSize(300,300);//프레임 사이즈
        setVisible(true);//화면에 출력
    }
}

public class fourdirection {
    public static void main(String[] args) {
        MyFrame2 mf = new MyFrame2();
    }
}