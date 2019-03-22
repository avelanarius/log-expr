package com.logexpr.gui;

import com.logexpr.gui.tables.Z3OutputTableModel;
import com.logexpr.models.z3.Z3Output;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModelInspectorUI {
    private JLabel labelNazwaModelu;
    private JLabel labelOpis;
    private JTable tableVariableValues;
    private JButton buttonOK;
    private JPanel contentPane;
    private JButton buttonInne;

    private Z3Output z3Output;
    private Z3OutputTableModel z3OutputTableModel;

    private JFrame frame;

    private void createWindow() {
        frame = new JFrame("Inspektor modelu");
        frame.setContentPane(this.contentPane);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public ModelInspectorUI(Z3Output z3Output) {
        createWindow();
        this.z3Output = z3Output;
        this.updateTable();
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        buttonInne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (z3Output.nextValues()) {
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(ModelInspectorUI.this.frame, "Nie istnieje kolejne wartościowanie!",
                            "Brak wartościowania", JOptionPane.INFORMATION_MESSAGE);
                    buttonInne.setEnabled(false);
                }
            }
        });
    }

    public ModelInspectorUI(Z3Output z3Output, String nazwaModelu, String opis) {
        this(z3Output);
        this.setNazwaModelu(nazwaModelu);
        this.setOpis(opis);
    }

    private void updateTable() {
        z3OutputTableModel = new Z3OutputTableModel(z3Output);
        this.tableVariableValues.setModel(z3OutputTableModel);
        this.setTableLook();
    }

    private void setTableLook() {
        this.tableVariableValues.getTableHeader().setFont(new Font("Dialog", Font.PLAIN, 13));
        this.tableVariableValues.setRowHeight(35);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.tableVariableValues.setDefaultRenderer(String.class, centerRenderer);
    }

    public void setNazwaModelu(String nazwaModelu) {
        this.labelNazwaModelu.setText(nazwaModelu);
        frame.setTitle("Inspektor modelu: " + nazwaModelu);
    }

    public void setOpis(String opis) {
        this.labelOpis.setText(opis);
    }
}
