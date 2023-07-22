/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package overcookedgame;

/**
 *
 * @author usuario
 */
public class Nodo {
    private Hamburguesa dato;
    private Nodo atras;

    public Nodo() {
    }
    
    public Nodo(Hamburguesa dato) {
        this.dato = dato;
        this.atras = null;
    }

    public Hamburguesa getDato() {
        return dato;
    }

    public void setDato(Hamburguesa dato) {
        this.dato = dato;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }

    @Override
    public String toString() {
        return  ""+ dato ;
    }
    
    
}
