package com.logexpr.models.problem;

import com.logexpr.models.tree.Variable;
import com.logexpr.models.z3.Z3Output;
import com.logexpr.models.z3.Z3Solver;
import com.logexpr.parsing.ParsedExpressionTree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CasesSatisfiabilityAnalysis {
    private List<Variable> logicalVariables;

    public class CaseDescription {
        public String variableName;
        public boolean variableState;
        public boolean logicalExpressionState;

        public CaseDescription(String variableName, boolean variableState, boolean logicalExpressionState) {
            this.variableName = variableName;
            this.variableState = variableState;
            this.logicalExpressionState = logicalExpressionState;
        }

        @Override
        public int hashCode() {
            int result = variableName.hashCode();
            result = 31 * result + (variableState ? 1 : 0);
            result = 31 * result + (logicalExpressionState ? 1 : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CaseDescription that = (CaseDescription) o;

            if (variableState != that.variableState) return false;
            if (logicalExpressionState != that.logicalExpressionState) return false;
            return variableName != null ? variableName.equals(that.variableName) : that.variableName == null;
        }
    }

    private ConcurrentHashMap<CaseDescription, Z3Output> casesOutput = new ConcurrentHashMap<>();
    private ProblemDefinition problemDefinition;

    public void analyze(ProblemDefinition problemDefinition) {
        this.problemDefinition = problemDefinition;
        this.casesOutput.clear();

        this.extractVariables(problemDefinition);

        logicalVariables.forEach(q ->
                this.analyzeCase(new CaseDescription(q.getVariableName(), false, false)));
        logicalVariables.forEach(q ->
                this.analyzeCase(new CaseDescription(q.getVariableName(), false, true)));
        logicalVariables.forEach(q ->
                this.analyzeCase(new CaseDescription(q.getVariableName(), true, false)));
        logicalVariables.forEach(q ->
                this.analyzeCase(new CaseDescription(q.getVariableName(), true, true)));
    }

    public void analyzeAsync(ProblemDefinition problemDefinition, Consumer<CaseDescription> caseAnalysed) {
        this.problemDefinition = problemDefinition;
        this.casesOutput.clear();

        this.extractVariables(problemDefinition);

        ArrayList<CompletableFuture> futures = new ArrayList<>();
        for (Variable logicalVariable : logicalVariables) {
            this.analyzeCaseAsync(caseAnalysed, logicalVariable, false, false);
            this.analyzeCaseAsync(caseAnalysed, logicalVariable, false, true);
            this.analyzeCaseAsync(caseAnalysed, logicalVariable, true, false);
            this.analyzeCaseAsync(caseAnalysed, logicalVariable, true, true);
        }
    }

    private void analyzeCaseAsync(Consumer<CaseDescription> caseAnalysed, Variable logicalVariable,
                                  boolean variableState, boolean logicalExpressionState) {
        CaseDescription caseDescription = new CaseDescription(logicalVariable.getVariableName(), variableState, logicalExpressionState);

        CompletableFuture caseFuture = CompletableFuture.runAsync(
                () -> analyzeCase(caseDescription));

        caseFuture.thenRun(() -> {
            caseAnalysed.accept(caseDescription);
        });
    }

    private void extractVariables(ProblemDefinition problemDefinition) {
        this.logicalVariables = problemDefinition.getVariables().stream().
                filter(q -> q.getVariableType().equals("LOGICAL")).collect(Collectors.toList());
    }

    private void analyzeCase(CaseDescription caseDescription) {
        Z3Solver solver = new Z3Solver();

        solver.addClause(problemDefinition.getDomain());

        ParsedExpressionTree logicalExpression = problemDefinition.getLogicalExpression();

        if (caseDescription.logicalExpressionState) solver.addClause(logicalExpression);
        else solver.addNotClause(logicalExpression);

        if (caseDescription.variableState) solver.addVariableTrueClause(caseDescription.variableName);
        else solver.addVariableFalseClause(caseDescription.variableName);

        Z3Output z3Output = solver.check(problemDefinition.getVariables());

        this.casesOutput.put(caseDescription, z3Output);
    }

    public Z3Output getOutput(String variableName, boolean variableState, boolean logicalExpressionState) {
        CaseDescription caseDescription = new CaseDescription(variableName, variableState, logicalExpressionState);
        if (casesOutput.containsKey(caseDescription)) return casesOutput.get(caseDescription);
        return null;
    }
}
