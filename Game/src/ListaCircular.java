

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
    
    public boolean existe (int id){
        boolean esta = false;
        //Busca en lista, y retorna true si una persona tiene el id
        //en la lista
        if (cabeza != null){
            //Si hay algo en la lista buscaré
            NodoLista aux = cabeza;
            //utilizo aux como indice

            //Mientras no se acabe la lista y el elemento
            //de la lista sea menor que el buscado
            while (aux.getDato().getId() < id){
                aux = aux.getNext () ;//avanzo en la lista
            }

            //verdadero si lo encontró
            esta = (aux.getDato().getId()== id);
        }

        return esta;
    }
    
    public void modifica (Ingrediente p) {
        //busca a si existe alguien con el id, y le actualiza el nombre
        if (cabeza != null) {
            //Si hay algo en la lista buscaré
            NodoLista aux = cabeza; //utilizo aux como indice
            //Mientras no se acabe la lista y el elemento
            //de la lista sea menor que el buscado
            while (aux.getDato().getId() < p.getId()) {
                aux = aux. getNext (); //avanzo en la lista
            }
            // Si lo encuentra hago el cambio
            if (aux. getDato () .getId () == p.getId ()){
                //Solo básta cambiar nombre
                aux.getDato().setIngrediente(p.getIngrediente()) ;
            }
        }
    } 
    
    //metodo elimina por posición
    public void elimina (int posicion) {
        //Si una persona tiene el id, lo elimina
        if (cabeza != null) { //Si hay algo en la lista buscaré
            if (cabeza.getDato().getPosicion() == posicion) 
            {
                cabeza = cabeza.getNext();
            } 
            else {
                NodoLista aux = cabeza; //utilizo aux como indice
                //Mientras no se acabe la lista y el elemento
                //de la lista sea menor que el buscado
                while (aux.getNext () .getDato ().getPosicion() < posicion) {
                    aux = aux.getNext () ;
                }
                //avanzo en la lista
            
                // si es el de adelante lo borro
                if (aux.getNext () .getDato ().getPosicion() == posicion) {
                    if(ultimo == aux.getNext()){
                        ultimo=aux;
                        aux.setNext(cabeza);
                    }else{
                    aux. setNext (aux.getNext () .getNext ()); //cambio las referencias
                    }
                }
            }
        }
    }
    
    public Ingrediente extrae (int id) {
        Ingrediente p = null;
        //si una persona tiene el id, lo extrae (eliminando y retornando)
        if (cabeza != null) { //Si hay algo en la lista buscaré
            if (cabeza.getDato () .getId () == id) {
                cabeza = cabeza. getNext () ;
            } else {
                NodoLista aux = cabeza; //utilizo aux como indice
                //Mientras no se acabe la lista y el elemento
                //de la lista sea menor que el buscado
                while (aux.getNext() .getDato(). getId()
                < id){
                    aux = aux. getNext () ;
                    //avanzo en la lista
                }
                // Si es el de adelante... quardo la persona y lo borro
                if ( aux. getNext () .getDato () .getId() == id) {
                    p = aux. getNext () .getDato () ;
                    aux. setNext (aux.getNext () .getNext () ) ;//cambio las referencias
                }
            }
        }
        return p;
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
                    inserta(new Ingrediente("carne", 1,new ImageIcon(getClass().getResource("carne.png"))));
                    inserta(new Ingrediente("pan", 2, new ImageIcon(getClass().getResource("pan.png"))));
                    x=true;
                }else if(x != false){
                    inserta(new Ingrediente("queso", 3,new ImageIcon(getClass().getResource("queso.png"))));
                    inserta(new Ingrediente("lechuga", 4, new ImageIcon(getClass().getResource("lechuga.png"))));
                    x=false;
                }
                break;
            case 0:
                inserta(new Ingrediente("carne", 1, new ImageIcon(getClass().getResource("carne.png")))); 
                inserta(new Ingrediente("pan", 2, new ImageIcon(getClass().getResource("pan.png"))));
                inserta(new Ingrediente("queso", 3, new ImageIcon(getClass().getResource("queso.png"))));
                inserta(new Ingrediente("lechuga", 4, new ImageIcon(getClass().getResource("lechuga.png"))));
                inserta(new Ingrediente("pan", 2, new ImageIcon(getClass().getResource("pan.png"))));
                break;
            default:
                break;
        }
    }
    
    
    
}
