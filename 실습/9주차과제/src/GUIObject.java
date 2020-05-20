import java.awt.*;
import javax.swing.*;

class MyFrame1 extends JFrame{
    MyFrame1(){
        setTitle("Lab10_1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //화면 닫기
        Container contentpane = getContentPane();
        //JPanel panel = new JPanel();
        contentpane.setLayout(new FlowLayout());

        // Create a button with text OK
        JButton jbtOK = new JButton("OK");
        // Create a label with text "Enter your name: "
        JLabel jlblName = new JLabel("Enter your name: ");
        // Create a text field with text "Type Name Here"
        JTextField jtfName = new JTextField("Type Name Here");
        // Create a check box with text bold
        JCheckBox jchkBold = new JCheckBox("Bold");
        // Create a radio button with text red
        JRadioButton jrbRed = new JRadioButton("Red");
        // Create a combo box with choices red, green, and blue
        JComboBox jcboColor = new JComboBox(new String[]{"Red",  "Green", "Blue"});

        //패널에 위에 있는 컴퍼넌트를 붙이기
        contentpane.add(jbtOK);
        contentpane.add(jlblName);
        contentpane.add(jtfName);
        contentpane.add(jchkBold);
        contentpane.add(jrbRed);
        contentpane.add(jcboColor);
        //add(panel) -> 패널이 화면에 나오는 방법

        setSize(300,300);//프레임 사이즈
        setVisible(true);//화면에 출력
    }

}

public class GUIObject {
    public static void main(String[] args) {
        MyFrame1 mf = new MyFrame1(); //MyFrame에 대한 객체 생성
    }

}