package com.bingo.container;

import java.awt.event.MouseEvent;

import javax.swing.*;

import com.bingo.app.ContainerManage;
import com.bingo.common.ConstantConfig;
import com.bingo.common.JButtonAdapter;
import com.bingo.util.OperFileSuffUtil;
import com.bingo.util.OperLog;

public class ConfirmBtn extends JButtonAdapter {

    @Override
    public void mouseClicked(MouseEvent event) {
        String filePath = ContainerManage.getTextField().getText();
        if ("".equals(filePath)) {
            ContainerManage.appendTextArea(OperLog.operLog("请选择文件目录！"));
            return;
        }

        ButtonModel model = ContainerManage.getGroup().getSelection();
        if (model == null) {
            ContainerManage.appendTextArea(OperLog.operLog("请选择处理方式！"));
            return;
        }

        boolean isDecry;
        if (model.getActionCommand().equals(ConstantConfig.BTN_RADIO_ACTION_COMMAND_DECRY)) {
            isDecry = true;
        } else if (model.getActionCommand().equals(ConstantConfig.BTN_RADIO_ACTION_COMMAND_ENCRY)) {
            isDecry = false;
        } else {
            ContainerManage.appendTextArea(OperLog.operLog("处理方式异常！"));
            return;
        }

        OperFileSuffUtil.operMain(isDecry);
        ContainerManage.appendTextArea(OperLog.operLog("处理完成！"));
    }

    @Override
    public JButton buildJButton() {
        JButton button = new JButton(ConstantConfig.BTN_NAME_CONFIRM);
        // 设置文字居中
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        // 动作事件改到鼠标点击事件中
        button.addMouseListener(this);

        return button;
    }
}
