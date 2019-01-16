package game.ihm.graphic;

import game.model.common.PlayerList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CreationsPlayers
{
    private final int MAX_PLAYERS = 8;
    private final int MIN_PLAYERS = 2;
    private final int DEFAULT_NBPLAYERS = 2;

    
    public Interface CreationsPlayers()
    {
        
        JPanel panelNbjoueurs, panelJoueur[MAX_PLAYERS];
        SpinnerModel spinnerModel;
        JSpinner spinner;
        
        panelNbjoueurs = new JPanel(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        
        panelNbjoueurs.setBackground(Color.green);
        
        spinnerModel = new SpinnerNumberModel(DEFAULT_NBPLAYERS,MIN_PLAYERS,MAX_PLAYERS,1);
        spinner = new JSpinner(spinnerModel);
        ((DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);
        
        spinner.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent ce)
            {
                int i = 0;
                int value = (int)spinner.getValue();
                if(value > DEFAULT_NBPLAYERS + i) {
                    (panelJoueur[value]) = aNewChallenger(value);
                    (panelJoueur[value]).setVisible(true);
                    i++;
                }    
                else if(value < DEFAULT_NBPLAYERS + i) {
                    (panelJoueur[value]).setVisible(true);
                    i--;

                }
            }
        });

        
        return null;
        
    }


    private JPanel aNewChallenger(int value){
        JPanel challenger = new JPanel();

        JLabel name = new JLabel("Player " + value);

        //Bouton Humain
        JRadioButton humanButton = new JRadioButton();
        humanButton.setMnemonic(KeyEvent.VK_B);
        humanButton.setSelected(true);

        //Bouton CPU
        JRadioButton cpuButton = new JRadioButton();
        ButtonGroup species = new ButtonGroup();

        //Groupe Humain/CPU
        species.add(humanButton);
        species.add(cpuButton);
        humanButton.addActionListener(this);
        cpuButton.addActionListener(this);

        //Input du Nom
        JTextField nameIn = new JTextField("");

        //Avatar
        BufferedImage avatar = ImageIO.read(new File(avatar));
        ImageIcon img = new ImageIcon(avatar);

        //On ajoute tout au panel instancié plus haut :
        challenger.add(name);
        challenger.add(humanButton);
        challenger.add(cpuButton);
        challenger.add(nameIn);
        challenger.add(img);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()== this.humanButton){

        }
    }
}
