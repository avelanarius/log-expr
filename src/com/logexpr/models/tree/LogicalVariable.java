package com.logexpr.models.tree;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

public class LogicalVariable extends Variable {
    public LogicalVariable(String variableName) {
        super(variableName);
    }

    @Override
    public String getVariableType() {
        return "LOGICAL";
    }

    @Override
    public Expr getZ3ConstExpr(Context context) {
        return context.mkBoolConst(this.getVariableName());
    }
}
