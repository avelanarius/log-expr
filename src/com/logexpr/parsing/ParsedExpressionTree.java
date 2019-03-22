package com.logexpr.parsing;

import com.logexpr.antlr.LogExprGrammarLexer;
import com.logexpr.antlr.LogExprGrammarParser;
import com.logexpr.models.tree.Variable;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;

public class ParsedExpressionTree {
    private ParseTree parsedTree;

    public ParseTree getParsedTree() {
        return parsedTree;
    }

    private ArrayList<String> errors = new ArrayList<>();

    public ArrayList<String> getErrors() {
        return errors;
    }

    private ArrayList<Variable> variables = new ArrayList<>();

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public boolean wasSuccessful() {
        return errors.isEmpty();
    }

    public boolean parse(String text) {
        return this.parse(text, new ArrayList<>());
    }

    public boolean parse(String text, ArrayList<Variable> existingVariables) {
        this.clearErrors();

        this.parseToParseTree(text);

        if (!this.wasSuccessful()) return this.wasSuccessful();

        this.extractVariables(existingVariables);

        return this.wasSuccessful();
    }

    private void clearErrors() {
        this.errors = new ArrayList<>();
    }

    private void parseToParseTree(String text) {
        if (text.trim().isEmpty()) text = "true";

        LogExprGrammarLexer lexer = new LogExprGrammarLexer(CharStreams.fromString(text));
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

        lexer.removeErrorListeners();
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                                    Object offendingSymbol,
                                    int line, int charPositionInLine,
                                    String msg,
                                    RecognitionException e) {
                errors.add("Line " + line + " character " + charPositionInLine + ": " + msg);
            }
        });

        LogExprGrammarParser parser = new LogExprGrammarParser(commonTokenStream);

        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                                    Object offendingSymbol,
                                    int line, int charPositionInLine,
                                    String msg,
                                    RecognitionException e) {
                errors.add("Line " + line + " character " + charPositionInLine + ": " + msg);
            }
        });

        this.parsedTree = parser.fulldef().logexpr();
    }

    private void extractVariables(ArrayList<Variable> existingVariables) {
        ParseTreeWalker walker = new ParseTreeWalker();
        VariableExtractionWalker extractionWalker = new VariableExtractionWalker(existingVariables);

        walker.walk(extractionWalker, this.parsedTree);

        this.errors.addAll(extractionWalker.getErrors());
        if (!extractionWalker.getVariables().isEmpty()) {
            this.variables = new ArrayList<>(extractionWalker.getVariables().values());
        }
    }
}
