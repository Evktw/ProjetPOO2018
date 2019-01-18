package game.ihm.graphic;

import game.model.common.PlayerList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CreationsPlayers implements ActionListener{
    private final int MAX_PLAYERS = 8;
    private final int MIN_PLAYERS = 2;
    private final int DEFAULT_NBPLAYERS = 2;

    private JRadioButton humanButton = new JRadioButton();
    private JRadioButton cpuButton = new JRadioButton();
    private ButtonGroup species = new ButtonGroup();
    private JTextField nameIn = new JTextField("");
    
    public Interface CreationsPlayers() {
        
        JPanel panelNbjoueurs;
        JPanel panelJoueur[MAX_PLAYERS];
        SpinnerModel spinnerModel;
        JSpinner spinner;
        int i = 0;
        
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
                int value = (int)spinner.getValue();
                if(value > DEFAULT_NBPLAYERS + i) {
                    (panelJoueur[value]) = aNewChallenger(value);
                    (panelJoueur[value]).setVisible(true);
                    i++;
                }    
                else if(value < DEFAULT_NBPLAYERS + i) {
                    (panelJoueur[value]).setVisible(false);
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
        this.humanButton = new JRadioButton();
        this.humanButton.setMnemonic(KeyEvent.VK_B);
        this.humanButton.setSelected(true);

        //Bouton CPU
        this.cpuButton = new JRadioButton();

        //Groupe Humain/CPU
        this.species.add(humanButton);
        this.species.add(cpuButton);
        this.humanButton.addActionListener(this);
        this.cpuButton.addActionListener(this);

        this.nameIn = new JTextField("");

        //On ajoute tout au panel instancié plus haut :
        challenger.add(name);
        challenger.add(humanButton);
        challenger.add(cpuButton);
        challenger.add(nameIn);
        //On ajoute l'avatar est crée dans la classe IhmImage
        challenger.add(new IhmImage());

        return challenger;
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()== this.humanButton){
            if(this.humanButton.isSelected()==true){
                //joueur humain
            }
            else{
                //joueur computer
            }
        }
    }
}
