package overcookedgame.ordenes;

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
