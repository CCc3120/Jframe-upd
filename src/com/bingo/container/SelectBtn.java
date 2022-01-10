package com.bingo.container;

import java.awt.event.MouseEvent;

import javax.swing.*;

import com.bingo.app.ContainerManage;
import com.bingo.common.JButtonAdapter;
import com.bingo.common.ConstantConfig;
import com.bingo.util.OperLog;

public class SelectBtn extends JButtonAdapter {

    @Override
    public void mouseClicked(MouseEvent event) {
        int status = ContainerManage.getFileChooser().showOpenDialog(ContainerManage.getjFrame());
        if (status == JFileChooser.APPROVE_OPTION) {
            String filePath = ContainerManage.getFileChooser().getSelectedFile().getAbsolutePath();
            ContainerManage.getTextField().setText(filePath);
            ContainerManage.appendTextArea(OperLog.operLog("选择文件：" + filePath));
        } else {
            ContainerManage.getTextField().setText("");
        }
        ContainerManage.getGroup().clearSelection();
    }

    @Override
    public JButton buildJButton() {
        JButton button = new JButton(ConstantConfig.BTN_NAME_SELECT);
        // 设置文字居中
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        // 动作事件改到鼠标点击事件中
        button.addMouseListener(this);

        return button;
    }
}
