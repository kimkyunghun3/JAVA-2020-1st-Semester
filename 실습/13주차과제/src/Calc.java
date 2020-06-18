import java.awt.*;

import java.awt.event.*;

import javax.swing.*;


class Frame5 extends JFrame {

    JPanel p;

    JButton cal;

    JLabel result;

    MyDialog dia;

    Frame5() {

        this.setTitle("다이얼로그 만들기");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();

        cal = new JButton("Calculate");

        cal.addActionListener(new My());

        result = new JLabel("계산 결과 출력");

        p.add(cal);

        p.add(result);

        this.add(p);

        this.setSize(300, 300);

        this.setVisible(true);

    }


    class My implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Calculate")) {

                dia = new MyDialog();

            } else if (e.getActionCommand().equals("Add")) {

                int a = Integer.parseInt(dia.a.getText());

                int b = Integer.parseInt(dia.b.getText());

                int sum = a + b;

                result.setText(Integer.toString(sum));

            } else if(e.getActionCommand().equals("Add")){


                double c = Double.parseDouble(dia.a.getText());
                JOptionPane.showMessageDialog(null, "정수가 아닙니다.", "Message", JOptionPane.ERROR_MESSAGE);
                double d = Double.parseDouble(dia.b.getText());
                JOptionPane.showMessageDialog(null, "정수가 아닙니다.", "Message", JOptionPane.ERROR_MESSAGE);
                }

            }

        }




    class MyDialog extends JDialog {

        JPanel p = new JPanel();

        JLabel la = new JLabel("두 수를 더합니다.");

        JTextField a = new JTextField(10);

        JTextField b = new JTextField(10);

        JButton add = new JButton("Add");

        MyDialog() {

            this.setTitle("Calculation Dialog");

            add.addActionListener(new My());

            p.add(la);

            p.add(a);

            p.add(b);

            p.add(add);

            this.add(p);

            this.setSize(150, 200);

            this.setVisible(true);

        }

    }

}


public class Calc {

    public static void main(String[] args) {

        new Frame5();

    }


}