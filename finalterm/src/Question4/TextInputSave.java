package Question4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextInputSave extends JFrame implements ActionListener{
    JButton save;
    JButton cancel;
    JTextField name = new JTextField(20);
    JTextField major = new JTextField(20);;
    JTextField address = new JTextField(20);;

    public TextInputSave() {
        setTitle("텍스트필드 입력과 파일저장"); //타이틀 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("이름 "));
        c.add(name);
        c.add(new JLabel("학과 "));
        c.add(major);
        c.add(new JLabel("주소 "));
        c.add(address);
        save = new JButton("확인");       //세이브 버튼
        cancel = new JButton("취소");
        save.addActionListener(this);
        cancel.addActionListener(this);
        c.add(save);
        c.add(cancel);

        setSize(300, 160);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {    //저장하는 부분
        Button r = (Button)e.getSource();
        if (r.equals(save)) {
            String text = name.getText() + "\n" + major.getText() + "\n" + address.getText();
            try {
                BufferedWriter outFile = new BufferedWriter(new FileWriter("output.txt"));
                outFile.write(text);
            }catch (IOException err) {
                err.printStackTrace();
            }
        } else {

        }
    }

    public static void main(String [] args) {
        new TextInputSave(); }
}

