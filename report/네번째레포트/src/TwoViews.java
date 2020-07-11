/*
 * 파일명 : TwoViews.java
 * 입력 : -
 * 출력 : 메뉴바와 툴바를 통합되도록 출력
 * 작성일 : 2020년 6월 20일
 * 작성자 : 20176088 김경훈
 *
 * Q. 조건에 맞게 메뉴바와 툴바를 통합되어 출력하라.
 */

import javax.swing.*;
import java.awt.*;

public class TwoViews {
    public static void main(String [] args) {
        new customFrame();
    }
}
class customFrame extends JFrame {
    customFrame() {
        createMenubar();
        setLayout(new BorderLayout());
        createToolBar(BorderLayout.NORTH);      //북쪽으로 설정
        setTitle("menu bar and tool bar");      //메뉴바와 툴바 2개를 한꺼번에 나오는 타이틀명으로 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);      //프레임의 사이즈 설정
        setVisible(true);
    }
    void createMenubar() {          //메뉴바 부분
        JMenu fileMenu = new JMenu("파일");           //메뉴들 설정
        JMenu editMenu = new JMenu("편집");
        JMenu viewMenu = new JMenu("보기");
        viewMenu.add(new JMenuItem("화면확대"));        //viewMenu 부분에서 클릭시 나오는 메뉴들 구성
        viewMenu.add(new JMenuItem("화면축소"));
        viewMenu.addSeparator();        //분리선 설정
        viewMenu.add(new JMenuItem("쪽윤곽"));
        JMenu inputMenu = new JMenu("입력");
        JMenu printMenu = new JMenu("인쇄");
        JMenuBar mb = new JMenuBar();
        mb.add(fileMenu);       //메뉴들 하나씩 넣기
        mb.add(editMenu);
        mb.add(viewMenu);
        mb.add(inputMenu);
        mb.add(printMenu);
        setJMenuBar(mb);
    }
    void createToolBar(String layoutLocation) {
        JToolBar bar = new JToolBar("kyunghoon Menu");
        bar.setBackground(Color.LIGHT_GRAY);        //배경색 설정
        JButton newBtn = new JButton("New");        //문자열로 버튼 설정
        bar.add(newBtn);
        JButton OpenBtn = new JButton("Open");
        bar.add(OpenBtn);
        bar.addSeparator();
        JButton printBtn = new JButton(new ImageIcon("/Users/eddy/Desktop/print.gif")); //이미지로 버튼 설정
        printBtn.setToolTipText("Print");       //마우스 대면 이름 나오도록 구현
        bar.add(printBtn);
        JButton saveBtn = new JButton(new ImageIcon("/Users/eddy/Desktop/save.jpg"));
        saveBtn.setToolTipText("Save");
        bar.add(saveBtn);
        bar.add(new JLabel("search"));
        JTextField tf = new JTextField(" ");
        bar.add(tf);
        String[] comboBoxElements = {"apple", "banana", "kiwi", "mango"};       //콤보박스 설정
        JComboBox combo = new JComboBox(comboBoxElements);
        bar.add(combo);

        this.add(bar, layoutLocation);
    }
}