
package game.ihm.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class Interface {
    
    public static void ShowInterface()
    {
        JMenuBar menuBar;
        JMenuItem newGame,menu,parameters,credits, playersList, leave;
        JPanel panel;
        //JMenuItem submenuItem1,submenuItem2;

        JFrame myLayout = new JFrame("Layout général");
        
        //creation menubar
        menuBar = new JMenuBar();
        
        //creation menu
        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Menu du programme");


        newGame = new JMenuItem("Nouvelle Partie");
        newGame.setMnemonic(KeyEvent.VK_S);

        parameters = new JMenuItem("Paramètres");
        parameters.setMnemonic(KeyEvent.VK_S);

        credits = new JMenuItem("Crédits");
        credits.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));

        playersList = new JMenuItem("Crédits");
        playersList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));

        leave = new JMenuItem("Quitter");
        leave.setMnemonic(KeyEvent.VK_S);

        menu.add(newGame);
        menu.add(parameters);
        parameters.add(playersList);
        parameters.add(credits);
        menu.add(leave);
        
        //Ajouter le menu dans la menubar
        menuBar.add(menu);
        
        //Rends le menu opaque et gere la taille
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(700,40));
        
        //Parametrage de la frame
        myLayout.setJMenuBar(menuBar);
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));
        
        myLayout.add(panel);
        myLayout.getContentPane().setBackground(Color.white);
        myLayout.setPreferredSize(new Dimension(800,800));
        myLayout.setMaximumSize(new Dimension(800,800));
        myLayout.setMinimumSize(new Dimension(800,800));
        myLayout.setVisible(true);
        myLayout.pack();
        myLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myLayout.setLocationRelativeTo(null);
        
        
        
    }        
    
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    ShowInterface();
                }        
            }
        );
    }        
    
}
