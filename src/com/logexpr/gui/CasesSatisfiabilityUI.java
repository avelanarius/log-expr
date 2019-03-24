package com.logexpr.gui;

import com.logexpr.gui.tables.CasesSatisfiabilityTableModel;
import com.logexpr.models.problem.CasesSatisfiabilityAnalysis;
import com.logexpr.models.problem.ProblemDefinition;
import com.logexpr.models.z3.Z3Output;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Arrays;

public class CasesSatisfiabilityUI extends JComponent {
    private JTable table;
    private JPanel contentPane;

    private CasesSatisfiabilityAnalysis casesSatisfiabilityAnalysis = new CasesSatisfiabilityAnalysis();
    private CasesSatisfiabilityTableModel tableModel;

    public void update(ProblemDefinition definition) {
        this.setTableLook();
        this.tableModel = new CasesSatisfiabilityTableModel(definition, casesSatisfiabilityAnalysis);
        this.table.setModel(tableModel);
        this.table.setDefaultRenderer(Object.class, tableModel);
        Arrays.stream(this.table.getMouseListeners()).forEach(q -> this.table.removeMouseListener(q));
        this.table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                String nazwaZmiennej = (String) table.getValueAt(row, 0);
                if (row >= 0 && col >= 1) {
                    int itemIndex = row / 2;
                    boolean variableState = (row % 2 == 1);
                    boolean logicalExpressionState = (col == 2);

                    Z3Output z3Output = (Z3Output) table.getValueAt(row, col);

                    if (z3Output != null && z3Output.isSatisfiable()) {
                        ModelInspectorUI inspectorUI = new ModelInspectorUI(z3Output,
                                "Condition " + (logicalExpressionState ? "true" : "false"),
                                "Logical variable " + nazwaZmiennej + " is " + (variableState ? "true" : "false"));
                    }
                }
            }
        });
        casesSatisfiabilityAnalysis.analyzeAsync(definition, (CasesSatisfiabilityAnalysis.CaseDescription caseDesc) -> {
            tableModel.fireTableDataChanged();
        });
    }

    private void setTableLook() {
        this.table.getTableHeader().setFont(new Font("Dialog", Font.PLAIN, 15));
        this.table.setRowHeight(55);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.table.setDefaultRenderer(String.class, centerRenderer);
    }
}
