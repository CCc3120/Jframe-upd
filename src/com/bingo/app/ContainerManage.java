package com.bingo.app;

import java.awt.*;

import javax.swing.*;

import com.bingo.container.ConfirmBtn;
import com.bingo.container.FrameMain;
import com.bingo.container.RadioDecryBtn;
import com.bingo.container.RadioEncryBtn;
import com.bingo.container.SelectBtn;

public class ContainerManage {

    // 主窗口
    private static JFrame jFrame;


    // 确认按钮
    private static JButton comfirmBtn;

    // 选择按钮
    private static JButton selectBtn;


    // 标题/提示
    private static JLabel label;

    // 单行文本
    private static JTextField textField;

    // 选择文件
    private static JFileChooser fileChooser;


    // 单选按钮组
    private static JRadioButton radioButton1;

    private static JRadioButton radioButton2;

    private static ButtonGroup group;


    // 滚动容器
    private static JScrollPane scrollPane;

    // 文本域
    private static JTextArea textArea;

    public void init() {
        jFrame = new FrameMain().buildJFrame();

        label = new JLabel("目录：");
        label.setBounds(5, 5, 36, 25);

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        textField = new JTextField();
        textField.setBounds(41, 6, 295, 23);
        textField.setEditable(false);

        selectBtn = new SelectBtn().buildJButton();
        selectBtn.setBounds(340, 5, 60, 25);

        comfirmBtn = new ConfirmBtn().buildJButton();
        comfirmBtn.setBounds(340, 30, 60, 25);

        group = new ButtonGroup();
        radioButton1 = new RadioEncryBtn().buildRadioBtn();
        radioButton1.setBounds(118, 30, 50, 25);
        radioButton2 = new RadioDecryBtn().buildRadioBtn();
        radioButton2.setBounds(178, 30, 50, 25);
        group.add(radioButton1);
        group.add(radioButton2);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        textArea.setBounds(5, 60, 395, 175);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(5, 60, 395, 175);
        //显示垂直滚动条
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //取消显示水平滚动条
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jFrame.setSize(410, 280);
        // 主界面获得容器JPanel
        JPanel jpanel = (JPanel) jFrame.getContentPane();
        jpanel.setLayout(null);

        jpanel.add(label);
        jpanel.add(textField);
        jpanel.add(selectBtn);
        jpanel.add(radioButton1);
        jpanel.add(radioButton2);
        jpanel.add(comfirmBtn);
        jpanel.add(scrollPane);
    }

    public static void appendTextArea(String message) {
        if (getTextArea().getText() == null || getTextArea().getText().equals("")) {
            getTextArea().append(message);
        } else {
            getTextArea().append(System.lineSeparator() + message);
        }
    }

    // =======================get======================

    public static JFrame getjFrame() {
        return jFrame;
    }

    public static JButton getComfirmBtn() {
        return comfirmBtn;
    }

    public static JButton getSelectBtn() {
        return selectBtn;
    }

    public static JLabel getLabel() {
        return label;
    }

    public static JTextField getTextField() {
        return textField;
    }

    public static JFileChooser getFileChooser() {
        return fileChooser;
    }

    public static JRadioButton getRadioButton1() {
        return radioButton1;
    }

    public static JRadioButton getRadioButton2() {
        return radioButton2;
    }

    public static ButtonGroup getGroup() {
        return group;
    }

    public static JScrollPane getScrollPane() {
        return scrollPane;
    }

    public static JTextArea getTextArea() {
        return textArea;
    }
}
