/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.ihm.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author evktw
 */
public class Interface {
    
    public static void Interface()
    {
        JMenuBar menuBar;
        JMenuItem menu,parameters,leave;
        //JMenuItem submenuItem1,submenuItem2;

        JFrame myLayout = new JFrame("Layout général");
        
        //creation menubar
        menuBar = new JMenuBar();
        
        //creation menu
        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Menu du programme");
        
        //submenu
        parameters = new JMenu("Paramètres");
        parameters.setMnemonic(KeyEvent.VK_S);
        
        //IL FAUDRA AJOUTER DES SUBMENU A PARAMETRE
        /*
        //item du submenu
        submenuItem1 = new JMenuItem("1er item du submenu");
        submenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        
        submenuItem2 = new JMenuItem("1er item du submenu");
        submenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        

        //Ajout des submenu dans le menu
        submenu.add(submenuItem1);
        submenu.add(submenuItem2);
        */
        
        //submenu 2
        leave = new JMenu("Quitter");
        leave.setMnemonic(KeyEvent.VK_S);
        
        //ajout du submenu dans le menu
        menu.add(parameters);
        menu.add(leave);
        
        //Ajouter le menu dans la menubar
        menuBar.add(menu);
        
        //Rends le menu opaque et gere la taille
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(700,40));
        
        //Parametrage de la frame
        myLayout.setJMenuBar(menuBar);
        
        //myLayout.setPreferredSize(new Dimension(700,700));
        myLayout.setMaximumSize(new Dimension(700,700));
        myLayout.setMinimumSize(new Dimension(700,700));
        myLayout.setVisible(true);
        myLayout.pack();
        myLayout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myLayout.setLocationRelativeTo(null);
        
        //Pas forcément utile
        myLayout.getContentPane().setBackground(Color.white);
        
        
        
        
        
    }        
    
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    Interface();
                }        
            }
        );
    }        
    
}
