package com.generater.gui;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class OnBlurEventListener implements FocusListener, DocumentListener {

    private String oldValue;

    private boolean firstGetFocus = Boolean.TRUE;
    @Override
    public void focusGained(FocusEvent e) {
        if(this.firstGetFocus){
            this.firstGetFocus = Boolean.FALSE;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

}
