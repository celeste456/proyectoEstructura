package overcookedgame.ordenes;

import java.util.Random;
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
        timer = new Timer();
        timer.schedule(this,1000, 5000);
    }
    
    public int tamanio(){
        return largo;
    }
        
    public void encola(Hamburguesa valor){
        Nodo newNode = new Nodo(valor);
        if(frente == null){  
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
 
    public String imprimir() {
    String s = "";
    Nodo aux = frente;
    while (aux != null) {
        s += aux.getDato().toString() + "\n" +"------------------"+ "\n" ;
        aux = aux.getAtras();
    }
    return s;
    }
    
    //metodo que se ejecuta al crear un objeto TimerTask(hilo en la clase Timer)
    //recibo al metodo recorrer para saber si puedo o no ingresar otro nodo a la cola 
    @Override
    public void run(){ 
        Random rand = new Random();
        int tipoHamburguesa = rand.nextInt(3);
         
        if (tamanio() < 3) {
            switch (tipoHamburguesa) {
                case 0:
                    System.out.println("\n" +"------------------");
                    encola(new Hamburguesa(20, "Hamburguesa de carne", 5, "pan y carne"));
                    break;
                case 1:
                    System.out.println("\n" +"------------------");
                    encola(new Hamburguesa(20, "Hamburguesa de queso", 10, "pan, carne y queso"));
                    break;
                case 2:
                    System.out.println("\n" +"------------------");
                    encola(new Hamburguesa(20, "Hamburguesa clásica", 15, "pan, carne, queso y lechuga"));
                    break;
                default:
                    break;
            }
            System.out.println(imprimir());
            System.out.println(tamanio());
        } else {
            //atiende();
        }
    }
    
}
