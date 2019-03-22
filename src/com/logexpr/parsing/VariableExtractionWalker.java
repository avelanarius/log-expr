package com.logexpr.parsing;

import com.logexpr.antlr.LogExprGrammarBaseListener;
import com.logexpr.antlr.LogExprGrammarParser;
import com.logexpr.models.tree.LogicalVariable;
import com.logexpr.models.tree.MathVariable;
import com.logexpr.models.tree.Variable;

import java.util.ArrayList;
import java.util.HashMap;

public class VariableExtractionWalker extends LogExprGrammarBaseListener {
    private HashMap<String, Variable> variables = new HashMap<>();
    private ArrayList<String> errors = new ArrayList<>();

    public HashMap<String, Variable> getVariables() {
        return variables;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public VariableExtractionWalker() {
        this(new ArrayList<>());
    }

    public VariableExtractionWalker(ArrayList<Variable> existingVariables) {
        this.addVariables(existingVariables);
    }

    private void addVariables(ArrayList<Variable> existingVariables) {
        existingVariables.forEach(var -> this.tryToAddVariable(var));
    }

    @Override
    public void enterVarLogExpr(LogExprGrammarParser.VarLogExprContext ctx) {
        String variableName = ctx.ID().getSymbol().getText();
        LogicalVariable variable = new LogicalVariable(variableName);
        this.tryToAddVariable(variable);
    }

    @Override
    public void enterVarMathExpr(LogExprGrammarParser.VarMathExprContext ctx) {
        String variableName = ctx.ID().getSymbol().getText();
        MathVariable variable = new MathVariable(variableName);
        this.tryToAddVariable(variable);
    }

    private void tryToAddVariable(Variable newVariable) {
        if (this.doesVariableConflict(newVariable)) {
            Variable existingVariable = this.variables.get(newVariable.getVariableName());
            this.errors.add("Existing variable " + existingVariable.getVariableName() + " of type " + existingVariable.getVariableType()
                    + " conflicts with usage of " + newVariable.getVariableName() + " as type " + newVariable.getVariableType());
            return;
        }
        if (!this.variables.containsKey(newVariable.getVariableName())) {
            this.variables.put(newVariable.getVariableName(), newVariable);
        }
    }

    private boolean doesVariableConflict(Variable newVariable) {
        String newVariableName = newVariable.getVariableName();
        boolean notContains = !this.variables.containsKey(newVariableName);
        if (notContains) {
            return false;
        }

        Variable existingVariable = this.variables.get(newVariableName);
        boolean existingVariableSameType = existingVariable.getVariableType().equals(newVariable.getVariableType());
        return !existingVariableSameType;
    }
}
