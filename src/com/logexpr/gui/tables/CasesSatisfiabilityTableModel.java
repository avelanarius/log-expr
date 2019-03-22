package com.logexpr.gui.tables;

import com.logexpr.models.problem.CasesSatisfiabilityAnalysis;
import com.logexpr.models.problem.ProblemDefinition;
import com.logexpr.models.z3.Z3Output;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CasesSatisfiabilityTableModel extends AbstractTableModel implements TableCellRenderer {
    private ArrayList<String> variables;
    private CasesSatisfiabilityAnalysis casesAnalysis;

    public CasesSatisfiabilityTableModel(ProblemDefinition problemDefinition, CasesSatisfiabilityAnalysis cas) {
        this.variables = problemDefinition.getVariables().stream()
                .filter(q -> q.getVariableType().equals("LOGICAL"))
                .map(q -> q.getVariableName()).sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        this.casesAnalysis = cas;
    }

    @Override
    public int getRowCount() {
        return this.variables.size() * 2;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int itemIndex = rowIndex / 2;
        boolean variableState = (rowIndex % 2 == 1);
        String variableName = variables.get(itemIndex);

        switch (columnIndex) {
            case 0:
                return variableName;
            case 1:
                return this.casesAnalysis.getOutput(variableName, variableState, false);
            case 2:
                return this.casesAnalysis.getOutput(variableName, variableState, true);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Zmienna logiczna (wartość)";
            case 1:
                return "Fałsz";
            case 2:
                return "Prawda";
        }
        return "";
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (column == 0) {
            boolean variableState = (row % 2 == 1);
            JLabel label = new JLabel();
            label.setFont(new Font("Dialog", Font.PLAIN, 13));
            label.setText("<html>" + value + " (" + (variableState ? "Prawda" : "Fałsz") + ")</html>");
            if (variableState) label.setForeground(new Color(0, 214, 0));
            else label.setForeground(Color.red);
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 9));
            panel.add(label);
            return panel;
        } else {
            Z3Output z3Output = (Z3Output) value;
            JLabel label = new JLabel();
            label.setFont(new Font("Dialog", Font.PLAIN, 13));
            if (z3Output == null) {
                label.setText("<html><i>Obliczanie...</i></html>");
            } else if (z3Output.isUnknown()) {
                label.setText("<html><b>Nie wiadomo</b></html>");
                label.setIcon(getIcon("question-sign.png"));
            } else if (z3Output.isSatisfiable()) {
                label.setText("<html><b>Istnieje</b></html>");
                label.setIcon(getIcon("checked.png"));
            } else {
                label.setText("<html><b>Nie istnieje</b></html>");
                label.setIcon(getIcon("cancel.png"));
            }
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 9));
            panel.add(label);
            return panel;
        }
    }

    private ImageIcon getIcon(String name) {
        return new ImageIcon(getClass().getClassLoader().getResource(name));
    }
}
