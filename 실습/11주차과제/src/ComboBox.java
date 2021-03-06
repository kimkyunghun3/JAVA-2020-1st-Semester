import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBox extends JFrame{

    public ComboBox() {
        setTitle("JTextField ans JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JTextField text = new JTextField(10); //텍스트필드
        JComboBox <String> strCombo = new JComboBox <String> (); //콤보박스

        text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField t = (JTextField)e.getSource();
                strCombo.addItem(t.getText());  //콤보박스에 텍스트필드의 문자 올리기
            }
        });

        c.add(text);
        c.add(strCombo);

        setSize(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBox();

    }

}