grammar LogExprGrammar;

fulldef : logexpr EOF;

logexpr : NEG logexpr #negLogExpr
     | logexpr op=(IMPL|IFF) logexpr #implIffLogExpr
     | logexpr op=(AND|OR) logexpr #andOrLogExpr
     | mathexpr cmp=('=='|'!='|'<'|'>'|'<='|'>=') mathexpr #cmpMathExprs
     | ID #varLogExpr
     | value=('true'|'false') #truthValueLogExpr
     | '(' logexpr ')' #parenLogExpr
     ;

mathexpr : '-' mathexpr #negMathExpr
         | mathexpr '%' mathexpr #modMathExpr
         | mathexpr op=('*'|'/') mathexpr #mulDivMathExpr
         | mathexpr op=('+'|'-') mathexpr #addSubMathExpr
         | 'if' logexpr 'then' mathexpr 'else' mathexpr #iteMathExpr
         | INT #valueMathExpr
         | ID #varMathExpr
         | '(' mathexpr ')' #parenMathExpr
         ;

AND : 'and'
    | 'AND'
    | '&&'
    | ';'
    ;

OR : 'or'
    | 'OR'
    | '||'
    ;

IFF : '<=>'
    | '<->'
    | 'iff'
    | 'IFF'
    | 'if and only if'
    | 'IF AND ONLY IF'
    ;

IMPL : '=>'
     | '->'
     | 'implies'
     | 'IMPLIES'
     | 'then'
     | 'THEN'
     ;

NEG : 'not'
    | 'NOT'
    | '!'
    ;

ID : [a-zA-Z][a-zA-Z0-9]* ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;

