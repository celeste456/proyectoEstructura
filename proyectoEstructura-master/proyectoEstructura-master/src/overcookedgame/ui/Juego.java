package overcookedgame.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     * 
     * 
     */
    
    //variables para el contador
    Timer timer;
    int segundo,minuto;
    String ddsegundo, ddminuto;
    DecimalFormat dfor = new DecimalFormat("00");
    
    public Juego() {
        initComponents();
        setLocationRelativeTo(null);
        segundo =30;
        minuto =0;
        tiempo();
        timer.start();
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
                    JOptionPane.showMessageDialog(rootPane, "Game Over");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tm = new javax.swing.JLabel();
        fondoJuego = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        tm.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        tm.setText("00:00");
        getContentPane().add(tm);
        tm.setBounds(610, 20, 60, 20);

        fondoJuego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondoJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/overcookedgame/img/juegoFondo.png"))); // NOI18N
        getContentPane().add(fondoJuego);
        fondoJuego.setBounds(0, 0, 700, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondoJuego;
    private javax.swing.JLabel tm;
    // End of variables declaration//GEN-END:variables
}