package ALexico;
import ASintactico.sym;
import java.io.FileWriter;
import java.io.PrintWriter;
import java_cup.runtime.Symbol;
import GUI.GUI;

%%
%standalone
%int
%ignorecase
%class ALexico
%line
%column
%public

%extends sym
%cup
    espacio = ("\n"|"\t"|" "|"\r")
    digito = [0-9]
    letter = [a-zA-Z]
    double = {digito}+\.{digito}+
    num = [1-9]{digito}* | "0"

    return = "RET"
    andOper = "AND"
    notOper = "NOT"
    orOper = "OR"

    coma = ","
    pcoma = ";"
    comilla = "\'"

    string = \".+\"
    charArray = "CHAR_ARRAY"
    char = {comilla}{letter}{comilla}
    charOper = "CHAR_OPER"

    doubleNum = "DOUBLE_NUM"
    boolOper = "BOOL_OPER"

    main = "MAIN"
    endMain = "END_MAIN"
    endIf = "END_IF"	
    beginFor = "BEGIN_FOR"
    endFor = "END_FOR"
    for = "FOR"
    ifThen = "IF_THEN"
    if = "IF"
    intNum = "INT_NUM"
    elseIf = "ELSE_IF"
    beginProcedure = "BEGIN_PROCEDURE"
    endProcedure = "END_PROCEDURE"
    procedure = "PROCEDURE"

    mmas= "++"
    mmenos="--"
    incrementadores = {mmas}|{mmenos}

    beginWhile = "BEGIN_WHILE"
    endWhile = "END_WHILE"
    while = "WHILE"

    endSelectCase = "END_SELECT_CASE"
    beginSelectCase = "BEGIN_SELECT_CASE"
    selectCase = "SELECT_CASE"
    beginCaseOpt = "BEGIN_CASE_OPT"
    endCaseOpt = "END_CASE_OPT"
    caseOpt = "CASE_OPT"
    defaultCaseOpt = "DEFAULT_CASE_OPT"
    endDefaultCaseOpt = "END_DEFAULT_CASE_OPT"
    true = "TRUE"
    false = "FALSE"

    parizq = "("
    parder = ")"

    writeLine = "WRITE_LN" 
    write =	"WRITE"
    read = "READ"

    opsum = "+" 
    opres = "-"
    opmult = "*" 
    opdiv = "/"

    oprel_meq = "<" 
    oprel_maq = ">" 
    oprel_mai = ">=" 
    oprel_mei = "<=" 
    oprel_igu = "==" 
    asig = "="
    oprel_dist = "<>"

    comentario = \{.*\}

    id = {letter}({digito}|{letter})+
%{
  public static GUI _gui;
%}

%%
<YYINITIAL>
{
    {espacio} {}
    {double} { return new Symbol(sym.DOUBLE,yyline,yycolumn,yytext()); }
    {num} { return new Symbol(sym.NUM,yyline,yycolumn,yytext()); }
    {comentario} {}
    {incrementadores} { return new Symbol(sym.INCREMENTADORES, yyline, yycolumn, yytext()); }
    {parizq} { return new Symbol(sym.PAR_IZQ,yyline,yycolumn,yytext()); }
    {parder} { return new Symbol(sym.PAR_DER,yyline,yycolumn,yytext()); }

    {doubleNum} { return new Symbol(sym.DOUBLE_NUM,yyline,yycolumn,yytext()); }
    {intNum} { return new Symbol(sym.INT_NUM,yyline,yycolumn,yytext()); }
    {charArray} { return new Symbol(sym.CHAR_ARRAY,yyline,yycolumn,yytext()); }
    {string} { return new Symbol(sym.STRING,yyline,yycolumn,yytext()); }

    {opsum} { return new Symbol(sym.OPSUM,yyline,yycolumn,yytext()); }	
    {opres} { return new Symbol(sym.OPRES,yyline,yycolumn,yytext()); }	
    {opmult} { return new Symbol(sym.OPMULT,yyline,yycolumn,yytext());}	
    {opdiv} { return new Symbol(sym.OPDIV,yyline,yycolumn,yytext()); }			
    {boolOper} { return new Symbol(sym.BOOL_OPER,yyline,yycolumn,yytext()); }
    {charOper} { return new Symbol(sym.CHAR_OPER,yyline,yycolumn,yytext()); }
    {char} { return new Symbol(sym.CHAR,yyline,yycolumn,yytext()); }

    {oprel_maq} { return new Symbol(sym.OPREL_MAQ,yyline,yycolumn,yytext()); }		
    {oprel_meq} { return new Symbol(sym.OPREL_MEQ,yyline,yycolumn,yytext()); }	
    {oprel_mei} { return new Symbol(sym.OPREL_MEI,yyline,yycolumn,yytext()); }	
    {oprel_mai} { return new Symbol(sym.OPREL_MAI,yyline,yycolumn,yytext()); }	
    {oprel_igu} { return new Symbol(sym.IGUAL,yyline,yycolumn,yytext()); }	
    {oprel_dist} { return new Symbol(sym.OPREL_DIST,yyline,yycolumn,yytext()); }	
    {asig} { return new Symbol(sym.ASIG,yyline,yycolumn,yytext()); }

    {writeLine} { return new Symbol(sym.WRITE_LN,yyline,yycolumn,yytext());}
    {write} { return new Symbol(sym.WRITE,yyline,yycolumn,yytext()); }
    {read} { return new Symbol(sym.READ,yyline,yycolumn,yytext()); }

    {endSelectCase} { return new Symbol(sym.END_SELECT_CASE,yyline,yycolumn,yytext()); }
    {beginSelectCase} { return new Symbol(sym.BEGIN_SELECT_CASE,yyline,yycolumn,yytext()); }
    {selectCase} { return new Symbol(sym.SELECT_CASE,yyline,yycolumn,yytext()); }

    {endCaseOpt} { return new Symbol(sym.END_CASE_OPT,yyline,yycolumn,yytext()); }
    {beginCaseOpt} { return new Symbol(sym.BEGIN_CASE_OPT,yyline,yycolumn,yytext()); }
    {caseOpt} { return new Symbol(sym.CASE_OPT,yyline,yycolumn,yytext()); }

    {defaultCaseOpt} { return new Symbol(sym.DEFAULT_CASE,yyline,yycolumn,yytext()); }
    {endDefaultCaseOpt} { return new Symbol(sym.END_DEFAULT_CASE,yyline,yycolumn,yytext()); }

    {elseIf} { return new Symbol(sym.ELSE_IF,yyline,yycolumn,yytext()); }	
    {ifThen} { return new Symbol(sym.IF_THEN,yyline,yycolumn,yytext()); }
    {endIf} { return new Symbol(sym.END_IF,yyline,yycolumn,yytext()); }
    {if} { return new Symbol(sym.IF,yyline,yycolumn,yytext()); }
    {pcoma} { return new Symbol(sym.PCOMA,yyline,yycolumn,yytext()); }
    {andOper} { return new Symbol(sym.AND,yyline,yycolumn,yytext()); }
    {return} { return new Symbol(sym.RETURN,yyline,yycolumn,yytext()); }
    {notOper} { return new Symbol(sym.NOT,yyline,yycolumn,yytext()); }
    {orOper} { return new Symbol(sym.OR,yyline,yycolumn,yytext()); }
    {endFor} { return new Symbol(sym.END_FOR,yyline,yycolumn,yytext()); }
    {beginFor} { return new Symbol(sym.BEGIN_FOR,yyline,yycolumn,yytext()); }
    {for} { return new Symbol(sym.FOR,yyline,yycolumn,yytext()); }
    {endWhile} { return new Symbol(sym.END_WHILE,yyline,yycolumn,yytext()); }
    {beginWhile} { return new Symbol(sym.BEGIN_WHILE,yyline,yycolumn,yytext()); }
    {while} { return new Symbol(sym.WHILE,yyline,yycolumn,yytext()); }
    {coma} { return new Symbol(sym.COMA,yyline,yycolumn,yytext()); }
    {beginProcedure} { return new Symbol(sym.BEGIN_PROCEDURE,yyline,yycolumn,yytext()); }
    {endProcedure} { return new Symbol(sym.END_PROCEDURE,yyline,yycolumn,yytext()); }
    {procedure} { return new Symbol(sym.PROCEDURE,yyline,yycolumn,yytext()); }
    {true} {return new Symbol(sym.TRUE,yyline,yycolumn,yytext());}
    {false} {return new Symbol(sym.FALSE,yyline,yycolumn,yytext());}

    {endMain} {return new Symbol(sym.END_MAIN,yyline,yycolumn,yytext());}
    {main} {return new Symbol(sym.MAIN,yyline,yycolumn,yytext());}

    {id} { return new Symbol(sym.ID,yyline,yycolumn,yytext()); }

    <<EOF>> { return new Symbol(sym.EOF,yyline,yycolumn,yytext()); }
    . {ALexico._gui.WriteLn("ERROR Lexico en la linea " + (yyline + 1) + ", columna " + (yycolumn + 1) + "; No se reconoce el simbolo: " + yytext());
	    ALexico._gui.selectorLinea.HighLightLine(yyline);}
}