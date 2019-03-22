package com.logexpr.models.tree;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

public class MathVariable extends Variable {
    public MathVariable(String variableName) {
        super(variableName);
    }

    @Override
    public String getVariableType() {
        return "MATH";
    }

    @Override
    public Expr getZ3ConstExpr(Context context) {
        return context.mkIntConst(this.getVariableName());
    }
}
