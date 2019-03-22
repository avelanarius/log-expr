// Generated from C:/Users/avela/Dropbox/Codebase/JAVA/LogExpr/src\LogExprGrammar.g4 by ANTLR 4.7
package com.logexpr.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogExprGrammarParser}.
 */
public interface LogExprGrammarListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link LogExprGrammarParser#fulldef}.
     *
     * @param ctx the parse tree
     */
    void enterFulldef(LogExprGrammarParser.FulldefContext ctx);

    /**
     * Exit a parse tree produced by {@link LogExprGrammarParser#fulldef}.
     *
     * @param ctx the parse tree
     */
    void exitFulldef(LogExprGrammarParser.FulldefContext ctx);

    /**
     * Enter a parse tree produced by the {@code implIffLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void enterImplIffLogExpr(LogExprGrammarParser.ImplIffLogExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code implIffLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void exitImplIffLogExpr(LogExprGrammarParser.ImplIffLogExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code andOrLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void enterAndOrLogExpr(LogExprGrammarParser.AndOrLogExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code andOrLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void exitAndOrLogExpr(LogExprGrammarParser.AndOrLogExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code parenLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void enterParenLogExpr(LogExprGrammarParser.ParenLogExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code parenLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void exitParenLogExpr(LogExprGrammarParser.ParenLogExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code cmpMathExprs}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void enterCmpMathExprs(LogExprGrammarParser.CmpMathExprsContext ctx);

    /**
     * Exit a parse tree produced by the {@code cmpMathExprs}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void exitCmpMathExprs(LogExprGrammarParser.CmpMathExprsContext ctx);

    /**
     * Enter a parse tree produced by the {@code varLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void enterVarLogExpr(LogExprGrammarParser.VarLogExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code varLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void exitVarLogExpr(LogExprGrammarParser.VarLogExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code negLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void enterNegLogExpr(LogExprGrammarParser.NegLogExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code negLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void exitNegLogExpr(LogExprGrammarParser.NegLogExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code truthValueLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void enterTruthValueLogExpr(LogExprGrammarParser.TruthValueLogExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code truthValueLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     */
    void exitTruthValueLogExpr(LogExprGrammarParser.TruthValueLogExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code addSubMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void enterAddSubMathExpr(LogExprGrammarParser.AddSubMathExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code addSubMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void exitAddSubMathExpr(LogExprGrammarParser.AddSubMathExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code negMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void enterNegMathExpr(LogExprGrammarParser.NegMathExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code negMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void exitNegMathExpr(LogExprGrammarParser.NegMathExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code parenMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void enterParenMathExpr(LogExprGrammarParser.ParenMathExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code parenMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void exitParenMathExpr(LogExprGrammarParser.ParenMathExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code modMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void enterModMathExpr(LogExprGrammarParser.ModMathExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code modMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void exitModMathExpr(LogExprGrammarParser.ModMathExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code valueMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void enterValueMathExpr(LogExprGrammarParser.ValueMathExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code valueMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void exitValueMathExpr(LogExprGrammarParser.ValueMathExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code mulDivMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void enterMulDivMathExpr(LogExprGrammarParser.MulDivMathExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code mulDivMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void exitMulDivMathExpr(LogExprGrammarParser.MulDivMathExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code iteMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void enterIteMathExpr(LogExprGrammarParser.IteMathExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code iteMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void exitIteMathExpr(LogExprGrammarParser.IteMathExprContext ctx);

    /**
     * Enter a parse tree produced by the {@code varMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void enterVarMathExpr(LogExprGrammarParser.VarMathExprContext ctx);

    /**
     * Exit a parse tree produced by the {@code varMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     */
    void exitVarMathExpr(LogExprGrammarParser.VarMathExprContext ctx);
}