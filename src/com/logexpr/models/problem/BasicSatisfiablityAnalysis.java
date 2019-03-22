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
            return "<html>&nbsp;&nbsp;Wyrażenie przyjmuje wartości <i><u><font color=red>fałszywe</font></u></i> i <i><u><font color=#00d600>prawdziwe</font></u></i>.</html>";
        } else if (falseOutput.isSatisfiable() && trueOutput.isUnsatisfiable()) {
            return "<html>&nbsp;&nbsp;Wyrażenie logiczne jest <i><u><font color=red>zawsze fałszywe</font></u></i>.</html>";
        } else if (falseOutput.isUnsatisfiable() && trueOutput.isSatisfiable()) {
            return "<html>&nbsp;&nbsp;Wyrażenie logiczne jest <i><u><font color=#00d600>zawsze prawdziwe</font></u></i>.</html>";
        } else if (falseOutput.isUnsatisfiable() && trueOutput.isUnsatisfiable()) {
            return "<html>&nbsp;&nbsp;Dziedzina jest <i><u>pusta</u></i>!</html>";
        } else if (falseOutput.isSatisfiable() && trueOutput.isUnknown()) {
            return "<html>&nbsp;&nbsp;Wyrażenie przyjmuje wartości <i><u><font color=red>fałszywe</font></u></i>, <br>&nbsp;&nbsp;lecz <i><u>nie wiadomo</u></i> czy przyjmuje wartość prawdziwą.</html>";
        } else if (falseOutput.isUnknown() && trueOutput.isSatisfiable()) {
            return "<html>&nbsp;&nbsp;Wyrażenie przyjmuje wartości <i><u><font color=#00d600>prawdziwe</font></u></i>, <br>&nbsp;&nbsp;lecz <i><u>nie wiadomo</u></i> czy przyjmuje wartość fałszywą.</html>";
        } else if (falseOutput.isUnknown() && trueOutput.isUnknown()) {
            return "<html>&nbsp;&nbsp;<i><u>Nie wiadomo</u></i> jakie wartości logiczne przyjmuje wyrażenie.</html>";
        } else if (falseOutput.isUnsatisfiable() && trueOutput.isUnknown()) {
            return "<html>&nbsp;&nbsp;Wyrażenie nie przyjmuje wartości <i><u><font color=red>fałszywych</font></u></i>, <br>&nbsp;&nbsp;lecz <i><u>nie wiadomo</u></i> czy przyjmuje wartość prawdziwą.</html>";
        } else if (falseOutput.isUnknown() && trueOutput.isUnsatisfiable()) {
            return "<html>&nbsp;&nbsp;Wyrażenie nie przyjmuje wartości <i><u><font color=#00d600>prawdziwych</font></u></i>, <br>&nbsp;&nbsp;lecz <i><u>nie wiadomo</u></i> czy przyjmuje wartość fałszywą.</html>";
        }
        return "<html><i><u>Nie wiadomo</u></i> jakie wartości logiczne przyjmuje wyrażenie.</html>";
    }
}
