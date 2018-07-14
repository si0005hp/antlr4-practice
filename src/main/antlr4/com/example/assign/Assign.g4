grammar Assign;

r  : assign ;

assign: SP EQ Expr SEMICOLON ;

Expr : [0-9]+ ;

SEMICOLON : ';' ;
EQ : '=' ;
SP : 'sp' ; 
WS : [ \t\r\n]+ -> skip ;
