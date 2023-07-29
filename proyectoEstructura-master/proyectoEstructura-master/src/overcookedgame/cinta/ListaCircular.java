package overcookedgame.cinta;

import javax.swing.JOptionPane;

public class ListaCircular {
    private NodoLista cabeza;
    private NodoLista ultimo;
    
    public NodoLista getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoLista cabeza) {
        this.cabeza = cabeza;
    }
    
    public void inserta(Ingrediente p){
        if(cabeza==null){
            cabeza = new NodoLista(p);
            ultimo=cabeza;
        }else if(p.getId()<cabeza.getDato().getId()){
            NodoLista aux = new NodoLista(p);
            aux.setNext(cabeza);
            cabeza=aux;
        }else if(ultimo.getDato().getId() <= p.getId()){
            ultimo.setNext(new NodoLista(p));
            ultimo = ultimo.getNext();
        }else{
           NodoLista aux = cabeza;
           while (aux.getNext().getDato().getId()
                   <p.getId()){
               aux=aux.getNext();
           }
           NodoLista temp = new NodoLista(p);
           temp.setNext(aux.getNext());
           aux.setNext(temp);
        }
        //enlace del ultimo y primero
        ultimo.setNext(cabeza);
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
    public void elimina (int id) {
        //Si una persona tiene el id, lo elimina
        if (cabeza != null) { //Si hay algo en la lista buscaré
            if (cabeza.getDato().getId() == id) 
            {
                cabeza = cabeza.getNext();
            } 
            else {
                NodoLista aux = cabeza; //utilizo aux como indice
                //Mientras no se acabe la lista y el elemento
                //de la lista sea menor que el buscado
                while (aux.getNext () .getDato () .getId() < id) {
                    aux = aux.getNext () ;
                }
                //avanzo en la lista
            
                // si es el de adelante lo borro
                if (aux.getNext () .getDato () .getId () == id) {
                    aux. setNext (aux.getNext () .getNext ()); //cambio las referencias
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
    
    @Override
    public String toString(){
        NodoLista aux = cabeza;
        String s="Lista: ";
        if(aux != null){
            s += aux + ", ";
            aux= aux.getNext();
            while(aux!=cabeza){
                s+=aux+", ";
                aux=aux.getNext();
            }
        }else{
            s += "vacía";
        }
        return s;
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
                inserta(new Ingrediente("pan", 01));
                inserta(new Ingrediente("carne", 02));
                break;
            case 2:
                inserta(new Ingrediente("pan", 01));
                inserta(new Ingrediente("carne", 02));
                inserta(new Ingrediente("queso", 03));
                break;
            case 1:
                inserta(new Ingrediente("pan", 01));
                inserta(new Ingrediente("carne", 02));
                inserta(new Ingrediente("queso", 03));
                inserta(new Ingrediente("lechuga", 04));
                break;
            case 0:
                inserta(new Ingrediente("pan", 01)); 
                inserta(new Ingrediente("carne", 02));
                inserta(new Ingrediente("queso", 03));
                inserta(new Ingrediente("lechuga", 04));
                inserta(new Ingrediente("pan", 05));
                break;
            default:
                break;
        }
    }
    
    //ListaCircular de ingredientes seleccionados H.C
     public boolean validarDos(int i){
         //switch ingreso INGREDIENTES SELECCIONADOS
        switch (i){
            case 0:
                inserta(new Ingrediente("PAN",01));
                JOptionPane.showMessageDialog(null, "INGREDIENTE CORRECTO!");
                break;
            case 1:
                inserta(new Ingrediente("CARNE",02));
                JOptionPane.showMessageDialog(null, "INGREDIENTE CORRECTO!");
                break;
            case 2:
                inserta(new Ingrediente("QUESO",03));
                JOptionPane.showMessageDialog(null, "INGREDIENTE INCORRECTO!");
                break;
            case 3:
                inserta(new Ingrediente("LECHUGA",03));
                JOptionPane.showMessageDialog(null, "INGREDIENTE INCORRECTO!");
                break;
            default:
                break;
        }
        //valido si la LISTA INGREDIENTES SELECCIONADOS contiene los ingredientes necesarios 
        boolean x= false;
        if (cabeza != null) { //Si hay algo en la lista buscaré   
            NodoLista aux = cabeza; //utilizo aux como indice
            //Valido si se encuentran los ingredientes requeridos
            if (aux.getDato().getId() == 01 && aux.getNext().getDato().getId () == 02) {
                x= true;
                cabeza=null;
            }
        }
        return x;
    }
    
     
   //ListaCircular de ingredientes seleccionados H.Q
     public boolean validarTres(int i){
         //switch ingreso ingredientes selccionados
         switch (i){
            case 0:
                inserta(new Ingrediente("PAN",01));
                JOptionPane.showMessageDialog(null, "INGREDIENTE CORRECTO!");
                break;
            case 1:
                inserta(new Ingrediente("CARNE",02));
                JOptionPane.showMessageDialog(null, "INGREDIENTE CORRECTO!");
                break;
            case 2:
                inserta(new Ingrediente("QUESO",03));
                JOptionPane.showMessageDialog(null, "INGREDIENTE CORRECTO!");
                break;
            case 3:
                inserta(new Ingrediente("LECHUGA",03));
                JOptionPane.showMessageDialog(null, "INGREDIENTE INCORRECTO!");
                break;
            default:
                break;
        }
        //valido si la LISTA INGREDIENTES SELECCIONADOS contiene los ingredientes necesarios 
        boolean x= false;
        if (cabeza != null) { //Si hay algo en la lista buscaré   
            NodoLista aux = cabeza; //utilizo aux como indice
            //Valido si se encuentran los ingredientes requeridos
            if (aux.getDato().getId() == 01 && aux.getNext().getDato().getId () == 02 && aux.getNext().getNext().getDato().getId () == 03) {
                x= true;
                cabeza=null;
            }
        }
        return x;
    }
    
    
    
}
