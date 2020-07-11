package Question3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calc extends JFrame implements ActionListener {

    String[] str = {"CE", "계산", "+", "-", "x", "/"};        //배열로 저장
    JTextField tf1, tf2;
    String numStr = "";

    public Calc() {
        setTitle("산술 계산기");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        JPanel pn = new JPanel();       //패널 하나씩 객체 생성
        JPanel ps = new JPanel();
        JPanel pc = new JPanel();
        pn.setBackground(Color.LIGHT_GRAY);     //배경색깔 설정
        ps.setBackground(Color.YELLOW);
        pc.setLayout(new GridLayout(4, 4, 5, 5));       //그리드로 위치 맞추기
        JLabel label1 = new JLabel("연산수식");
        tf1 = new JTextField(10);
        pn.add(label1);
        pn.add(tf1);
        JLabel label2 = new JLabel("계산결과");
        tf2 = new JTextField(10);
        ps.add(label2);
        ps.add(tf2);
        for (int i = 0; i < 16; i++) {     //계산기 숫자 반복문으로 구현
            JButton b = new JButton();

            if (i < 10) {
                b.setText(i + "");
                b.setBackground(Color.WHITE);       //배경색 설정
            } else {
                b.setText(str[i - 10]);
                b.setBackground(Color.WHITE);
            }
            if (i > 11)
                b.setBackground(Color.WHITE);
            pc.add(b);
            b.addActionListener(this);

            c.add(pc, BorderLayout.CENTER);         //Layout 위치 설정
            c.add(pn, BorderLayout.NORTH);
            c.add(ps, BorderLayout.SOUTH);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("CE")) {
            numStr = "";
            tf1.setText(numStr);
            tf2.setText("");
        } else if (str.equals("계산")) {
            StringTokenizer st = new StringTokenizer(numStr, "+-x/", true); //구분자를 넣는다.
            int num1 = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int num2 = Integer.parseInt(st.nextToken());
            switch (op) {           //switch문을 통해 연산에 따라 계산하도록 구현
                case "+":
                    tf2.setText(num1 + num2 + "");
                    break;
                case "-":
                    tf2.setText(num1 - num2 + "");
                    break;
                case "x":
                    tf2.setText(num1 * num2 + "");
                    break;
                case "/":
                    if(num2 ==0)
                        tf2.setText("0");       //0으로 나누면 0이 나오도록 구현
                    else
                        tf2.setText(num1 / num2 + "");
                    break;
                default:
                    tf2.setText("오류");
                    break;
            }

        } else {
            numStr += str;
            tf1.setText(numStr);
        }
    }
}
