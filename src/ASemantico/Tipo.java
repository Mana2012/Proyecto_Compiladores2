/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ASemantico;

public class Tipo 
{
    private int tipo = Tipo.NINGUNO;
    
    public int getTamMemoria()
    {
        switch(this.tipo)
        {
            case Tipo.INTEGER: return 4;
            case Tipo.BOOLEAN: return 4;
            case Tipo.CHARACTER: return 4;
            default: return 0;
        }
    }
    
    public Tipo( int tipo )
    {
       this.tipo = tipo;
    }
    
    public int getTipo()
    {
        return this.tipo;
    }
    
    @Override
    public String toString()
    {
        switch(tipo)
        {
            case Tipo.NINGUNO: return "Ninguno";
            case Tipo.INTEGER: return "Integer";
            case Tipo.CHARACTER: return "Character";
            case Tipo.STRING: return "String";
            case Tipo.BOOLEAN: return "Boolean";
            case Tipo.ARRAY: return "Array";
            case Tipo.FUNCTION: return "Function";
            case Tipo.PROCEDURE: return "Procedure"; 
            case Tipo.STRINGC: return "String + Caracter";
            case Tipo.STRINGD: return "String + Int"; 
            default: return "ERROR";
        }
    }
    
    @Override
    public boolean equals(Object otro)
    {
        Tipo OtroTipo = null;
        try{
            OtroTipo = (Tipo)otro;
        }
        catch(Exception ex)
        {
            return false;
        }
        return OtroTipo.tipo == this.tipo;
        
    }
    
    public final static int   NINGUNO = -1,
                              INTEGER = 0,
                              CHARACTER = 1,
                              STRING = 2,
                              BOOLEAN = 3,
                              ARRAY = 4,
                              FUNCTION = 5,
                              PROCEDURE = 6,
                              STRINGC = 7,
                              STRINGD = 8;
}
