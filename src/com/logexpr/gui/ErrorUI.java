package com.logexpr.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;

/*

b == (if a % 2 == 0 then a + 1 else a - 1);
c == (if b % 2 == 0 then b + 1 else b - 1);




a == c





a + b + c == 123456
&&
a > 0 && b > 0 && c > 0
&&
a != b && a != c && b != c


(a * b * c) % 41 == 3


a + b + c == 123456
&&
a > 0 && b > 0 && c > 0
&&
a != b && a != c && b != c
&&
modulo == (a * b * c) % 14

modulo == 3
 */

public class ErrorUI {
    private JButton OKButton;
    private JPanel contentPane;
    private JTextArea taBledy;

    private JFrame frame;

    private void createWindow() {
        frame = new JFrame("Błąd!");
        frame.setContentPane(this.contentPane);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ErrorUI(ArrayList<String> errors, JFrame parent) {
        parent.setEnabled(false);
        createWindow();
        taBledy.setText(errors.stream().collect(Collectors.joining("\n")));
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                parent.setEnabled(true);
                parent.toFront();
                parent.requestFocus();
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parent.setEnabled(true);
                parent.toFront();
                parent.requestFocus();
            }
        });
    }
}
