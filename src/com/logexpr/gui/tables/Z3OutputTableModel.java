package com.logexpr.gui.tables;

import com.bulenkov.iconloader.util.Pair;
import com.logexpr.models.tree.Variable;
import com.logexpr.models.z3.Z3Output;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Z3OutputTableModel extends AbstractTableModel {
    private Z3Output z3Output;
    private List<Pair<Variable, String>> variableValues = new ArrayList<>();

    public Z3OutputTableModel(Z3Output z3Output) {
        this.z3Output = z3Output;
        this.computeVariableValues();
    }

    private void computeVariableValues() {
        variableValues = z3Output.getVariableValues()
                .entrySet().stream().sorted(Comparator.comparing(q -> q.getKey().getVariableName()))
                .map(k -> new Pair<Variable, String>(k.getKey(), k.getValue())).collect(Collectors.toList());
    }

    @Override
    public int getRowCount() {
        return variableValues.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return variableValues.get(rowIndex).first.getVariableName();
            case 1:
                return "<html><b>" + variableValues.get(rowIndex).second + "</b></html>";
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nazwa zmiennej";
            case 1:
                return "Wartość";
        }
        return "";
    }
}
