package ALexico;
import GUI.ColorPane;
import java.awt.Color;
import java.io.FileWriter;
import java.io.PrintWriter;

%%
%standalone
%int
%public
%ignorecase
%class ALexico_GUI
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

    asig = "="

    mmas = "++"
    mmenos = "--"
    incrementadores = {mmas}|{mmenos}

    opsum = "+" 
    opres = "-"
    opmult = "*" 
    opdiv = "/" 

    oprel_meq = "<" 
    oprel_maq = ">" 
    oprel_mai = ">=" 
    oprel_mei = "<=" 
    oprel_igu = "==" 
    oprel_dist = "<>"

    comentario = \{.*\}

    id = {letter}({digito}|{letter})+
%{
	ColorPane texto_formato = new ColorPane();
	public static Color texto_reserv = new Color(25,25,112),
				  texto_normal = Color.black,
				  texto_string = new Color(0,100,0),
				  texto_comment = Color.CYAN,
				  texto_const = Color.magenta,
                                  texto_id = new Color(153,50,204),
				  texto_raro = Color.red,
                                  select_highlight = Color.cyan,
                                  fondo = Color.lightGray,
                                  error_highlight = Color.red;
		  
   public static ColorPane getPane(String texto) {
      ColorPane pane = null;
      String argv[] = new String[1];
    String converted = "";
    argv[0] = "temp_lex.txt";

    FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(argv[0]);
            pw = new PrintWriter(fichero);

            pw.print(texto);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }


    if (argv.length == 0) {
      System.out.println("Usage : java ALexico_GUI <inputfile>");
    }
    else {
      for (int i = 0; i < argv.length; i++) {
        ALexico_GUI scanner = null;
        try {
          scanner = new ALexico_GUI( new java.io.FileReader(argv[i]) );
              pane = scanner.yylex();
          return pane;
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
        return null;
  }
		  
		  private int coment_uno = 0,coment_dos = 0;
%}

%%
<YYINITIAL>
{
    {espacio} { String s = yytext(); if(s.compareTo("\r") != 0) this.texto_formato.append(texto_normal,yytext()); /***/ }
    {double} { this.texto_formato.append(texto_const,yytext()); }
    {num} { this.texto_formato.append(texto_const,yytext()); }
    {comentario} { this.texto_formato.append(texto_comment,yytext()); }
    {incrementadores} { this.texto_formato.append(texto_normal,yytext()); }
    {parizq} { this.texto_formato.append(texto_normal,yytext()); }
    {parder} { this.texto_formato.append(texto_normal,yytext()); }

    {doubleNum} { this.texto_formato.append(texto_reserv,yytext()); }
    {intNum} { this.texto_formato.append(texto_reserv,yytext()); }
    {charArray} { this.texto_formato.append(texto_reserv,yytext()); }
    {string} { this.texto_formato.append(texto_string,yytext()); }

    {opsum} { this.texto_formato.append(texto_normal,yytext()); }
    {opres} { this.texto_formato.append(texto_normal,yytext()); }
    {opmult} { this.texto_formato.append(texto_normal,yytext()); }
    {opdiv} { this.texto_formato.append(texto_normal,yytext()); }
    {boolOper} { this.texto_formato.append(texto_reserv,yytext()); }
    {charOper} { this.texto_formato.append(texto_reserv,yytext()); }
    {char} { this.texto_formato.append(texto_string,yytext()); }

    {oprel_maq} { this.texto_formato.append(texto_normal,yytext()); }
    {oprel_meq} { this.texto_formato.append(texto_normal,yytext()); }
    {oprel_mei} { this.texto_formato.append(texto_normal,yytext()); }
    {oprel_mai} { this.texto_formato.append(texto_normal,yytext()); }
    {oprel_igu} { this.texto_formato.append(texto_normal,yytext()); }
    {oprel_dist} { this.texto_formato.append(texto_normal,yytext()); }
    {asig} { this.texto_formato.append(texto_normal,yytext()); }

    {writeLine} { this.texto_formato.append(texto_reserv,yytext()); }
    {write} { this.texto_formato.append(texto_reserv,yytext()); }
    {read} { this.texto_formato.append(texto_reserv,yytext()); }

    {endSelectCase} { this.texto_formato.append(texto_reserv,yytext()); }
    {beginSelectCase} { this.texto_formato.append(texto_reserv,yytext()); }
    {selectCase} { this.texto_formato.append(texto_reserv,yytext()); }

    {endCaseOpt} { this.texto_formato.append(texto_reserv,yytext()); }
    {beginCaseOpt} { this.texto_formato.append(texto_reserv,yytext()); }
    {caseOpt} { this.texto_formato.append(texto_reserv,yytext()); }

    {defaultCaseOpt} { this.texto_formato.append(texto_reserv,yytext()); }
    {endDefaultCaseOpt} { this.texto_formato.append(texto_reserv,yytext()); }

    {elseIf} { this.texto_formato.append(texto_reserv,yytext()); }
    {ifThen} { this.texto_formato.append(texto_reserv,yytext()); }
    {endIf} { this.texto_formato.append(texto_reserv,yytext()); }
    {if} { this.texto_formato.append(texto_reserv,yytext()); }
    {pcoma} { this.texto_formato.append(texto_normal,yytext()); }
    {andOper} { this.texto_formato.append(texto_reserv,yytext()); }
    {return} { this.texto_formato.append(texto_reserv,yytext()); }
    {notOper} { this.texto_formato.append(texto_reserv,yytext()); }
    {orOper} { this.texto_formato.append(texto_reserv,yytext()); }
    {endFor} { this.texto_formato.append(texto_reserv,yytext()); }
    {beginFor} { this.texto_formato.append(texto_reserv,yytext()); }
    {for} { this.texto_formato.append(texto_reserv,yytext()); }
    {endWhile} { this.texto_formato.append(texto_reserv,yytext()); }
    {beginWhile} { this.texto_formato.append(texto_reserv,yytext()); }
    {while} { this.texto_formato.append(texto_reserv,yytext()); }
    {coma} { this.texto_formato.append(texto_normal,yytext()); }
    {beginProcedure} { this.texto_formato.append(texto_reserv,yytext()); }
    {endProcedure} { this.texto_formato.append(texto_reserv,yytext()); }
    {procedure} { this.texto_formato.append(texto_reserv,yytext()); }
    {true} { this.texto_formato.append(texto_reserv,yytext()); }
    {false} { this.texto_formato.append(texto_reserv,yytext()); }

    {endMain} { this.texto_formato.append(texto_reserv,yytext()); }
    {main} { this.texto_formato.append(texto_reserv,yytext()); }

    {id} { this.texto_formato.append(texto_id,yytext()); }

    <<EOF>> { return this.texto_formato; }
    . { this.texto_formato.append(texto_raro,yytext());}
}