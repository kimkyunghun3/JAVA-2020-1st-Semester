import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class Silder extends JFrame{

    public Silder() {
        setTitle("JSlider Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JSlider s = new JSlider(100,200,150);
        JLabel label = new JLabel();

        c.add(s);
        c.add(label);

        //슬라이더 속성
        s.setPaintLabels(true);
        s.setPaintTicks(true);
        s.setPaintTrack(true);
        s.setMajorTickSpacing(20);
        //텍스트 속성
        label.setBackground(Color.green);
        label.setOpaque(true);
        label.setText(Integer.toString(s.getValue())); //초기화면에도 숫자 출력

        s.addChangeListener(new ChangeListener() { //슬라이더에 대한 이벤트 리스너
            public void stateChanged(ChangeEvent e) {
                JSlider j = (JSlider)e.getSource();
                label.setText(Integer.toString(j.getValue())); //리스너 값(숫자형)을 텍스트(문자)에 삽입
            }
        });

        setSize(300,200);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Silder();

    }

}