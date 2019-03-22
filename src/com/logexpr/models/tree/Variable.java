package com.logexpr.models.tree;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

public abstract class Variable {
    private String variableName;

    public Variable(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public abstract String getVariableType();

    public abstract Expr getZ3ConstExpr(Context context);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variable variable = (Variable) o;

        return variableName != null ? variableName.equals(variable.variableName) : variable.variableName == null;
    }

    @Override
    public int hashCode() {
        return variableName != null ? variableName.hashCode() : 0;
    }
}
