grammar Calc;

INT: [0-9]+ ;
ADD: '+' ;
SUB: '-' ;
MUL: '*' ;
DIV: '/' ;

expr
: term
| expr ADD term
| expr SUB term
|
;

term
: primary
| term MUL primary
| term DIV primary
|
;

primary
: INT
|
;