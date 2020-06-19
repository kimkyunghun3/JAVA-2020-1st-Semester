/*
 * 파일명 : TwoFrame.java
 * 입력 : -
 * 출력 : 메뉴바와 툴바를 같은 화면에 나오도록 출력
 * 작성일 : 2020년 6월 19일
 * 작성자 : 20176088 김경훈
 *
 * Q. 조건에 맞게 메뉴바와 툴바를 같은 화면에 나오도록 출력하라.
 */

import javax.swing.*;
import java.awt.*;

public class TwoFrame extends JFrame {
    public TwoFrame() {
        setTitle("FigurePanelEx");
        setLayout(new GridLayout(2, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        this.add(new ToolBarEx());
        this.add(new FrameEx());
        setVisible(true);
    }

    class ToolBarEx extends JPanel {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
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

            pack();
        }
    }

    class FrameEx extends JPanel {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            createMenu();
            setSize(400, 200);
            setVisible(true);
        }

        private void createMenu() {
            JMenu fileMenu = new JMenu("파일");
            JMenu editMenu = new JMenu("편집");
            JMenu viewMenu = new JMenu("보기");
            viewMenu.add(new JMenuItem("화면확대"));
            viewMenu.add(new JMenuItem("화면축소"));
            viewMenu.addSeparator();
            viewMenu.add(new JMenuItem("쪽윤곽"));
            JMenu inputMenu = new JMenu("입력");
            JMenu printMenu = new JMenu("인쇄");
            JMenuBar mb = new JMenuBar();
            mb.add(fileMenu);
            mb.add(editMenu);
            mb.add(viewMenu);
            mb.add(inputMenu);
            mb.add(printMenu);
            setJMenuBar(mb);
        }
    }

    public static void main(String args[]) {
        new TwoFrame();
    }
}
