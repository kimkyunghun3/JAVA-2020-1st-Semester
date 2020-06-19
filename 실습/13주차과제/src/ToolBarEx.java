import javax.swing.*;
import java.awt.*;

public class ToolBarEx extends JFrame {
    private Container contentPane;
    public ToolBarEx() {
        setTitle("툴바 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = getContentPane();
        createToolBar();
        setSize(400,150);
        setVisible(true);
    }

    private  void createToolBar() {
        JToolBar bar = new JToolBar("kyunghoon Menu");
        bar.setBackground(Color.LIGHT_GRAY);
        JButton newBtn = new JButton("New");
        bar.add(newBtn);

        JButton OpenBtn = new JButton("Open");
        bar.add(OpenBtn);
        bar.addSeparator();


        JButton printBtn = new JButton(new ImageIcon("/Users/eddy/Desktop/print.gif"));
        printBtn.setToolTipText("Print");
        bar.add(printBtn);

        JButton saveBtn = new JButton(new ImageIcon("/Users/eddy/Desktop/save.jpg"));
        saveBtn.setToolTipText("Save");
        bar.add(saveBtn);

        bar.add(new JLabel("search"));

        JTextField tf = new JTextField(" ");
        bar.add(tf);

        JComboBox combo = new JComboBox();
        combo.addItem("apple");
        combo.addItem("banana");
        combo.addItem("kiwi");
        combo.addItem("mango");
        bar.add(combo);

        contentPane.add(bar, BorderLayout.NORTH);
        pack();
    }

    public static void main(String [] args) {
        new ToolBarEx();
    }
}