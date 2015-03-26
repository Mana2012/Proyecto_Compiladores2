/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ALexico;

public class Token {
    public String Token_Text;
    public int Column = -1,Line =-1,Token_Id = -1;



    public Token(int Token_Id, int Column,int Line, String Token_Text){
        this.Token_Id = Token_Id;
        this.Token_Text = Token_Text;
        this.Column = Column;
        this.Line = Line;
    }

    @Override
    public String toString(){
       return "<" + Token.getNameToken(this.Token_Id) +
               "," + this.Token_Text +
               "," + this.Column +
               "," + this.Line +
               ">";
    }

    public static String getNameToken(int token){
        switch(token)
        {
            case Token.AND:
                return "And";
            case Token.ARRAY:
                return "Array";
            case Token.ASIG:
                return "Asignacion";
            case Token.BOOL_OPER:
                return "Boolean";
            case Token.CHAR_OPER:
                return "Operador Character";
            case Token.CHAR:
                return "Character";
            case Token.COMA:
                return "Coma";
            case Token.COMILLA:
                return "Comilla";
            case Token.DIGITO:
                return "Digito";
            case Token.OPREL_DIST:
                return "Distinto de";
            case Token.OPDIV:
                return "Division";
            case Token.OPDIV_T:
                return "Division Div";
            case Token.DO:
                return "Do";
            case Token.ELSE_IF:
                return "Else";
            case Token.END_IF:
                return "End if";
            case Token.ESPACIO:
                return "Espacio";
            case Token.FOR:
                return "For";
            case Token.END_FOR:
                return "Fin For";
            case Token.BEGIN_FOR:
                return "Inicio For";
            case Token.BEGIN_PROCEDURE:
                return "Inicio procedimiento";
            case Token.THEN_PROCEDURE:
                return "Procedimiento";
            case Token.END_PROCEDURE:
                return "Fin Procedimiento";
            case Token.IF:
                return "If";
            case Token.IGUAL:
                return "Igual";
            case Token.INT_NUM:
                return "Integer";
            case Token.DOUBLE_NUM:
                return "Declaracion Double";
            case Token.DOUBLE:
                return "Double";
            case Token.LETTER:
                return "Letra";
            case Token.OPREL_MAI:
                return "Mayor Igual que";
            case Token.OPREL_MEI:
                return "Menor igual que";
            case Token.OPREL_MAQ:
                return "Mayor que";
            case Token.OPREL_MEQ:
                return "Menor que";
            case Token.OPMOD:
                return "Modulo";
            case Token.OPMULT:
                return "Multiplicacion";
            case Token.NOT:
                return "Not";
            case Token.NUM:
                return "Numero";
            case Token.OR:
                return "Or";
            case Token.PAR_DER:
                return "Parentesis Derecho";
            case Token.PAR_IZQ:
                return "Parentesisi Izquierdo";
            case Token.MAIN:
                return "Main";
            case Token.BEGIN_MAIN:
                return "Inicio Main";
            case Token.END_MAIN:
                return "Fin Main";
            case Token.PUNTO:
                return "Punto";
            case Token.PCOMA:
                return "Punto y Coma";
            case Token.READ:
                return "Read";
            case Token.WRITE_LN:
                return "Write Line";
            case Token.OPRES:
                return "Resta";
            case Token.CHAR_ARRAY:
                return "CHAR ARRAY";
            case Token.STRING:
                return "String";
            case Token.OPSUM:
                return "Suma";
            case Token.IF_THEN:
                return "Then";
            case Token.WHILE:
                return "While";
            case Token.END_WHILE:
                return "Fin While";
            case Token.WRITE:
                return "Write";
            case Token.ID:
                return "Identificador";
            case Token.SELECT_CASE:
                return "Caso select";
            case Token.END_SELECT_CASE:
                return "Fin caso select";
            case Token.BEGIN_SELECT_CASE:
                return "Inicio caso select";
            case Token.BEGIN_CASE_OPT:
                return "Inicio opcion caso";
            case Token.CASE_OPT:
                return "Caso opcions";
            case Token.END_CASE_OPT:
                return "Fin Caso opcions";
            case Token.TRUE:
                return "True";
            case Token.FALSE:
                return "False";
            case Token.EOF:
                return "Fin de archivo";
            case Token.COMMENT:
                return "Comentario";
            case Token.BEGIN_WHILE:
                return "Comentario";
            case Token.PROCEDURE:
                return "Procedimiento";
            case Token.RETURN:
                return "Retorno";
            case Token.DEFAULT_CASE:
                return "Caso por defecto caso select";
            case Token.END_DEFAULT_CASE:
                return "Fin caso por defecto caso select";
            default:
                return "Token no reconocible";
        }
    }

    public static final int ESPACIO = 0,DIGITO = 1,LETTER = 2,
            NUM = 3, AND = 4, NOT = 5, OR = 6, BOOL_OPER = 7,
            CHAR_OPER = 8, CHAR_ARRAY = 9, ARRAY = 10, MAIN = 11,
            BEGIN_MAIN = 12, END_MAIN = 13, DO = 14, END_IF = 15,FOR = 16,
            END_FOR = 17,BEGIN_FOR = 18, IF = 19, IF_THEN = 20,
            INT_NUM = 21, ELSE_IF = 22, BEGIN_PROCEDURE = 23,
            THEN_PROCEDURE = 24, END_PROCEDURE = 25, DOUBLE_NUM = 26,
            WHILE = 27, END_WHILE = 28, SELECT_CASE = 29,
            END_SELECT_CASE = 30,BEGIN_SELECT_CASE = 31,
            BEGIN_CASE_OPT = 32,CASE_OPT = 33,TRUE = 34,FALSE = 35,
            COMA = 36, PCOMA = 37, PUNTO = 38,
            COMILLA = 39,PAR_IZQ = 40,PAR_DER = 41,BRA_IZQ = 42,
            BRA_DER = 43,READ = 44,WRITE = 45,WRITE_LN = 46,
            ASIG = 47, OPSUM = 48, OPRES = 49, OPMULT = 50,OPDIV = 51,
            OPDIV_T = 52,OPMOD = 53,OPREL_MAI = 54,OPREL_MEI = 55, RETURN = 72,
            OPREL_MAQ = 56, OPREL_MEQ = 57,IGUAL = 58, OPREL_DIST = 59, ID = 60, 
            END_CASE_OPT = 61, EOF = 62, CADENAC = 63, CADENAD = 64, PROCEDURE = 71,
            CADENA = 65, COMMENT = 66, BEGIN_WHILE = 67, CHAR = 68, STRING = 69, DOUBLE = 70,
            DEFAULT_CASE = 73, END_DEFAULT_CASE = 74;
}
