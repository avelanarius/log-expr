package com.logexpr.models.problem;

import com.logexpr.models.tree.Variable;
import com.logexpr.parsing.ParsedExpressionTree;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProblemDefinition {
    private ParsedExpressionTree domain;
    private ParsedExpressionTree logicalExpression;

    private ArrayList<String> errors = new ArrayList<>();

    private ProblemDefinition() {

    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public boolean wasSuccessful() {
        return errors.isEmpty();
    }

    public ParsedExpressionTree getDomain() {
        return domain;
    }

    public ParsedExpressionTree getLogicalExpression() {
        return logicalExpression;
    }

    public ArrayList<Variable> getVariables() {
        return this.logicalExpression.getVariables();
    }

    public static ProblemDefinition getProblemDefinition(String domain, String logicalExpression) {
        ProblemDefinition problemDefinition = new ProblemDefinition();

        ParsedExpressionTree domainTree = new ParsedExpressionTree();
        domainTree.parse(domain);

        ParsedExpressionTree logicalExpressionTree = new ParsedExpressionTree();
        logicalExpressionTree.parse(logicalExpression, domainTree.getVariables());

        problemDefinition.domain = domainTree;
        problemDefinition.logicalExpression = logicalExpressionTree;

        problemDefinition.errors.addAll(domainTree.getErrors()
                .stream().map(q -> "Domain error: " + q).collect(Collectors.toList()));
        problemDefinition.errors.addAll(logicalExpressionTree.getErrors()
                .stream().map(q -> "Logical expression error: " + q).collect(Collectors.toList()));

        return problemDefinition;
    }
}
