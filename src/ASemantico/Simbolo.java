
package ASemantico;

public class Simbolo {
    private String nombre;
    private int valor;
    private String tipo;
    private String rol;
    private boolean global;
    private String padre;
    private String ambito;
    private Procedure proced_func;
    private Arreglos arreglos;
    private int profundidad;
    private int direccion;


    //constructor var tipo primitivo
    public Simbolo(String nombre, int valor, String tipo, String rol, boolean global,String padre, String ambito, int profundidad, int direccion){   
        this.nombre = nombre;
        this.valor = valor;
        this.tipo=tipo;
        this.rol=rol;
        this.global=global;
        this.padre=padre;
        this.proced_func=null;
        this.arreglos=null;
        this.ambito=ambito;
        this.profundidad=profundidad;
        this.direccion=direccion;
    }

    //constructor con func/proces
    public Simbolo(String nombre, int valor, String tipo, String rol, boolean global,String padre, Procedure objeto,  String ambito, int profundidad){   
        this.nombre = nombre;
        this.valor = valor;
        this.tipo=tipo;
        this.rol=rol;
        this.global=global;
        this.padre=padre;
        this.proced_func=objeto;
        this.arreglos=null;
        this.ambito=ambito;
        this.profundidad=profundidad;
    }

    //constructor con arreglo
    public Simbolo(String nombre, int valor, String tipo, String rol, boolean global,String padre, Arreglos objeto,  String ambito, int profundidad, int direccion){   
        this.nombre = nombre;
        this.valor = valor;
        this.tipo=tipo;
        this.rol=rol;
        this.global=global;
        this.padre=padre;
        this.arreglos=objeto;
        this.proced_func=null;
        this.ambito=ambito;
        this.profundidad=profundidad;
        this.direccion=direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Procedure getProced_func() {
        return proced_func;
    }

    public void setProced_func(Procedure proced_func) {
        this.proced_func = proced_func;
    }

    public Arreglos getArreglos() {
        return arreglos;
    }

    public void setArreglos(Arreglos arreglos) {
        this.arreglos = arreglos;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    
    
}
