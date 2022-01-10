package com.bingo.container;

import java.awt.event.ActionEvent;

import javax.swing.*;

import com.bingo.common.ConstantConfig;
import com.bingo.common.JRadioBtnAdapter;

public class RadioEncryBtn extends JRadioBtnAdapter {

    @Override
    public JRadioButton buildRadioBtn() {
        JRadioButton radioButton = new JRadioButton(ConstantConfig.BTN_RADIO_NAME_ENCRY);

        radioButton.setActionCommand(ConstantConfig.BTN_RADIO_ACTION_COMMAND_ENCRY);

        radioButton.addActionListener(this);

        return radioButton;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
    }
}
