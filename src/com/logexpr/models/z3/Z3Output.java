package com.logexpr.models.z3;

import com.logexpr.models.tree.Variable;
import com.microsoft.z3.Model;
import com.microsoft.z3.Status;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Z3Output {
    private HashMap<Variable, String> variableValues = new HashMap<>();
    private Optional<Model> model;
    private Status status = Status.UNKNOWN;
    private Optional<Z3Solver> solver;

    public HashMap<Variable, String> getVariableValues() {
        return variableValues;
    }

    public void setVariableValues(HashMap<Variable, String> variableValues) {
        this.variableValues = variableValues;
    }

    public List<Variable> getVariables() {
        return variableValues.keySet().stream().collect(Collectors.toList());
    }

    public Optional<Model> getModel() {
        return model;
    }

    public void setModel(Optional<Model> model) {
        this.model = model;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Optional<Z3Solver> getSolver() {
        return solver;
    }

    public void setSolver(Z3Solver solver) {
        this.solver = Optional.of(solver);
    }

    public boolean isSatisfiable() {
        return this.status == Status.SATISFIABLE;
    }

    public boolean isUnsatisfiable() {
        return this.status == Status.UNSATISFIABLE;
    }

    public boolean isUnknown() {
        return this.status == Status.UNKNOWN;
    }

    @Override
    public String toString() {
        if (this.isSatisfiable()) return "SAT";
        else if (this.isUnsatisfiable()) return "UNSAT";
        return "?";
    }

    public boolean nextValues() {
        if (this.solver.isEmpty()) return false;

        this.solver.get().disallowCurrentModelValues(this.getVariables());
        Z3Output newOutput = this.solver.get().check(this.getVariables());

        if (newOutput.isSatisfiable()) {
            this.variableValues = newOutput.variableValues;
            this.model = newOutput.model;
            this.status = newOutput.status;
        }

        return newOutput.isSatisfiable();
    }
}
