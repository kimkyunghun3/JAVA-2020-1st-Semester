
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClickRandomPr extends JFrame{
    JLabel label;
    ClickRandomPr(){
        setTitle("클릭 연습용 응용프로그램"); // 제목 지정
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 닫기 버튼을 눌렀을 시 화면 닫기

        label= new JLabel("C");
        label.setSize(20,20);
        label.setLocation(100,100);
        label.addMouseListener(new MyMouseAdapter());
        // Jabel 컴포넌트 생성 후 MouseListener를 단다.

        add(label);
        setSize(300,300);
        setVisible(true);
        label.requestFocus();
        // 컨텐트팬이 키 입력을 받을 수 있도록 포커스 강제 지정

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ClickRandomPr();
    }

    class MyMouseAdapter extends MouseAdapter{
        int x,y;
        public void mousePressed(MouseEvent e) {
            x = (int)(Math.random()*350); // 여백을 조금 남기기 위해 350으로 지정
            y = (int)(Math.random()*350); // 여백을 조금 남기기 위해 350으로 지정
            label.setLocation(x,y);
        }
    }
}