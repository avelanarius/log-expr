package com.logexpr.gui;

import com.logexpr.models.problem.BasicSatisfiablityAnalysis;
import com.logexpr.models.problem.ProblemDefinition;
import com.microsoft.z3.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicSatisfiablityUI extends JComponent {
    private JLabel labelWartoscLogicznaBasicSat;
    private JLabel labelFalszBasicSat;
    private JLabel labelPrawdaBasicSat;
    private JButton pokazPrzykladPrawdaBasicSat;
    private JButton pokazPrzykladFalszBasicSat;
    private JPanel mainPanel;

    public BasicSatisfiablityUI() {
        updateGUI();
        pokazPrzykladFalszBasicSat.addActionListener(e -> {
            ModelInspectorUI inspectorUI = new ModelInspectorUI(basicSatisfiablityAnalysis.getFalseOutput(),
                    "Wyrażenie fałszywe", "Przykład wartości zmiennych, dla których podany warunek jest fałszywy i zgodny z dziedziną");

        });
        pokazPrzykladPrawdaBasicSat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModelInspectorUI inspectorUI = new ModelInspectorUI(basicSatisfiablityAnalysis.getTrueOutput(),
                        "Wyrażenie prawdziwe", "Przykład wartości zmiennych, dla których podany warunek jest prawdziwy i zgodny z dziedziną");
            }
        });
    }

    private BasicSatisfiablityAnalysis basicSatisfiablityAnalysis = new BasicSatisfiablityAnalysis();

    public void update(ProblemDefinition definition) {
        enableLoadingIndicator();
        this.basicSatisfiablityAnalysis.analyzeAsync(definition, () -> updateTrueValueUI(), () -> updateFalseValueUI(), () -> updateStatus());
    }

    private void enableLoadingIndicator() {
        labelWartoscLogicznaBasicSat.setText("");
        labelWartoscLogicznaBasicSat.setIcon(getIcon("spinner.gif"));

        labelFalszBasicSat.setText("");
        labelFalszBasicSat.setIcon(getIcon("spinner.gif"));

        labelPrawdaBasicSat.setText("");
        labelPrawdaBasicSat.setIcon(getIcon("spinner.gif"));
    }

    private void updateGUI() {
        updateFalseValueUI();
        updateTrueValueUI();
        updateStatus();
    }

    private void updateStatus() {
        labelWartoscLogicznaBasicSat.setIcon(getIcon("search.png"));
        labelWartoscLogicznaBasicSat.setText(basicSatisfiablityAnalysis.getDescriptiveStatus());
    }

    private void updateFalseValueUI() {
        if (basicSatisfiablityAnalysis.getFalseStatus().equals(Status.SATISFIABLE)) {
            pokazPrzykladFalszBasicSat.setEnabled(true);
            labelFalszBasicSat.setText("Istnieje");
            labelFalszBasicSat.setIcon(getIcon("checked.png"));
        } else if (basicSatisfiablityAnalysis.getFalseStatus().equals(Status.UNKNOWN)) {
            pokazPrzykladFalszBasicSat.setEnabled(false);
            labelFalszBasicSat.setText("Nie wiadomo");
            labelFalszBasicSat.setIcon(getIcon("question-sign.png"));
        } else {
            pokazPrzykladFalszBasicSat.setEnabled(false);
            labelFalszBasicSat.setText("Nie istnieje");
            labelFalszBasicSat.setIcon(getIcon("cancel.png"));
        }
    }

    private void updateTrueValueUI() {
        if (basicSatisfiablityAnalysis.getTrueStatus().equals(Status.SATISFIABLE)) {
            pokazPrzykladPrawdaBasicSat.setEnabled(true);
            labelPrawdaBasicSat.setText("Istnieje");
            labelPrawdaBasicSat.setIcon(getIcon("checked.png"));
        } else if (basicSatisfiablityAnalysis.getTrueStatus().equals(Status.UNKNOWN)) {
            pokazPrzykladPrawdaBasicSat.setEnabled(false);
            labelPrawdaBasicSat.setText("Nie wiadomo");
            labelPrawdaBasicSat.setIcon(getIcon("question-sign.png"));
        } else {
            pokazPrzykladPrawdaBasicSat.setEnabled(false);
            labelPrawdaBasicSat.setText("Nie istnieje");
            labelPrawdaBasicSat.setIcon(getIcon("cancel.png"));
        }
    }

    private ImageIcon getIcon(String name) {
        return new ImageIcon(getClass().getClassLoader().getResource(name));
    }
}
