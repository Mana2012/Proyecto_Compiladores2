
package ASemantico;

public class Arreglos {
    private String nombre;
    private String Stringtipo;
    private boolean unidimensional;
    private Integer indiceInicial;
    private Integer indiceFinal;


    public Arreglos(String nombre, boolean unidimensional,Integer indiceInicial,Integer indiceFinal, String Stringtipo){   
        this.nombre = nombre;
        this.unidimensional = unidimensional;
        this.indiceInicial = indiceInicial;
        this.indiceFinal = indiceFinal;
        this.Stringtipo = Stringtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStringtipo() {
        return Stringtipo;
    }

    public void setStringtipo(String Stringtipo) {
        this.Stringtipo = Stringtipo;
    }

    public boolean isUnidimensional() {
        return unidimensional;
    }

    public void setUnidimensional(boolean unidimensional) {
        this.unidimensional = unidimensional;
    }

    public Integer getIndiceInicial() {
        return indiceInicial;
    }

    public void setIndiceInicial(Integer indiceInicial) {
        this.indiceInicial = indiceInicial;
    }

    public Integer getIndiceFinal() {
        return indiceFinal;
    }

    public void setIndiceFinal(Integer indiceFinal) {
        this.indiceFinal = indiceFinal;
    }
    
}
