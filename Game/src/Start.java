import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import javax.swing.ImageIcon;

public class Start extends javax.swing.JFrame {

    public Start() {
        initComponents();
        setLocationRelativeTo(null);//hacer que salga en el centro 
        setTitle("OverCookedFide");
        setIconImage(new ImageIcon(getClass().getResource("img/hambSencilla.png")).getImage()); 
        
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("musica/musica.wav"));//obtner el audio
            Clip clip = AudioSystem.getClip();//se crea un reproductor de audio
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); //para que se repita
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iniciobtn = new javax.swing.JButton();
        comobtn = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciobtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnStart.png"))); // NOI18N
        iniciobtn.setBorderPainted(false);
        iniciobtn.setContentAreaFilled(false);
        iniciobtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciobtnMouseClicked(evt);
            }
        });
        iniciobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciobtnActionPerformed(evt);
            }
        });
        getContentPane().add(iniciobtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 190, 110));

        comobtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comoJugarbtn.png"))); // NOI18N
        comobtn.setBorderPainted(false);
        comobtn.setContentAreaFilled(false);
        comobtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comobtnMouseClicked(evt);
            }
        });
        getContentPane().add(comobtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 80, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/startFondo.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciobtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iniciobtnActionPerformed

    private void iniciobtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciobtnMouseClicked
    Game game = new Game();
    final JFrame gameFrame = new JFrame("OverCookedFide");
    gameFrame.getContentPane().add(game);
    gameFrame.setSize(550, 660);
    gameFrame.setLocationRelativeTo(null);
    gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    gameFrame.setVisible(true);
    gameFrame.setResizable(false);
    ImageIcon icono = new ImageIcon(Game.class.getResource("img/hambSencilla.png"));
    Image imagenIcono = icono.getImage();
    gameFrame.setIconImage(imagenIcono);
    }//GEN-LAST:event_iniciobtnMouseClicked
    private void comobtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comobtnMouseClicked
       String tutorial = "Eres el chef a cargo de un renombrado restaurante famoso por sus deliciosas hamburguesas.\n"
        + "Tu misión es crear las hamburguesas según las preferencias de los comensales, mientras acumulas la mayor cantidad de puntos en un lapso de 5 minutos.\n" +
        "\n" +
        "Para lograrlo, simplemente arrastra los ingredientes apropiados sobre la hamburguesa "
        + "\ny completa la orden siguiendo los ingredientes requeridos para cada tipo de hamburguesa.\n" +
        "\n" +
        "En la parte inferior de la pantalla, verás las órdenes de los clientes. "
        + "\n Aquí están los tipos de hamburguesas que debes preparar y sus respectivas puntuaciones:\n" +
        "\n" +
        "Hamburguesa de carne (pan, carne): 5 puntos\n" +
        "Hamburguesa con queso (pan, carne, queso): 10 puntos\n" +
        "Hamburguesa clásica (pan, carne, lechuga, queso): 15 puntos\n" +
        "\n¡Sumérgete en la diversión de ser el chef de hamburguesas más veloz y efectivo! ¡Te deseamos mucha suerte en esta emocionante tarea!";
       
        JOptionPane.showMessageDialog(null, tutorial, "Tutorial", JOptionPane.QUESTION_MESSAGE);
    }//GEN-LAST:event_comobtnMouseClicked

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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comobtn;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton iniciobtn;
    // End of variables declaration//GEN-END:variables
}
