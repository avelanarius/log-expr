package com.logexpr.parsing;

import com.logexpr.antlr.LogExprGrammarBaseVisitor;
import com.logexpr.antlr.LogExprGrammarParser;
import com.microsoft.z3.*;

public class Z3ExpressionVisitor extends LogExprGrammarBaseVisitor<Expr> {
    private Context z3Context;

    public Z3ExpressionVisitor(Context z3Context) {
        this.z3Context = z3Context;
    }

    @Override
    public Expr visitImplIffLogExpr(LogExprGrammarParser.ImplIffLogExprContext ctx) {
        BoolExpr leftSide = (BoolExpr) visit(ctx.logexpr(0));
        BoolExpr rightSide = (BoolExpr) visit(ctx.logexpr(1));
        switch (ctx.op.getType()) {
            case LogExprGrammarParser.IMPL:
                return z3Context.mkImplies(leftSide, rightSide);
            case LogExprGrammarParser.IFF:
                return z3Context.mkIff(leftSide, rightSide);
        }
        throw new UnsupportedOperationException("OP of value " + ctx.op.getType() + " is not implemented!");
    }

    @Override
    public Expr visitAndOrLogExpr(LogExprGrammarParser.AndOrLogExprContext ctx) {
        BoolExpr leftSide = (BoolExpr) visit(ctx.logexpr(0));
        BoolExpr rightSide = (BoolExpr) visit(ctx.logexpr(1));
        switch (ctx.op.getType()) {
            case LogExprGrammarParser.AND:
                return z3Context.mkAnd(leftSide, rightSide);
            case LogExprGrammarParser.OR:
                return z3Context.mkOr(leftSide, rightSide);
        }
        throw new UnsupportedOperationException("OP of value " + ctx.op.getType() + " is not implemented!");
    }

    @Override
    public Expr visitParenLogExpr(LogExprGrammarParser.ParenLogExprContext ctx) {
        return visit(ctx.logexpr());
    }

    @Override
    public Expr visitCmpMathExprs(LogExprGrammarParser.CmpMathExprsContext ctx) {
        ArithExpr leftSide = (ArithExpr) visit(ctx.mathexpr(0));
        ArithExpr rightSide = (ArithExpr) visit(ctx.mathexpr(1));
        String cmp = ctx.cmp.getText();
        switch (cmp) {
            case "==":
                return z3Context.mkEq(leftSide, rightSide);
            case "!=":
                return z3Context.mkNot(z3Context.mkEq(leftSide, rightSide));
            case "<":
                return z3Context.mkLt(leftSide, rightSide);
            case ">":
                return z3Context.mkGt(leftSide, rightSide);
            case "<=":
                return z3Context.mkLe(leftSide, rightSide);
            case ">=":
                return z3Context.mkGe(leftSide, rightSide);
        }
        throw new UnsupportedOperationException("CMP of value " + cmp + " is not implemented!");
    }

    @Override
    public Expr visitVarLogExpr(LogExprGrammarParser.VarLogExprContext ctx) {
        String variableName = ctx.ID().getText();
        BoolExpr variable = z3Context.mkBoolConst(variableName);
        return variable;
    }

    @Override
    public Expr visitNegLogExpr(LogExprGrammarParser.NegLogExprContext ctx) {
        BoolExpr inner = (BoolExpr) visit(ctx.logexpr());
        BoolExpr negation = z3Context.mkNot(inner);
        return negation;
    }

    @Override
    public Expr visitTruthValueLogExpr(LogExprGrammarParser.TruthValueLogExprContext ctx) {
        String truthValue = ctx.value.getText();
        boolean boolValue = Boolean.valueOf(truthValue);
        BoolExpr z3Value = z3Context.mkBool(boolValue);
        return z3Value;
    }

    @Override
    public Expr visitAddSubMathExpr(LogExprGrammarParser.AddSubMathExprContext ctx) {
        ArithExpr leftSide = (ArithExpr) visit(ctx.mathexpr(0));
        ArithExpr rightSide = (ArithExpr) visit(ctx.mathexpr(1));
        String op = ctx.op.getText();
        switch (op) {
            case "+":
                return z3Context.mkAdd(leftSide, rightSide);
            case "-":
                return z3Context.mkSub(leftSide, rightSide);
        }
        throw new UnsupportedOperationException("OP of value " + ctx.op.getText() + " is not implemented!");
    }

    @Override
    public Expr visitParenMathExpr(LogExprGrammarParser.ParenMathExprContext ctx) {
        return visit(ctx.mathexpr());
    }

    @Override
    public Expr visitModMathExpr(LogExprGrammarParser.ModMathExprContext ctx) {
        IntExpr leftSide = (IntExpr) visit(ctx.mathexpr(0));
        IntExpr rightSide = (IntExpr) visit(ctx.mathexpr(1));
        IntExpr modValue = z3Context.mkMod(leftSide, rightSide);
        return modValue;
    }

    @Override
    public Expr visitValueMathExpr(LogExprGrammarParser.ValueMathExprContext ctx) {
        String stringValue = ctx.INT().getText();
        return z3Context.mkInt(stringValue);
    }

    @Override
    public Expr visitMulDivMathExpr(LogExprGrammarParser.MulDivMathExprContext ctx) {
        ArithExpr leftSide = (ArithExpr) visit(ctx.mathexpr(0));
        ArithExpr rightSide = (ArithExpr) visit(ctx.mathexpr(1));
        String op = ctx.op.getText();
        switch (op) {
            case "*":
                return z3Context.mkMul(leftSide, rightSide);
            case "/":
                return z3Context.mkDiv(leftSide, rightSide);
        }
        throw new UnsupportedOperationException("OP of value " + ctx.op.getText() + " is not implemented!");
    }

    @Override
    public Expr visitVarMathExpr(LogExprGrammarParser.VarMathExprContext ctx) {
        String variableName = ctx.ID().getText();
        IntExpr variable = z3Context.mkIntConst(variableName);
        return variable;
    }

    @Override
    public Expr visitNegMathExpr(LogExprGrammarParser.NegMathExprContext ctx) {
        ArithExpr expr = (ArithExpr) visit(ctx.mathexpr());
        return z3Context.mkSub(z3Context.mkInt(0), expr);
    }

    @Override
    public Expr visitIteMathExpr(LogExprGrammarParser.IteMathExprContext ctx) {
        Expr ifExpr = visit(ctx.mathexpr(0));
        Expr elseExpr = visit(ctx.mathexpr(1));
        BoolExpr condition = (BoolExpr) visit(ctx.logexpr());
        return z3Context.mkITE(condition, ifExpr, elseExpr);
    }
}
