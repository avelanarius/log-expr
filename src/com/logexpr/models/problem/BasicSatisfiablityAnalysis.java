package com.logexpr.models.problem;

import com.logexpr.models.z3.Z3Output;
import com.logexpr.models.z3.Z3Solver;
import com.microsoft.z3.Status;

import java.util.concurrent.CompletableFuture;

public class BasicSatisfiablityAnalysis {
    private Z3Output trueOutput = new Z3Output();
    private Z3Output falseOutput = new Z3Output();

    public Z3Output getTrueOutput() {
        return trueOutput;
    }

    public Z3Output getFalseOutput() {
        return falseOutput;
    }

    public Status getTrueStatus() {
        return trueOutput.getStatus();
    }

    public Status getFalseStatus() {
        return falseOutput.getStatus();
    }

    public void analyze(ProblemDefinition problemDefinition) {
        analyzeIfTrue(problemDefinition);
        analyzeIfFalse(problemDefinition);
    }

    public void analyzeAsync(ProblemDefinition problemDefinition,
                             Runnable trueValueComputed, Runnable falseValueComputed,
                             Runnable analyzeEnd) {
        CompletableFuture trueFuture = CompletableFuture.runAsync(
                () -> analyzeIfTrue(problemDefinition));

        CompletableFuture falseFuture = CompletableFuture.runAsync(
                () -> analyzeIfFalse(problemDefinition));

        trueFuture.thenRun(trueValueComputed);
        falseFuture.thenRun(falseValueComputed);

        trueFuture.runAfterBoth(falseFuture, analyzeEnd);
    }

    private void analyzeIfTrue(ProblemDefinition problemDefinition) {
        Z3Solver solver = new Z3Solver();

        solver.addClause(problemDefinition.getDomain());
        solver.addClause(problemDefinition.getLogicalExpression());

        this.trueOutput = solver.check(problemDefinition.getVariables());
    }

    private void analyzeIfFalse(ProblemDefinition problemDefinition) {
        Z3Solver solver = new Z3Solver();

        solver.addClause(problemDefinition.getDomain());
        solver.addNotClause(problemDefinition.getLogicalExpression());

        this.falseOutput = solver.check(problemDefinition.getVariables());
    }

    public String getDescriptiveStatus() {
        if (falseOutput.isSatisfiable() && trueOutput.isSatisfiable()) {
            return "<html>&nbsp;&nbsp;Condition can be <i><u><font color=red>false</font></u></i> or <i><u><font color=#00d600>true</font></u></i>.</html>";
        } else if (falseOutput.isSatisfiable() && trueOutput.isUnsatisfiable()) {
            return "<html>&nbsp;&nbsp;Condition is <i><u><font color=red>always false</font></u></i>.</html>";
        } else if (falseOutput.isUnsatisfiable() && trueOutput.isSatisfiable()) {
            return "<html>&nbsp;&nbsp;Condition is <i><u><font color=#00d600>always true</font></u></i>.</html>";
        } else if (falseOutput.isUnsatisfiable() && trueOutput.isUnsatisfiable()) {
            return "<html>&nbsp;&nbsp;Domain is <i><u>empty</u></i>!</html>";
        } else if (falseOutput.isSatisfiable() && trueOutput.isUnknown()) {
            return "<html>&nbsp;&nbsp;Condition can be <i><u><font color=red>false</font></u></i>, <br>&nbsp;&nbsp;but <i><u>it is unknown</u></i> if it can be true.</html>";
        } else if (falseOutput.isUnknown() && trueOutput.isSatisfiable()) {
            return "<html>&nbsp;&nbsp;Condition can be <i><u><font color=#00d600>true</font></u></i>, <br>&nbsp;&nbsp;but <i><u>it is unknown</u></i> if it can be false.</html>";
        } else if (falseOutput.isUnknown() && trueOutput.isUnknown()) {
            return "<html>&nbsp;&nbsp;Condition logical values are <i><u>unknown</u></i>.</html>";
        } else if (falseOutput.isUnsatisfiable() && trueOutput.isUnknown()) {
            return "<html>&nbsp;&nbsp;Condition cannot be <i><u><font color=red>false</font></u></i>, <br>&nbsp;&nbsp;but <i><u>it is unknown</u></i> if it can be true.</html>";
        } else if (falseOutput.isUnknown() && trueOutput.isUnsatisfiable()) {
            return "<html>&nbsp;&nbsp;Condition cannot be <i><u><font color=#00d600>true</font></u></i>, <br>&nbsp;&nbsp;but <i><u>it is unknown</u></i> if it can be false.</html>";
        }
        return "<html>Condition logical values are <i><u>unknown</u></i>.</html>";
    }
}
