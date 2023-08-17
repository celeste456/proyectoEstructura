import javax.swing.ImageIcon;

public class ListaCircular {
    
    private NodoLista cabeza;
    private NodoLista ultimo;
    private boolean x=false;
    private int num=0;
    
    public NodoLista getCabeza() {
        return cabeza;
    }
    
    public void inserta(Ingrediente p){
        if(cabeza==null){
            cabeza = new NodoLista(p);
            ultimo=cabeza;
        }else{
            ultimo.setNext(new NodoLista(p));
            ultimo = ultimo.getNext();
        }
        //enlace del ultimo y primero
        ultimo.setNext(cabeza);
        //inserto dato de posición a cada nodo
        num=num+1;
        ultimo.getDato().setPosicion(num);
    }
    
    //metodo elimina por posición
    public void elimina (int posicion) {
        if (cabeza != null) { 
            if (cabeza.getDato().getPosicion() == posicion) 
            {
                cabeza = cabeza.getNext();
            } 
            else {
                NodoLista aux = cabeza; 
                while (aux.getNext () .getDato ().getPosicion() < posicion) {
                    aux = aux.getNext () ;
                }
                if (aux.getNext () .getDato ().getPosicion() == posicion) {
                    if(ultimo == aux.getNext()){
                        ultimo=aux;
                        aux.setNext(cabeza);
                    }else{
                    aux. setNext (aux.getNext () .getNext ());
                    }
                }
            }
        }
    }
    
    //metodo para saber cuantas posiciones hay
    public int recorrer(){
        int i=0;
        NodoLista aux = cabeza;
        if(cabeza!=null){
            i++;
        }
        while(aux != ultimo){
            aux=aux.getNext();
            i++;
        }
        return i;
    }
    
    //metodo insertar nuevos nodos
    public void insertaModificado(){ 
        int j= recorrer();
        switch (j) {
            case 3:
                if(x != true){
                    inserta(new Ingrediente("carne", 1,new ImageIcon(getClass().getResource("img/carne.png"))));
                    inserta(new Ingrediente("pan", 2, new ImageIcon(getClass().getResource("img/pan.png"))));
                    x=true;
                }else if(x != false){
                    inserta(new Ingrediente("queso", 3,new ImageIcon(getClass().getResource("img/queso.png"))));
                    inserta(new Ingrediente("lechuga", 4, new ImageIcon(getClass().getResource("img/lechuga.png"))));
                    x=false;
                }
                break;
            case 0:
                inserta(new Ingrediente("carne", 1, new ImageIcon(getClass().getResource("img/carne.png")))); 
                inserta(new Ingrediente("pan", 2, new ImageIcon(getClass().getResource("img/pan.png"))));
                inserta(new Ingrediente("queso", 3, new ImageIcon(getClass().getResource("img/queso.png"))));
                inserta(new Ingrediente("lechuga", 4, new ImageIcon(getClass().getResource("img/lechuga.png"))));
                inserta(new Ingrediente("pan", 2, new ImageIcon(getClass().getResource("img/pan.png"))));
                break;
            default:
                break;
        }
    }
    
}
