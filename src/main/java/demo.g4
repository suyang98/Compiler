grammar demo;

prog:block+
;

block:funcdef  #block_funcdef
     |clasdef  #block_clasdef
     |stat     #block_state
;


funcdef:functype funcid '(' paralist? ')' stat;


clasdef:CLASS clasid '{' classbody '}';

classbody:clastat*;

clastat:funcdef         #class_funcdef
       |stat            #class_stat
       |claconstr       #class_clac
;

claconstr:clasid '(' ')' stat;



paralist:para (',' para)*;

para:vartype varid('=' expr)?       #para_var
    |arrtype varid('=' expr)?       #para_arr
;




stat:para';'       #stat_para
    |expr';'       #stat_expr
    |sif            #stat_if
    |swhile         #stat_while
    |sfor           #stat_for
    |jumpstat      #stat_jump
    |'{'stat*'}'   #stat_many
    |';'           #stat_null
;




exprlist:expr(','expr)*;

methodcall:funcid'('exprlist?')';

creator:vartype indexlist*;

indexlist:'['expr?']';

expr:primary                                           #expr_prim
    |methodcall                                        #expr_meth
    |idname=expr '['index=expr']'                      #expr_arra
    |clname=expr'.'varname=expr                        #expr_clas
    |NEW creator                                       #expr_crea
    |expr postfix=('++'|'--')                          #expr_posd
    |prefix=('++'|'--') expr                           #expr_fixd
    |prefix=('!'|'~'|'-') expr                         #expr_fixn
    |left=expr bop=('*'|'/'|'%') right=expr            #expr_divd
    |left=expr bop=('+'|'-') right=expr                #expr_plus
    |left=expr bop=('<<'|'>>') right=expr              #expr_shif
    |left=expr bop=('<'|'<='|'>'|'>=') right=expr      #expr_than
    |left=expr bop=('=='|'!=') right=expr              #expr_equi
    |left=expr bop='&' right=expr                      #expr_log
    |left=expr bop='^' right=expr                      #expr_log
    |left=expr bop='|' right=expr                      #expr_log
    |left=expr bop='&&' right=expr                     #expr_log
    |left=expr bop='||' right=expr                     #expr_log
    |left=expr bop='=' right=expr                      #expr_assi
;

primary:NULL                                #primary_null
       |Int                                 #primary_int
       |String                              #primary_str
       |Bool                               #primary_bool
       |'('expr')'                          #primary_parens
       |varid                               #primary_var
//       |exprbuilt                           #primary_built
;


sif:IF '('expr')' then_state=stat (ELSE else_state=stat)?;

swhile: WHILE '('expr')'stat;

sfor:FOR'(' expr1 = expr?';' expr2 = expr?';' expr3 = expr?')'stat;



jumpstat:RETURN expr?';'                     #jump_return
        |BREAK';'                           #jump_break
        |CONTINUE';'                        #jump_continue
;



type:BOOL
    |INT
    |STR
    |VOID
    |clasid;

functype:type                           //#func_type
        |type('['']')*                  //#func_arra
;


vartype: BOOL|INT|STR|clasid;
arrtype:vartype ('['']')*;


varid:ID;
funcid:ID;
clasid:ID;


BOOL:'bool';
INT:'int';
STR:'string';
VOID:'void';
NULL:'null';
NEW:'new';

CLASS:'class';
IF:'if';
ELSE:'else';
WHILE:'while';
FOR:'for';

RETURN:'return';
BREAK:'break';
CONTINUE:'continue';


Bool:'true'|'false';
ID:('a'..'z'|'A'..'Z')('0'..'9'|'_'|'a'..'z'|'A'..'Z')*;
Int:('0'..'9')+;
String : '"' (ESC | .)*? '"' ;
fragment ESC : '\\' [btnr"\\];


//NEWLINE:'\r'?'\n';
COMMENT:'//'~('\r'|'\n')*{skip();};
BLOCK_COMMENT : '/*' .*? '*/' -> skip;
WS:(' '|'\t'|'\n'|'\r')+{skip();};