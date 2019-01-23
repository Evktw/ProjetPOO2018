
package game.ihm.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import game.ihm.graphic.CreationsPlayers;


public class Interface {
    
    public static void ShowInterface()
    {
        JMenuBar menuBar;
        JMenuItem newGame,menu,parameters,credits, playersList, leave;
        CreationsPlayers cp = new CreationsPlayers();
        JPanel panel;

        //JMenuItem submenuItem1,submenuItem2;

        JFrame mainJFrame = new JFrame("Layout général");
        
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
        mainJFrame.setJMenuBar(menuBar);
        panel = cp.PlayersPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));

        mainJFrame.setContentPane(panel);
        mainJFrame.getContentPane().setBackground(Color.white);
        mainJFrame.setPreferredSize(new Dimension(800,800));
        mainJFrame.setMaximumSize(new Dimension(800,800));
        mainJFrame.setMinimumSize(new Dimension(800,800));
        mainJFrame.setVisible(true);
        mainJFrame.pack();
        mainJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainJFrame.setLocationRelativeTo(null);
        
        
        
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
