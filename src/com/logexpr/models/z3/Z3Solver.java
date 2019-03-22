package com.logexpr.models.z3;

import com.logexpr.models.tree.Variable;
import com.logexpr.parsing.ParsedExpressionTree;
import com.logexpr.parsing.Z3ExpressionVisitor;
import com.microsoft.z3.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Z3Solver {
    private Context z3Context;
    private Solver z3Solver;

    private Status solverStatus;

    public Status getSolverStatus() {
        return solverStatus;
    }

    public Optional<Model> getModel() {
        if (solverStatus.equals(Status.SATISFIABLE)) return Optional.of(z3Solver.getModel());
        return Optional.empty();
    }

    public Z3Solver() {
        this.z3Context = new Context();
        this.z3Solver = this.z3Context.mkSolver();
        this.setTimeout(5000);
    }

    public void setTimeout(int milliseconds) {
        Params params = this.z3Context.mkParams();
        params.add("timeout", milliseconds);
        z3Solver.setParameters(params);
    }

    public void addVariableTrueClause(String logicalVariableName) {
        z3Solver.add(z3Context.mkBoolConst(logicalVariableName));
    }

    public void addVariableFalseClause(String logicalVariableName) {
        z3Solver.add(z3Context.mkNot(z3Context.mkBoolConst(logicalVariableName)));
    }

    private void addClause(BoolExpr clause) {
        z3Solver.add(clause);
    }

    public void addClause(ParseTree parseTree) {
        Z3ExpressionVisitor visitor = new Z3ExpressionVisitor(z3Context);
        BoolExpr expr = (BoolExpr) visitor.visit(parseTree);
        this.addClause(expr);
    }

    public void addClause(ParsedExpressionTree parsedExpressionTree) {
        this.addClause(parsedExpressionTree.getParsedTree());
    }

    private void addNotClause(BoolExpr clause) {
        z3Solver.add(z3Context.mkNot(clause));
    }

    public void addNotClause(ParseTree parseTree) {
        Z3ExpressionVisitor visitor = new Z3ExpressionVisitor(z3Context);
        BoolExpr expr = (BoolExpr) visitor.visit(parseTree);
        this.addNotClause(expr);
    }

    public void addNotClause(ParsedExpressionTree parsedExpressionTree) {
        this.addNotClause(parsedExpressionTree.getParsedTree());
    }

    public Z3Output check(List<Variable> variables) {
        this.solverStatus = z3Solver.check();

        Z3Output output = new Z3Output();
        output.setModel(this.getModel());
        output.setVariableValues(this.getModelValues(variables));
        output.setStatus(solverStatus);
        output.setSolver(this);
        return output;
    }

    public HashMap<Variable, String> getModelValues(List<Variable> variables) {
        HashMap<Variable, String> modelValues = new HashMap<>();

        Optional<Model> model = this.getModel();

        if (model.isPresent()) {
            for (Variable variable : variables) {
                Expr exprValue = model.get().evaluate(variable.getZ3ConstExpr(this.z3Context), true);
                modelValues.put(variable, exprValue.toString());
            }
        }

        return modelValues;
    }

    public void disallowCurrentModelValues(List<Variable> variables) {
        Optional<Model> model = this.getModel();
        if (model.isEmpty()) return;

        List<BoolExpr> equalExpr = new ArrayList<>();
        for (Variable variable : variables) {
            Expr variableExpr = variable.getZ3ConstExpr(this.z3Context);
            Expr currValue = model.get().evaluate(variableExpr, true);
            equalExpr.add(z3Context.mkEq(variableExpr, currValue));
        }
        this.addNotClause(z3Context.mkAnd(equalExpr.stream().toArray(BoolExpr[]::new)));
    }
}
