//import javax.swing.*;
//import javax.swing.filechooser.*;
//import java.awt.event.*;
//import java.awt.*;
//
//public class FileOpenAndSave extends JFrame {
//    private JLabel imageLabel = new JLabel();
//    public FileOpenAndSave() {
//        setTitle("메뉴로 배경 이미지 로딩하기");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Container c = getContentPane();
//        c.add(imageLabel);
//        createMenu();
//        setSize(350,200);
//        setVisible(true);
//    }
//
//    private void createMenu() {
//        JMenuBar mb = new JMenuBar();
//        JMenu fileMenu = new JMenu("파일");
//        JMenuItem openItem = new JMenuItem("열기");
//        JMenuItem openItem2 = new JMenuItem("저장");
//
//        openItem.addActionListener(
//                new OpenActionListener());
//        fileMenu.add(openItem);
//        fileMenu.add(openItem2);
//        mb.add(fileMenu);
//        setJMenuBar(mb);
//
//
//
//    }
//
//    class OpenActionListener implements ActionListener {
//        private JFileChooser chooser;
//
//        public OpenActionListener() {
//            chooser = new JFileChooser();
//        }
//        public void actionPerformed(ActionEvent e) {
//            FileNameExtensionFilter filter =
//                    new FileNameExtensionFilter("JPG & GIF Images",
//                            "jpg", "gif");
//            chooser.setFileFilter(filter);
//
//            int ret = chooser.showOpenDialog(null);
//            if(ret != JFileChooser.APPROVE_OPTION) {
//                JOptionPane.showMessageDialog(null,
//                        "파일을 선택하지 않았습니다", "경고",
//                        JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//            String filePath = chooser.getSelectedFile().getPath();
//            imageLabel.setIcon(new ImageIcon(filePath));
//            pack(); // 이미지의 크기에 맞추어 프레임 크기 조절
//        }
//
//
//    }
//    public static void main(String [] args) {
//        new FileOpenAndSave();
//    }
//}
//

import javafx.stage.FileChooser;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOpenAndSave extends JFrame {
    private JLabel imageLabel = new JLabel();
    public FileOpenAndSave() {
        setTitle("메뉴로 배경 이미지 로딩하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(imageLabel);
        createMenu();
        setSize(350,200);
        setVisible(true);
    }

    private void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("파일");
        JMenuItem openItem = new JMenuItem("열기");
        JMenuItem openItem2 = new JMenuItem("저장");

        openItem.addActionListener(
                new OpenL());
        openItem2.addActionListener( new SaveL());
        fileMenu.add(openItem);
        fileMenu.add(openItem2);
        mb.add(fileMenu);
        setJMenuBar(mb);
    }
    class OpenL implements ActionListener {
            private JFileChooser chooser;
            public OpenL() {
                chooser = new JFileChooser();
            }
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter =
                    new FileNameExtensionFilter("JPG & GIF Images",
                            "jpg", "gif");
            chooser.setFileFilter(filter);

            int ret = chooser.showOpenDialog(null);
            if (ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null,
                        "파일을 선택하지 않았습니다", "경고",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            String filePath = chooser.getSelectedFile().getPath();
            imageLabel.setIcon(new ImageIcon(filePath));
            pack();
        }
    }

    class SaveL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BufferedImage buffered = null;
            JFileChooser chooser = null;
            JFileChooser c = new JFileChooser();
            c.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
            // Demonstrate "Save" dialog:
            int rVal = c.showSaveDialog(FileOpenAndSave.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    ImageIO.write(buffered, "jpg", file);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                //                String filePath = chooser.getSelectedFile().getName();

            }
        }
    }
    public static void main(String[] args) {
        run(new FileOpenAndSave(), 250, 110);
    }
    public static void run(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
