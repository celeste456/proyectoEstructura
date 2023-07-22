/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package overcookedgame;
import java.util.Timer;
import java.util.TimerTask;


public class Cola extends TimerTask {
    private Nodo frente;
    private Nodo ultimo;
    private int largo;
    private int cantidad;
    private Timer timer;
    
    
    public Cola() {
        this.frente = null;
        this.ultimo = null;
        this.largo = 0;
        this.cantidad=0;
        timer = new Timer();
        timer.schedule(this,1000, 5000);
    }
        
    public void encola(Hamburguesa valor){
        Nodo newNode = new Nodo(valor);
        if(frente == null){  // significa que la cola esta vacia
            frente = newNode;
            ultimo = newNode;
        }else{
            ultimo.setAtras(newNode);
            ultimo=newNode;
        }
        largo++;
    }
    
    public Nodo atiende(){
        Nodo aux = frente;
        if(frente!=null){
            frente=frente.getAtras();
            aux.setAtras(null);
            largo--;
        }
        return aux;
    }
    
    //modificado
     public void atiendeModificado(Hamburguesa reference){
        // Consulta si el value exist en la pila.
        //Persona personaAeliminar = null;
        if (encuentra(reference)) {
            // Crea una pila auxiliar para guardar los valuees que se 
            // vayan desapilando de la pila original.
            Nodo cimapPilaAux = null;
            // Recoore la pila hasta llegar al node que tenga el value
            // igual que el de reference.
            while(!(reference.getHamburguesaTipo().equals(frente.getDato().getHamburguesaTipo()))){
                // Crea un node temporal para agregarlos a la pila auxiliar.
                Nodo temp = new Nodo();
                // Ingresa el value al node temporal.
                temp.setDato(frente.getDato());
                // Consulta si la pila auxiliar no a sido inicializada.
                if(cimapPilaAux == null){
                    // Inicializa la pila auxiliar.
                    cimapPilaAux = temp;
                }
                // Caso contrario si la pila auxiliar ya contiene elementos
                // los agrega al start.
                else{
                    temp.setAtras(cimapPilaAux);
                    cimapPilaAux = temp;
                }
                // Elimina el node del tope de la pila hasta llegar al node
                // que se desea eliminar.
                atiende();
            }
            // Elimina el node que coincide con el de reference.
            atiende();
            // Regresa los valuees de la pila auxiliar a la pila original
            // mientras la pila auxiliar tenga elementos.
           
            while(cimapPilaAux != null){
                //PRIMERO CREO UN NODO AUX PARA PODER GUARDAR EL NODO QUE ESTÁ AL FRENTE DE LA PILA ORIGINAL,
                //DESPUÉS DANDO EL NULL AL FRENTE ME ASEGURO QUE CADA ENCOLA META EL VALOR EN LA CIMA Y 
                //POR ÚLTIMO AL NUEVO NODO ENSAMBLADO LE SETTEO EL AUXILIAR OSEA EL PRIMERO DE LA PILA ORIGINAL
                
                // Utiliza el metodo push para regresar los elementos a 
                // la pila original.
                Nodo aux=frente;
                //aux=frente.getDato(); //ORIGINAL EL PRIMERO
                frente = null;
                    encola(cimapPilaAux.getDato());
                frente.setAtras(aux);
                    // Avanza al siguiente node de la pila auxiliar.
                    cimapPilaAux = cimapPilaAux.getAtras();
            }
        
        }else{
            System.out.println("La persona indicada no existe");
        }
        //push(personaAeliminar);
    } 
     
    public boolean encuentra(Hamburguesa referencia){
        if(frente != null){
            if (ultimo.getDato().getHamburguesaTipo().equals(referencia.getHamburguesaTipo())){
                return true;
            }else{
                Nodo aux=frente;
                while(aux!=null){
                    if(aux.getDato().getHamburguesaTipo().equals(referencia.getHamburguesaTipo())){
                        return true;
                    }
                    aux=aux.getAtras();
                }
            }
        }
        return false;
    }
    
    public String imprimir(){
        String s="";
        Nodo aux=frente;
        while(aux!=null){
            s+=aux.getDato().getHamburguesaTipo()+ "\n"+ "Ingredientes:" + aux.getDato().getIngredientes() + "\n";
            aux=aux.getAtras();
            largo++;
        }
        return s;
    }
       
    //metodos que recorra la cola despues de cada encola y me devuelva el tamaño
    public int recorrerCola(){
       int x=0;
       Nodo aux = frente;
       while(aux!=null){
        aux=aux.getAtras();
        //largo++;
        x++;
       }
       return x;
    }
    
    
    //metodo que se ejecuta al crear un objeto TimerTask(hilo en la clase Timer)
    //recibo al metodo recorrer para saber si puedo o no ingresar otro nodo a la cola 
    @Override
    public void run(){ 
        switch (cantidad) {
            case 0:
                int x;
                x=recorrerCola();
                if(x != 3){
                    encola(new Hamburguesa(20, "Hamburguesa de carne", 5, "pan y carne"));
                    System.out.println("------------------");
                    System.out.println(imprimir());
                    cantidad=1;
                }else{
                    //atiende();
                }
                break;
            case 1:
                int y;
                y=recorrerCola();
                if(y != 3){
                    encola(new Hamburguesa(20, "Hamburguesa de queso", 10, "pan, carne y queso"));
                    System.out.println("------------------");
                    System.out.println(imprimir());
                    cantidad=2;
                }else{
                    //atiende();
                }
                break;
            case 2:
                int z;
                z=recorrerCola();
                if(z != 3){
                    encola(new Hamburguesa(20, "Hamburguesa clásica", 15, "pan, carne, queso y lechuga"));
                    System.out.println("------------------");
                    System.out.println(imprimir());
                    cantidad=0;
                }else{
                    //atiende();
                }
                break;
            default:
                break;
        }
    }
    
    
}
