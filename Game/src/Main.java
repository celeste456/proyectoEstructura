

import javax.swing.JFrame;


public class Main {
    
    public static void main(String []args){
        JFrame f = new JFrame("GAME");
        Game game = new Game();
        //f.setBackground(Color.BLACK);
        f.getContentPane().add(game);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(550,500);
        f.setVisible(true);
        
    }


      
    
        
        
}
