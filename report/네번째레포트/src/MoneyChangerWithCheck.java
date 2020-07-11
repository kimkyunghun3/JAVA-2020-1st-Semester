/*
 * 파일명 : MoneyChangetWithCheck.java
 * 입력 : -
 * 출력 : 입력한 금액에 맞게 각 동전이 얼만큼 필요한지 출력(체크박스 선택 안할 시 지정한 동전은 제외하고 출력)
 * 작성일 : 2020년 6월 20일
 * 작성자 : 20176088 김경훈
 *
 * Q. 잔돈 계산 프로그램을 구현하라(체크박스를 제외할 시 해당 잔돈 동전은 제외하고 계산)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MoneyChangerWithCheck extends JFrame
{
    Container cp;
    int[] monnom = {50000, 10000, 1000, 500, 100, 50, 10, 1};           //필요한 금액을 설정
    String[] str = {"금액", "오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};       //문자로 보여지도록 설정
    JLabel jl = new JLabel();
    JTextField[] jt = new JTextField[str.length];
    JButton jb = new JButton("계산");     //계산을 버튼으로 보이도록 설정
    JCheckBox[] jc = new JCheckBox[monnom.length - 1];      //CheckBox의 갯수를 설정
    boolean bl = true;
    boolean[] jcbl = new boolean[monnom.length];

    MoneyChangerWithCheck()
    {
        setTitle("Money Changer");          //타이틀명을 지정
        setBackground(Color.PINK);          //배경화면 색깔을 핑크색으로 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = getContentPane();
        setLayout(null);

        jl = new JLabel(str[0]);
        jl.setSize(50, 20);         //사이즈 설정
        jl.setLocation(20, 20);             //위치 설정
        cp.add(jl);         //Pane에 추가

        jt[0] = new JTextField(30);         //Text의 위치를 설정
        jt[0].setSize(100, 20);
        jt[0].setLocation(100, 20);
        cp.add(jt[0]);

        jb.setSize(70, 20);
        jb.setLocation(210, 20);
        jb.addActionListener(new actionjb());
        cp.add(jb);

        for(int i = 1; i < str.length; i++)         //반복문을 이용하여 위의 Label과 Text를 원하는 위치에 놓도록 구현
        {
            jcbl[i - 1] = true;
            jl = new JLabel(str[i]);
            jl.setHorizontalAlignment(JLabel.RIGHT);            //위치 설정
            jl.setSize(50, 20);
            jl.setLocation(50, 50+(i*20));

            jt[i] = new JTextField(30);
            jt[i].setHorizontalAlignment(JTextField.CENTER);            //위치 설정
            jt[i].setSize(70, 20);
            jt[i].setLocation(120, 50+(i*20));
            jt[i].setEditable(false);
            if(i < str.length - 1)
            {
                jc[i-1] = new JCheckBox();          //Checkbox 객체 생성
                jc[i-1].addItemListener(new itemjc());
                jc[i-1].setHorizontalAlignment(JCheckBox.RIGHT);
                jc[i-1].setSize(20, 20);
                jc[i-1].setLocation(210, 50+(i*20));
                cp.add(jc[i-1]);
            }
            cp.add(jl);
            cp.add(jt[i]);
        }
        setSize(300, 300);
        setVisible(true);
    }

    public class actionjb implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String mon = jt[0].getText();
            if(mon.length() == 0) return;

            int money = Integer.parseInt(mon);
            int m;

            for(int i=0; i<monnom.length; i++)
            {
                if(jcbl[i]==true)               //돈을 각각 나누어서 해당 동전에 맞게 들어가도록 설정
               {
                    m = money/monnom[i];
                    jt[i + 1].setText(Integer.toString(m));
                    if(m > 0) money = money % monnom[i];
                }
                else if (jcbl[i] == false)jt[i +1].setText("0");
            }
        }
    }
    public class itemjc implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            if(e.getStateChange()==ItemEvent.SELECTED) bl = true;        //체크박스가 체크된 경우
            else bl = false;    //체크박스를 체크하지 않는 경우

            for(int i = 0; i < jcbl.length; i++)
            {
                if (i == jcbl.length -1)
                {
                    jcbl[i] = true;
                }
                else if(e.getItem() == jc[i])
                {
                    jcbl[i] = bl;
                }
            }
        }

    }

    public static void main(String[] args)
    {
        new MoneyChangerWithCheck();
    }
}
