import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyKetListener extends KeyAdapter{

    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == '+') {
            JLabel la = (JLabel)e.getSource();
            Font f = la.getFont();   //라벨의 폰트 객체
            int size = f.getSize();  //현재 폰트 사이즈 반환
            la.setFont(new Font("TimesRoman",Font.PLAIN,size + 5)); //현재 폰트 사이즈에서 5를 더함
        }
        else if(e.getKeyChar() == '-') {
            JLabel la = (JLabel)e.getSource();
            Font f = la.getFont();
            int size = f.getSize();
            if(size <= 5)
                return; //글자가 너무 작으면 아무것도 안함
            la.setFont(new Font("TimesRoman",Font.PLAIN,size - 5));
        }
    }
}
public class KeyPr extends JFrame{
    //생성자 함수
    public KeyPr() {
        setTitle("+,- 키로 폰트 크기 조절");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        //라벨 컴포넌트 생성 - 이벤트 소스
        JLabel label = new JLabel("Love Java");
        c.add(label); //컨테이너에 라벨 붙이기

        label.addKeyListener(new MyKetListener()); //리스너 등록하기

        setLocationRelativeTo(null);
        setSize(300,200);
        setVisible(true);
        //포커스 설정
        label.setFocusable(true);
        label.requestFocus();
    }

    public static void main(String[] args) {
        new KeyPr();
    }

}