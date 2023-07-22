/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package overcookedgame;


import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class OverCookedGame {

   
    public static void main(String[] args) {
        //crea la tarea que llama al metodo run
        /*TimerTask task = new Cola();
        Timer timer = new Timer();
        timer.schedule(task, 1000, 5000);*/
        
        /*Interfaz interfaz= new Interfaz();
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);*/
            boolean j=false;
            JFrame frame = new JFrame();
            
            //cola de PEDIDOS
            Cola cola = new Cola();
            cola.run();
            
            //ListaCircular de INGREDIENTES SELECCIONABLES
            ListaCircular lc= new ListaCircular();
            lc.insertaModificado();

            //Ingredientes seleccionables dentro del JOptionPane
            NodoLista seleccionables= lc.getCabeza();
            String[] options = {seleccionables.getDato().getIngrediente(),seleccionables.getNext().getDato().getIngrediente(),
                                seleccionables.getNext().getNext().getDato().getIngrediente(),seleccionables.getNext().getNext().getNext().getDato().getIngrediente()};
            //PEDIDO ACTUAL
            Nodo aux=cola.atiende();
                
            //listaCircular para INGREDIENTES YA SELECCIONADOS
            ListaCircular lc2= new ListaCircular();
               
            while(j!=true){
                lc.insertaModificado();
                //Switch de Cola pedidos según su puntaje
                switch (aux.getDato().getPuntaje()){
                    case 5:
                        boolean x;
                        do{
                            int i=JOptionPane.showOptionDialog(frame.getContentPane(), aux.toString(), "ORDEN ACTUAL", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                            x=lc2.validarDos(i);
                            if(x!=false){
                               aux=cola.atiende();
                               JOptionPane.showMessageDialog(null, "PEDIDO COMPLETADO!");
                            }
                        }while(x!=true);
                        break;
                    case 10:
                        boolean w;
                        do{
                            int i=JOptionPane.showOptionDialog(frame.getContentPane(), aux.toString(), "ORDEN ACTUAL", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                            w=lc2.validarTres(i);
                            if(w!=false){
                               aux=cola.atiende();
                               JOptionPane.showMessageDialog(null, "PEDIDO COMPLETADO!");
                            }
                        }while(w!=true);
                        break;
                    case 15:
                        //hamburguesa especial
                        break;
                    default:
                        break;
                }
            }
            
    }
 


    
}
