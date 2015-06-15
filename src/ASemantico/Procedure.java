
package ASemantico;

public class Procedure {
    private String nombre;
    private String tipoRetorno;
    private String param;
    private boolean retorno;
    

    public Procedure(String nombre, String tipoRetorno, String param, boolean retorno){   
        this.nombre = nombre;
        this.tipoRetorno = tipoRetorno;
        this.param = param;
        this.retorno = retorno; 
    }

    public Procedure(String nombre, String tipoRetorno, String param){   
        this.nombre = nombre;
        this.tipoRetorno = tipoRetorno;
        this.param = param;
    }
}
