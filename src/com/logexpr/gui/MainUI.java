package com.logexpr.gui;

import com.bulenkov.darcula.DarculaLaf;
import com.logexpr.models.problem.ProblemDefinition;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
    private JPanel problemDefinitionPane;
    private JTextArea taWarunekLogiczny;
    private JButton analizujProblemButton;
    private JTextArea taDziedzina;
    private BasicSatisfiablityUI basicSatisfiablityUI;
    private JTabbedPane tabbedPane;
    private JPanel casesPanel;
    private CasesSatisfiabilityUI casesSatisfiabilityUI;
    private JPanel mainPane;

    private JFrame jFrame;

    public MainUI() {
        analizujProblemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dziedzina = taDziedzina.getText();
                String warunekLogiczny = taWarunekLogiczny.getText();

                analizujProblemButtonDisable();

                analyzeProblem(dziedzina, warunekLogiczny);
            }
        });
        taWarunekLogiczny.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                analizujProblemButtonEnable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                analizujProblemButtonEnable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                analizujProblemButtonEnable();
            }
        });
        taDziedzina.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                analizujProblemButtonEnable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                analizujProblemButtonEnable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                analizujProblemButtonEnable();
            }
        });
    }

    private void analizujProblemButtonDisable() {
        analizujProblemButton.setEnabled(false);
        analizujProblemButton.setText("Analysis done!");
    }

    private void analizujProblemButtonEnable() {
        analizujProblemButton.setEnabled(true);
        analizujProblemButton.setText("Analyze problem");
    }

    private void analyzeProblem(String domain, String logicalExpression) {
        ProblemDefinition definition = ProblemDefinition.getProblemDefinition(domain, logicalExpression);

        if (definition.wasSuccessful()) {
            this.basicSatisfiablityUI.update(definition);
            this.casesSatisfiabilityUI.update(definition);
        } else {
            analizujProblemButton.setText("Definition problem!");
            this.showDefinitionErrors(definition);
        }
    }

    private void showDefinitionErrors(ProblemDefinition definition) {
        ErrorUI errorUI = new ErrorUI(definition.getErrors(), jFrame);
    }

    public static void main(String[] args) {
        setDarculaLookAndFeel();
        createWindow();
    }

    private static void setDarculaLookAndFeel() {
        BasicLookAndFeel darculaLaf = new DarculaLaf();
        try {
            UIManager.setLookAndFeel(darculaLaf);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private static void createWindow() {
        MainUI mainUI = new MainUI();
        JFrame frame = new JFrame("LogExpr");
        frame.setContentPane(mainUI.mainPane);
        mainUI.jFrame = frame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
