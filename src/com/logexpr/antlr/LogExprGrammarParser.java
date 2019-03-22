// Generated from C:/Users/avela/Dropbox/Codebase/JAVA/LogExpr/src\LogExprGrammar.g4 by ANTLR 4.7
package com.logexpr.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LogExprGrammarParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, AND = 19, OR = 20, IFF = 21, IMPL = 22, NEG = 23, ID = 24, INT = 25, WS = 26;
    public static final int
            RULE_fulldef = 0, RULE_logexpr = 1, RULE_mathexpr = 2;
    public static final String[] ruleNames = {
            "fulldef", "logexpr", "mathexpr"
    };

    private static final String[] _LITERAL_NAMES = {
            null, "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'true'", "'false'",
            "'('", "')'", "'-'", "'%'", "'*'", "'/'", "'+'", "'if'", "'then'", "'else'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, "AND", "OR", "IFF", "IMPL",
            "NEG", "ID", "INT", "WS"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "LogExprGrammar.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public LogExprGrammarParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class FulldefContext extends ParserRuleContext {
        public LogexprContext logexpr() {
            return getRuleContext(LogexprContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(LogExprGrammarParser.EOF, 0);
        }

        public FulldefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fulldef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterFulldef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitFulldef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitFulldef(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FulldefContext fulldef() throws RecognitionException {
        FulldefContext _localctx = new FulldefContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_fulldef);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(6);
                logexpr(0);
                setState(7);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LogexprContext extends ParserRuleContext {
        public LogexprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_logexpr;
        }

        public LogexprContext() {
        }

        public void copyFrom(LogexprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ImplIffLogExprContext extends LogexprContext {
        public Token op;

        public List<LogexprContext> logexpr() {
            return getRuleContexts(LogexprContext.class);
        }

        public LogexprContext logexpr(int i) {
            return getRuleContext(LogexprContext.class, i);
        }

        public TerminalNode IMPL() {
            return getToken(LogExprGrammarParser.IMPL, 0);
        }

        public TerminalNode IFF() {
            return getToken(LogExprGrammarParser.IFF, 0);
        }

        public ImplIffLogExprContext(LogexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).enterImplIffLogExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).exitImplIffLogExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitImplIffLogExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AndOrLogExprContext extends LogexprContext {
        public Token op;

        public List<LogexprContext> logexpr() {
            return getRuleContexts(LogexprContext.class);
        }

        public LogexprContext logexpr(int i) {
            return getRuleContext(LogexprContext.class, i);
        }

        public TerminalNode AND() {
            return getToken(LogExprGrammarParser.AND, 0);
        }

        public TerminalNode OR() {
            return getToken(LogExprGrammarParser.OR, 0);
        }

        public AndOrLogExprContext(LogexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterAndOrLogExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitAndOrLogExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitAndOrLogExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParenLogExprContext extends LogexprContext {
        public LogexprContext logexpr() {
            return getRuleContext(LogexprContext.class, 0);
        }

        public ParenLogExprContext(LogexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterParenLogExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitParenLogExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitParenLogExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CmpMathExprsContext extends LogexprContext {
        public Token cmp;

        public List<MathexprContext> mathexpr() {
            return getRuleContexts(MathexprContext.class);
        }

        public MathexprContext mathexpr(int i) {
            return getRuleContext(MathexprContext.class, i);
        }

        public CmpMathExprsContext(LogexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterCmpMathExprs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitCmpMathExprs(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitCmpMathExprs(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VarLogExprContext extends LogexprContext {
        public TerminalNode ID() {
            return getToken(LogExprGrammarParser.ID, 0);
        }

        public VarLogExprContext(LogexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterVarLogExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitVarLogExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitVarLogExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class NegLogExprContext extends LogexprContext {
        public TerminalNode NEG() {
            return getToken(LogExprGrammarParser.NEG, 0);
        }

        public LogexprContext logexpr() {
            return getRuleContext(LogexprContext.class, 0);
        }

        public NegLogExprContext(LogexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterNegLogExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitNegLogExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitNegLogExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TruthValueLogExprContext extends LogexprContext {
        public Token value;

        public TruthValueLogExprContext(LogexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).enterTruthValueLogExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).exitTruthValueLogExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitTruthValueLogExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LogexprContext logexpr() throws RecognitionException {
        return logexpr(0);
    }

    private LogexprContext logexpr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        LogexprContext _localctx = new LogexprContext(_ctx, _parentState);
        LogexprContext _prevctx = _localctx;
        int _startState = 2;
        enterRecursionRule(_localctx, 2, RULE_logexpr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(22);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                    case 1: {
                        _localctx = new NegLogExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(10);
                        match(NEG);
                        setState(11);
                        logexpr(7);
                    }
                    break;
                    case 2: {
                        _localctx = new CmpMathExprsContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(12);
                        mathexpr(0);
                        setState(13);
                        ((CmpMathExprsContext) _localctx).cmp = _input.LT(1);
                        _la = _input.LA(1);
                        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0))) {
                            ((CmpMathExprsContext) _localctx).cmp = (Token) _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(14);
                        mathexpr(0);
                    }
                    break;
                    case 3: {
                        _localctx = new VarLogExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(16);
                        match(ID);
                    }
                    break;
                    case 4: {
                        _localctx = new TruthValueLogExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(17);
                        ((TruthValueLogExprContext) _localctx).value = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == T__6 || _la == T__7)) {
                            ((TruthValueLogExprContext) _localctx).value = (Token) _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                    break;
                    case 5: {
                        _localctx = new ParenLogExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(18);
                        match(T__8);
                        setState(19);
                        logexpr(0);
                        setState(20);
                        match(T__9);
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(32);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(30);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                                case 1: {
                                    _localctx = new ImplIffLogExprContext(new LogexprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_logexpr);
                                    setState(24);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(25);
                                    ((ImplIffLogExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == IFF || _la == IMPL)) {
                                        ((ImplIffLogExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(26);
                                    logexpr(7);
                                }
                                break;
                                case 2: {
                                    _localctx = new AndOrLogExprContext(new LogexprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_logexpr);
                                    setState(27);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(28);
                                    ((AndOrLogExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == AND || _la == OR)) {
                                        ((AndOrLogExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(29);
                                    logexpr(6);
                                }
                                break;
                            }
                        }
                    }
                    setState(34);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class MathexprContext extends ParserRuleContext {
        public MathexprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mathexpr;
        }

        public MathexprContext() {
        }

        public void copyFrom(MathexprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class AddSubMathExprContext extends MathexprContext {
        public Token op;

        public List<MathexprContext> mathexpr() {
            return getRuleContexts(MathexprContext.class);
        }

        public MathexprContext mathexpr(int i) {
            return getRuleContext(MathexprContext.class, i);
        }

        public AddSubMathExprContext(MathexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).enterAddSubMathExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).exitAddSubMathExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitAddSubMathExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class NegMathExprContext extends MathexprContext {
        public MathexprContext mathexpr() {
            return getRuleContext(MathexprContext.class, 0);
        }

        public NegMathExprContext(MathexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterNegMathExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitNegMathExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitNegMathExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParenMathExprContext extends MathexprContext {
        public MathexprContext mathexpr() {
            return getRuleContext(MathexprContext.class, 0);
        }

        public ParenMathExprContext(MathexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).enterParenMathExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitParenMathExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitParenMathExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ModMathExprContext extends MathexprContext {
        public List<MathexprContext> mathexpr() {
            return getRuleContexts(MathexprContext.class);
        }

        public MathexprContext mathexpr(int i) {
            return getRuleContext(MathexprContext.class, i);
        }

        public ModMathExprContext(MathexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterModMathExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitModMathExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitModMathExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ValueMathExprContext extends MathexprContext {
        public TerminalNode INT() {
            return getToken(LogExprGrammarParser.INT, 0);
        }

        public ValueMathExprContext(MathexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).enterValueMathExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitValueMathExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitValueMathExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MulDivMathExprContext extends MathexprContext {
        public Token op;

        public List<MathexprContext> mathexpr() {
            return getRuleContexts(MathexprContext.class);
        }

        public MathexprContext mathexpr(int i) {
            return getRuleContext(MathexprContext.class, i);
        }

        public MulDivMathExprContext(MathexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).enterMulDivMathExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener)
                ((LogExprGrammarListener) listener).exitMulDivMathExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitMulDivMathExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IteMathExprContext extends MathexprContext {
        public LogexprContext logexpr() {
            return getRuleContext(LogexprContext.class, 0);
        }

        public List<MathexprContext> mathexpr() {
            return getRuleContexts(MathexprContext.class);
        }

        public MathexprContext mathexpr(int i) {
            return getRuleContext(MathexprContext.class, i);
        }

        public IteMathExprContext(MathexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterIteMathExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitIteMathExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitIteMathExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VarMathExprContext extends MathexprContext {
        public TerminalNode ID() {
            return getToken(LogExprGrammarParser.ID, 0);
        }

        public VarMathExprContext(MathexprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).enterVarMathExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogExprGrammarListener) ((LogExprGrammarListener) listener).exitVarMathExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LogExprGrammarVisitor)
                return ((LogExprGrammarVisitor<? extends T>) visitor).visitVarMathExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final MathexprContext mathexpr() throws RecognitionException {
        return mathexpr(0);
    }

    private MathexprContext mathexpr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        MathexprContext _localctx = new MathexprContext(_ctx, _parentState);
        MathexprContext _prevctx = _localctx;
        int _startState = 4;
        enterRecursionRule(_localctx, 4, RULE_mathexpr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(51);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__10: {
                        _localctx = new NegMathExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(36);
                        match(T__10);
                        setState(37);
                        mathexpr(8);
                    }
                    break;
                    case T__15: {
                        _localctx = new IteMathExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(38);
                        match(T__15);
                        setState(39);
                        logexpr(0);
                        setState(40);
                        match(T__16);
                        setState(41);
                        mathexpr(0);
                        setState(42);
                        match(T__17);
                        setState(43);
                        mathexpr(4);
                    }
                    break;
                    case INT: {
                        _localctx = new ValueMathExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(45);
                        match(INT);
                    }
                    break;
                    case ID: {
                        _localctx = new VarMathExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(46);
                        match(ID);
                    }
                    break;
                    case T__8: {
                        _localctx = new ParenMathExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(47);
                        match(T__8);
                        setState(48);
                        mathexpr(0);
                        setState(49);
                        match(T__9);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(64);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(62);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                                case 1: {
                                    _localctx = new ModMathExprContext(new MathexprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_mathexpr);
                                    setState(53);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(54);
                                    match(T__11);
                                    setState(55);
                                    mathexpr(8);
                                }
                                break;
                                case 2: {
                                    _localctx = new MulDivMathExprContext(new MathexprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_mathexpr);
                                    setState(56);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(57);
                                    ((MulDivMathExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == T__12 || _la == T__13)) {
                                        ((MulDivMathExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(58);
                                    mathexpr(7);
                                }
                                break;
                                case 3: {
                                    _localctx = new AddSubMathExprContext(new MathexprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_mathexpr);
                                    setState(59);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(60);
                                    ((AddSubMathExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == T__10 || _la == T__14)) {
                                        ((AddSubMathExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(61);
                                    mathexpr(6);
                                }
                                break;
                            }
                        }
                    }
                    setState(66);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 1:
                return logexpr_sempred((LogexprContext) _localctx, predIndex);
            case 2:
                return mathexpr_sempred((MathexprContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean logexpr_sempred(LogexprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 6);
            case 1:
                return precpred(_ctx, 5);
        }
        return true;
    }

    private boolean mathexpr_sempred(MathexprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 2:
                return precpred(_ctx, 7);
            case 3:
                return precpred(_ctx, 6);
            case 4:
                return precpred(_ctx, 5);
        }
        return true;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34F\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
                    "\3\3\5\3\31\n\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3\4\3" +
                    "\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\66\n\4" +
                    "\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4A\n\4\f\4\16\4D\13\4\3\4\2\4\4" +
                    "\6\5\2\4\6\2\b\3\2\3\b\3\2\t\n\3\2\27\30\3\2\25\26\3\2\17\20\4\2\r\r\21" +
                    "\21\2O\2\b\3\2\2\2\4\30\3\2\2\2\6\65\3\2\2\2\b\t\5\4\3\2\t\n\7\2\2\3\n" +
                    "\3\3\2\2\2\13\f\b\3\1\2\f\r\7\31\2\2\r\31\5\4\3\t\16\17\5\6\4\2\17\20" +
                    "\t\2\2\2\20\21\5\6\4\2\21\31\3\2\2\2\22\31\7\32\2\2\23\31\t\3\2\2\24\25" +
                    "\7\13\2\2\25\26\5\4\3\2\26\27\7\f\2\2\27\31\3\2\2\2\30\13\3\2\2\2\30\16" +
                    "\3\2\2\2\30\22\3\2\2\2\30\23\3\2\2\2\30\24\3\2\2\2\31\"\3\2\2\2\32\33" +
                    "\f\b\2\2\33\34\t\4\2\2\34!\5\4\3\t\35\36\f\7\2\2\36\37\t\5\2\2\37!\5\4" +
                    "\3\b \32\3\2\2\2 \35\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\5\3\2\2" +
                    "\2$\"\3\2\2\2%&\b\4\1\2&\'\7\r\2\2\'\66\5\6\4\n()\7\22\2\2)*\5\4\3\2*" +
                    "+\7\23\2\2+,\5\6\4\2,-\7\24\2\2-.\5\6\4\6.\66\3\2\2\2/\66\7\33\2\2\60" +
                    "\66\7\32\2\2\61\62\7\13\2\2\62\63\5\6\4\2\63\64\7\f\2\2\64\66\3\2\2\2" +
                    "\65%\3\2\2\2\65(\3\2\2\2\65/\3\2\2\2\65\60\3\2\2\2\65\61\3\2\2\2\66B\3" +
                    "\2\2\2\678\f\t\2\289\7\16\2\29A\5\6\4\n:;\f\b\2\2;<\t\6\2\2<A\5\6\4\t" +
                    "=>\f\7\2\2>?\t\7\2\2?A\5\6\4\b@\67\3\2\2\2@:\3\2\2\2@=\3\2\2\2AD\3\2\2" +
                    "\2B@\3\2\2\2BC\3\2\2\2C\7\3\2\2\2DB\3\2\2\2\b\30 \"\65@B";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}