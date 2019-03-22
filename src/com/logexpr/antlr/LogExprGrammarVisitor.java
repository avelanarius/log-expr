// Generated from C:/Users/avela/Dropbox/Codebase/JAVA/LogExpr/src\LogExprGrammar.g4 by ANTLR 4.7
package com.logexpr.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LogExprGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface LogExprGrammarVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link LogExprGrammarParser#fulldef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFulldef(LogExprGrammarParser.FulldefContext ctx);

    /**
     * Visit a parse tree produced by the {@code implIffLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitImplIffLogExpr(LogExprGrammarParser.ImplIffLogExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code andOrLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAndOrLogExpr(LogExprGrammarParser.AndOrLogExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code parenLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParenLogExpr(LogExprGrammarParser.ParenLogExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code cmpMathExprs}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCmpMathExprs(LogExprGrammarParser.CmpMathExprsContext ctx);

    /**
     * Visit a parse tree produced by the {@code varLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVarLogExpr(LogExprGrammarParser.VarLogExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code negLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNegLogExpr(LogExprGrammarParser.NegLogExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code truthValueLogExpr}
     * labeled alternative in {@link LogExprGrammarParser#logexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTruthValueLogExpr(LogExprGrammarParser.TruthValueLogExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code addSubMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddSubMathExpr(LogExprGrammarParser.AddSubMathExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code negMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNegMathExpr(LogExprGrammarParser.NegMathExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code parenMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParenMathExpr(LogExprGrammarParser.ParenMathExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code modMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitModMathExpr(LogExprGrammarParser.ModMathExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code valueMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitValueMathExpr(LogExprGrammarParser.ValueMathExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code mulDivMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMulDivMathExpr(LogExprGrammarParser.MulDivMathExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code iteMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIteMathExpr(LogExprGrammarParser.IteMathExprContext ctx);

    /**
     * Visit a parse tree produced by the {@code varMathExpr}
     * labeled alternative in {@link LogExprGrammarParser#mathexpr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVarMathExpr(LogExprGrammarParser.VarMathExprContext ctx);
}