
package game.ihm.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Interface {
    
    public static void ShowInterface()
    {
        JMenuBar menuBar;
        JMenuItem newGame,menu,parameters,credits,leave;
        JPanel panel;
        //JMenuItem submenuItem1,submenuItem2;

        JFrame myLayout = new JFrame("Layout général");
        
        //creation menubar
        menuBar = new JMenuBar();
        
        //creation menu
        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Menu du programme");
        
        //IL FAUDRA AJOUTER DES SUBMENU A PARAMETRE
        /*
        //item du submenu
        submenuItem1 = new JMenuItem("1er item du submenu");
        submenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        
        submenuItem2 = new JMenuItem("1er item du submenu");
        submenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        */

        newGame = new JMenuItem("Nouvelle Partie");
        newGame.setMnemonic(KeyEvent.VK_S);

        parameters = new JMenuItem("Paramètres");
        parameters.setMnemonic(KeyEvent.VK_S);

        credits = new JMenuItem("Crédits");
        credits.setMnemonic(KeyEvent.VK_S);

        leave = new JMenuItem("Quitter");
        leave.setMnemonic(KeyEvent.VK_S);

        menu.add(newGame);
        menu.add(parameters);
        menu.add(credits);
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
