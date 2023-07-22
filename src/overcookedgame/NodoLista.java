
package overcookedgame;


public class NodoLista {
    private Ingrediente dato;
    private NodoLista next;

    //constructor
    public NodoLista(Ingrediente dato) {
        this.dato = dato;
    }
    
    //setter and getter
    public Ingrediente getDato() {
        return dato;
    }

    public void setDato(Ingrediente dato) {
        this.dato = dato;
    }

    public NodoLista getNext() {
        return next;
    }

    public void setNext(NodoLista next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodoFila{" + "dato=" + dato + ", next=" + next + '}';
    }
    
    


    
}
