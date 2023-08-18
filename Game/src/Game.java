import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Game extends JPanel {
    
    private ImageIcon imagen6;
    private ImageIcon imagen7;
    private ImageIcon imagen8;
    private Rectangle rectangulo1, rectangulo2, rectangulo3, rectangulo4, rectangulo5, rectangulo6, rectangulo7;//alto ancho
    private Point puntoInicial1, puntoInicial2, puntoInicial3, puntoInicial4, puntoInicial5;//cordenadas
    
    private ListaCircular lc= new ListaCircular();   
    private Cola cola = new Cola();
    
    private Set<Integer> seleccionados = new HashSet<>(); //Colección de ingredientes seleccionados
    private int puntaje;
    private JLabel puntajeLabel;
    
    //variables del Contador 
    private Timer timer;
    private int segundo,minuto;
    private String ddsegundo, ddminuto;
    private DecimalFormat dfor = new DecimalFormat("00");
    private JLabel tm;
    
    //ordenes 
    private JTextArea ordenes;
    private String orden;
    
    public Game(){
        //instancio coordenadas de imagenes
        this.puntoInicial1 = new Point(15, 15);//coordenadas iniciales
        this.puntoInicial2 = new Point(115, 15);
        this.puntoInicial3= new Point(215, 15);
        this.puntoInicial4 = new Point(315, 15);
        this.puntoInicial5 = new Point(415, 15);
        
        this.imagen6 = new ImageIcon(getClass().getResource("img/hambSencilla.png"));
        this.imagen7 = new ImageIcon(getClass().getResource("img/trash.png"));
        this.imagen8= new ImageIcon(getClass().getResource("img/fondo.jpg"));
        
        this.rectangulo1 = new Rectangle(puntoInicial1.x, puntoInicial1.y, 80, 71);//rectangulo(borde de la imagen)
        this.rectangulo2 = new Rectangle(puntoInicial2.x, puntoInicial2.y, 80, 71);
        this.rectangulo3 = new Rectangle(puntoInicial3.x, puntoInicial3.y, 80, 71);
        this.rectangulo4 = new Rectangle(puntoInicial4.x, puntoInicial4.y, 80, 71);
        this.rectangulo5 = new Rectangle(puntoInicial5.x, puntoInicial5.y, 80, 71);
        this.rectangulo6 = new Rectangle(230, 225, 100, 85);//rectangulo de hambu
        this.rectangulo7 = new Rectangle(370, 225, 80, 80);//rectangulo de basura
          
        puntajeLabel = new JLabel("Puntaje: 0");
        tm = new JLabel("00:00");
        
        
        //tiempo de inicio
        segundo =30;
        minuto =0;
        tiempo();
        timer.start();
        
        //órdenes
        ordenes = new JTextArea();//textArea para mostrar las ordenes
        ordenes.setLineWrap(true); //quita que las líneas sean más largas que el ancho del área
        ordenes.setWrapStyleWord(false);//quita el ajuste automático de palabras
        ordenes.setBounds(0, 0, 200, 300);
        ordenes.setEditable(false);
        
        //panel inferior de ordenes
        JScrollPane panelOrdenes = new JScrollPane(ordenes);
        panelOrdenes.setPreferredSize(new Dimension(200, 300)); // Establece el tamaño preferido del JScrollPane
        setLayout(new BorderLayout());

        //Panel superior para puntaje y tiempo usando FlowLayout
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 215, 0));
        panelSuperior.add(puntajeLabel);
        panelSuperior.add(tm);
        
        //agregar los paneles
        add(panelSuperior, BorderLayout.NORTH);
        add(panelOrdenes, BorderLayout.PAGE_END);
        
        orden = cola.imprimir();
        
        movimientos();//se llama al metodo que detecta los movimientos del mouse
    }
    
    public void tiempo(){
        timer = new Timer(1000,new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                segundo--;
                
                ddsegundo = dfor.format(segundo);
                ddminuto = dfor.format(minuto);
                
                tm.setText(ddminuto+":"+ddsegundo);
                
                if(segundo== -1){
                    segundo = 59;
                    minuto--;
                    
                    ddsegundo = dfor.format(segundo);
                    ddminuto = dfor.format(minuto);
                    tm.setText(ddminuto+":"+ddsegundo);
                }
                
                if(minuto == 0 && segundo == 0 ){
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Game Over"+"\n"+"Puntaje Final: "+puntaje);
                }
            }
        });
    }
       
    //metodo que define las acciones del mouse
    public void movimientos() {
        MouseAdapter ma = new MouseAdapter(){//para manejar eventos con el mouse
            boolean movimiento1 = false;//si hay moviento o no 
            boolean movimiento2 = false;
            boolean movimiento3 = false;
            boolean movimiento4 = false;
            boolean movimiento5 = false;
            int distanciaX1, distanciaY1;//para calcular el desplazamiento de las imagenes
            int distanciaX2, distanciaY2;
            int distanciaX3, distanciaY3;
            int distanciaX4, distanciaY4;
            int distanciaX5, distanciaY5;
            
            @Override
            public void mouseDragged(MouseEvent e) {
                //actualiza la posición del objeto(punto inicial), restando la posicion original menos la nueva posicion del mouse
                if (movimiento1) {
                    puntoInicial1.x = e.getX() - distanciaX1;
                    puntoInicial1.y = e.getY() - distanciaY1;
                    rectangulo1.setLocation(puntoInicial1.x, puntoInicial1.y);
                    
                }else if (movimiento2) {
                    puntoInicial2.x = e.getX() - distanciaX2;
                    puntoInicial2.y = e.getY() - distanciaY2;
                    rectangulo2.setLocation(puntoInicial2.x, puntoInicial2.y);
                    
                }else if (movimiento3) {
                    puntoInicial3.x = e.getX() - distanciaX3;
                    puntoInicial3.y = e.getY() - distanciaY3;
                    rectangulo3.setLocation(puntoInicial3.x, puntoInicial3.y);
                    
                }else if (movimiento4) {
                    puntoInicial4.x = e.getX() - distanciaX4;
                    puntoInicial4.y = e.getY() - distanciaY4;
                    rectangulo4.setLocation(puntoInicial4.x, puntoInicial4.y);
                    
                }else if (movimiento5) {
                    puntoInicial5.x = e.getX() - distanciaX5;
                    puntoInicial5.y = e.getY() - distanciaY5;
                    rectangulo5.setLocation(puntoInicial5.x, puntoInicial5.y);
                }
                repaint(); //repintar el panel 
            }

            @Override
            public void mousePressed(MouseEvent e) {              
                //si el rectangulo contiene la coordenada de click del mouse dentro de el
                if (rectangulo1.contains(e.getX(), e.getY())) {
                    //resta la coordenada de click menos el punto inicial
                    //sacando la distancia entre la posicion original del objeto y el click del mouse
                    //la función es referencia hacia adonde se mueve y no perder el punto inicial, además se activa movimiento
                    distanciaX1 = e.getX() - puntoInicial1.x;
                    distanciaY1 = e.getY() - puntoInicial1.y;
                    movimiento1 = true;
                    
                }else if(rectangulo2.contains(e.getX(), e.getY())) {
                    distanciaX2 = e.getX() - puntoInicial2.x;
                    distanciaY2 = e.getY() - puntoInicial2.y;
                    movimiento2 = true;
                    
                }else if(rectangulo3.contains(e.getX(), e.getY())) {
                    distanciaX3 = e.getX() - puntoInicial3.x;
                    distanciaY3 = e.getY() - puntoInicial3.y;
                    movimiento3 = true;
                    
                }else if(rectangulo4.contains(e.getX(), e.getY())) {
                    distanciaX4 = e.getX() - puntoInicial4.x;
                    distanciaY4 = e.getY() - puntoInicial4.y;
                    movimiento4 = true;
                    
                }else if(rectangulo5.contains(e.getX(), e.getY())) {
                    distanciaX5 = e.getX() - puntoInicial5.x;
                    distanciaY5 = e.getY() - puntoInicial5.y;
                    movimiento5 = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //declaro las variables en 0 porque ya se terminó el arrastre entonces ya no hay tal distancia en X y Y
                //vuelvo a declarar los puntos para colocar la imagen en su posicion original
                juego();
                distanciaX1 = 0;distanciaY1 = 0;
                puntoInicial1.x = 15;puntoInicial1.y = 15;
                rectangulo1.setLocation(puntoInicial1.x, puntoInicial1.y);
                
                distanciaX2 = 0;distanciaY2 = 0;
                puntoInicial2.x = 115;puntoInicial2.y = 15;
                rectangulo2.setLocation(puntoInicial2.x, puntoInicial2.y);
                
                distanciaX3 = 0;distanciaY3 = 0;
                puntoInicial3.x = 215;puntoInicial3.y = 15;
                rectangulo3.setLocation(puntoInicial3.x, puntoInicial3.y);
                
                distanciaY4 = 0;distanciaY4 = 0;
                puntoInicial4.x = 315;puntoInicial4.y =15;
                rectangulo4.setLocation(puntoInicial4.x, puntoInicial4.y);
                
                distanciaY5 = 0;distanciaY5 = 0;
                puntoInicial5.x = 415;puntoInicial5.y = 15;
                rectangulo5.setLocation(puntoInicial5.x, puntoInicial5.y);
                
                movimiento1 = false;movimiento2 = false; movimiento3 = false;movimiento4 = false;movimiento5 = false;
                repaint();
            }
        };
        //detecta los movimientos del mouse
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    //metodo que pinta/dibuja los ingredientes según el orden de la listaCircular
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen8.getImage(),0,0,this); //fondo juego
        //creo listaCircular 
        lc.insertaModificado();
        //variable recibe cantidad de nodos
        int i= lc.recorrer();
        //Primer nodo de la lista
        NodoLista aux= lc.getCabeza();
        //se pinta la imagen según la cantidad de nodos y el orden de estos en la listaCircular
        if(i==5){
            while(i>0){
                if(i==5){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial1.x, puntoInicial1.y, this);
                }if(i==4){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial2.x, puntoInicial2.y, this);
                }if(i==3){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial3.x, puntoInicial3.y, this);
                }if(i==2){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial4.x, puntoInicial4.y, this);
                }if(i==1){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial5.x, puntoInicial5.y, this);
                }
                aux= aux.getNext();
                i--;
            }
        }if(i==4){
            while(i>0){
                if(i==4){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial1.x, puntoInicial1.y, this);
                }if(i==3){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial2.x, puntoInicial2.y, this);
                }if(i==2){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial3.x, puntoInicial3.y, this);
                }if(i==1){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial4.x, puntoInicial4.y, this);
                }
                aux= aux.getNext();
                i--;
            }
        }if(i==3){
            while(i>0){
                 if(i==5){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial1.x, puntoInicial1.y, this);
                }if(i==4){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial2.x, puntoInicial2.y, this);
                }if(i==3){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial3.x, puntoInicial3.y, this);
                }if(i==2){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial4.x, puntoInicial4.y, this);
                }if(i==1){
                    g.drawImage(aux.getDato().getImagen().getImage(), puntoInicial5.x, puntoInicial5.y, this);
                }
                aux= aux.getNext();
                i--;
            }
        }
        //dibujar ordenes
        g.drawImage(imagen6.getImage(), 230, 225, this);
        g.drawImage(imagen7.getImage(), 400, 225, this);
    }
    
    //metodo colision de imagenes, retorna un numero dependiendo del ingrediente seleccionado
    public NodoLista colision(){
        NodoLista aux= lc.getCabeza();
        
        //colision con pedidos 
        if(rectangulo1.intersects(rectangulo6.getBounds())){
            //como los rectangulos y los ingredientes se colocan en el mismo orden,
            //entonces retorno el nodo dependiendo del rectangulo colisionado
            return aux;
        }else if(rectangulo2.intersects(rectangulo6.getBounds())){
            return aux.getNext();
            
        }else if(rectangulo3.intersects(rectangulo6.getBounds())){
            return aux.getNext().getNext();
            
        }else if(rectangulo4.intersects(rectangulo6.getBounds())){
           return aux.getNext().getNext().getNext();
           
        }else if(rectangulo5.intersects(rectangulo6.getBounds())){
            return aux.getNext().getNext().getNext().getNext();
        }
        
        //colisión con el basurero 
        NodoLista nodoColisionado = null;
        int posicionIngrediente = -1;
        
        if (rectangulo1.intersects(rectangulo7.getBounds())) {
            nodoColisionado = aux;
            posicionIngrediente = nodoColisionado.getDato().getPosicion();
            
        } else if (rectangulo2.intersects(rectangulo7.getBounds())) {
            nodoColisionado = aux.getNext();
            posicionIngrediente = nodoColisionado.getDato().getPosicion();
            
        } else if (rectangulo3.intersects(rectangulo7.getBounds())) {
            nodoColisionado = aux.getNext().getNext();
            posicionIngrediente = nodoColisionado.getDato().getPosicion();
            
        } else if (rectangulo4.intersects(rectangulo7.getBounds())) {
            nodoColisionado = aux.getNext().getNext().getNext();
            posicionIngrediente = nodoColisionado.getDato().getPosicion();
            
        } else if (rectangulo5.intersects(rectangulo7.getBounds())) {
            nodoColisionado = aux.getNext().getNext().getNext().getNext();
            posicionIngrediente = nodoColisionado.getDato().getPosicion();
        }
        
        // Verificamor el ingrediente que queremos eliminar
        if (posicionIngrediente != -1 && !seleccionados.contains(posicionIngrediente)) { //que no haya sido seleccionado 
            lc.elimina(posicionIngrediente);
        }
        return null;// si no hay colision es null 
    }
   
    //metodo compara pedidos con ingredientes ingresados
    public void juego(){
       //Nodo de la lista circular colisionado 
       NodoLista colisionado=colision();
       //Pedido actual
       cola.run();
       Nodo aux=cola.getFrente();
       
       //agregar ordenes al textArea
       String orden = cola.imprimir();
       ordenes.setText(orden);
       ordenes.repaint();
       
       //si no hay ninguna colision entonces vuelvo al inicio
       if(colisionado!=null){
            switch (aux.getDato().getPuntaje()){
            case 5:
                ordenes.repaint();

                if(!seleccionados.contains(1)){
                    if(colisionado.getDato().getId()==1){
                        seleccionados.add(1);
                        lc.elimina(colisionado.getDato().getPosicion());
                    }
                }if(!seleccionados.contains(2)){
                    if(colisionado.getDato().getId()==2){
                        seleccionados.add(2);
                        lc.elimina(colisionado.getDato().getPosicion());
                    }
                }if(seleccionados.contains(1) && seleccionados.contains(2)){
                    //limpio la colección de ingredientes seleccionados
                    seleccionados.clear();
                    //elimino el pedido que se encuentra al frente de la cola
                    cola.atiende();
                    ordenes.repaint();
                    //actualizo el puntaje
                    puntaje=puntaje+5;
                    puntajeLabel.setText("Puntaje: " + puntaje);
                    this.imagen6 = new ImageIcon(getClass().getResource("img/hambQueso.png"));
                }
                break;
            case 10:
                 if(!seleccionados.contains(1)){
                    if(colisionado.getDato().getId()==1){
                        seleccionados.add(1);
                        lc.elimina(colisionado.getDato().getPosicion());
                    }
                }if(!seleccionados.contains(2)){
                    if(colisionado.getDato().getId()==2){
                        seleccionados.add(2);
                        lc.elimina(colisionado.getDato().getPosicion());
                    }
                }if(!seleccionados.contains(3)){
                    if(colisionado.getDato().getId()==3){
                        seleccionados.add(3);
                        lc.elimina(colisionado.getDato().getPosicion());
                    }
                }if(seleccionados.contains(1) && seleccionados.contains(2) && seleccionados.contains(3)){
                    cola.atiende();
                    ordenes.repaint();
                    seleccionados.clear();
                    puntaje=puntaje+10;
                    puntajeLabel.setText("Puntaje: " + puntaje);
                    this.imagen6 = new ImageIcon(getClass().getResource("img/hambEspecial.png"));
                }
                 break;
            case 15:
                ordenes.repaint();

                if(!seleccionados.contains(1)){
                    if(colisionado.getDato().getId()==1){
                        seleccionados.add(1);
                        lc.elimina(colisionado.getDato().getPosicion());
                    }
                }if(!seleccionados.contains(2)){
                    if(colisionado.getDato().getId()==2){
                        seleccionados.add(2);
                        lc.elimina(colisionado.getDato().getPosicion());
                    }
                }if(!seleccionados.contains(3)){
                    if(colisionado.getDato().getId()==3){
                        seleccionados.add(3);
                        lc.elimina(colisionado.getDato().getPosicion());
                    }
                }if(!seleccionados.contains(4)){
                    if(colisionado.getDato().getId()==4){
                        seleccionados.add(4);
                        lc.elimina(colisionado.getDato().getPosicion());
                    }
                }if(seleccionados.contains(1) && seleccionados.contains(2) && seleccionados.contains(3) && seleccionados.contains(4)){
                    cola.atiende();
                    ordenes.repaint();
                    seleccionados.clear();
                    puntaje=puntaje+15;
                    puntajeLabel.setText("Puntaje: " + puntaje);
                    this.imagen6 = new ImageIcon(getClass().getResource("img/hambSencilla.png"));
                }
                 break;
            case 0:
                ordenes.repaint();
            default:
                break;
            }
        }
    }
    
}
