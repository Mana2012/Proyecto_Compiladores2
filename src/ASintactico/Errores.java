/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ASintactico;

public class Errores {
    
    private String _mensaje;
    private int _linea;
    private int _columna;
    
    public Errores(String message, int _linea, int _columna){
        _mensaje = message;
        this._linea = _linea;
        this._columna = _columna;
    }
    
    public Errores()
    {}
    
    public String getMensaje(){
        return _mensaje;
    }
    
    public void setMensaje(String msg){
        _mensaje = msg;
    }
    
    public int getLinea(){
        return _linea;
    }
    
    public void setLinea(int l){
        this._linea = l;
    }
    
    public int getColumna(){
        return _columna;
    }
    
    public void setColumna(int c){
        this._columna = c;
    }
    @Override
    public String toString(){
        ALexico.ALexico._gui.selectorLinea.HighLightLine(_linea-1);
        return this._mensaje+ "\tLinea:"+this._linea+"\tColumna:"+this._columna;
    }
}
