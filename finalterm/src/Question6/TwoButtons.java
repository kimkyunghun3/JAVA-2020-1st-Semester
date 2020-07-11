package Question6;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TwoButtons extends JFrame implements MouseMotionListener{
    private Button [] rb = new Button[2];
    private String [] color = { "yellow", "Blue" };         //배열로 색깔 저장
    int x=0;
    int y=0;
    JFrame that = this;
    public TwoButtons() {
        this.setTitle("MouseListener Ex");      //타이틀 지정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.setLayout(new FlowLayout());

        ButtonGroup bg = new ButtonGroup();

        for(int i = 0; i < rb.length; i++) {        //조건문을 통해 Button 설정 구현
            rb[i] = new Button(color[i]);
            c.add(rb[i]);
            rb[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Button r = (Button)e.getSource();
                    if(r.equals(rb[0])) {           //첫번쨰 배열인 경우 노란색
                        c.setBackground(Color.YELLOW);
                    }
                    else {      //두번째 인 경우 블루
                        c.setBackground(Color.BLUE);
                    }
                }
            });

        }
        addMouseMotionListener(this);

        this.setSize(300, 200);
        this.setVisible(true);
    }


    @Override
    public void mouseDragged(MouseEvent e) {        //마우스 드래그된 부분 좌표 설정하기 구현
        x = e.getX();
        y = e.getY();
        that.setTitle("MouseDragged (" + x + "," + y + ")");
    }

    @Override
    public void mouseMoved(MouseEvent e) {      //마우스 이동하는 부분 설정
        // no action
    }

    public static void main(String[] args) {
        new TwoButtons();
    }
}