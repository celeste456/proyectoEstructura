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
        timer.schedule(this,20000, 20000);
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
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
     
    public String imprimir(){
        String s="";
        Nodo aux=frente;
        while(aux!=null){
            s+=aux.getDato().getHamburguesaTipo()+ "\n"+ "Ingredientes:" + aux.getDato().getIngredientes() + "\n";
            s+="----------------------------------------------------------------------"+ "\n";
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
                    encola(new Hamburguesa("Hamburguesa de carne", 5, "pan y carne"));
                    //System.out.println("------------------");
                    //System.out.println(imprimir());
                    cantidad=1;
                }
                break;
            case 1:
                int y;
                y=recorrerCola();
                if(y != 3){
                    encola(new Hamburguesa("Hamburguesa de queso", 10, "pan, carne y queso"));
                    //System.out.println("------------------");
                    //System.out.println(imprimir());
                    cantidad=2;
                }
                break;
            case 2:
                int z;
                z=recorrerCola();
                if(z != 3){
                    encola(new Hamburguesa("Hamburguesa clásica", 15, "pan, carne, queso y lechuga"));
                    //System.out.println("------------------");
                    //System.out.println(imprimir());
                    cantidad=0;
                }
                break;
            default:
                break;
        }
    }
    
}

