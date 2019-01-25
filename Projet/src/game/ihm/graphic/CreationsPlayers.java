package game.ihm.graphic;

import game.model.common.player.Player;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CreationsPlayers implements ActionListener{
    private final int MAX_PLAYERS = 8;
    private final int MIN_PLAYERS = 2;
    private final int DEFAULT_NBPLAYERS = 2;
    private JPanel[] panelJoueur = new JPanel[MAX_PLAYERS];

    private JRadioButton humanButton = new JRadioButton();
    private JRadioButton cpuButton = new JRadioButton();
    private ButtonGroup species = new ButtonGroup();
    private JTextField nameIn = new JTextField("");
    private boolean isHuman = false;
    private JButton submit = new JButton("Valider");
    private int gridHeight = 3;
    private int gridWidth = 4;

    
    public JPanel PlayersPanel() {

        //Création de la grille et des contraintes de placement
        JPanel playersPanel = new JPanel();
        GridLayout playersLayout = new GridLayout(gridHeight, gridWidth);
        playersPanel.setLayout(playersLayout);
        playersPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //Création et placement du Spinner
        SpinnerModel spinnerModel;
        JSpinner spinner;
        spinnerModel = new SpinnerNumberModel(DEFAULT_NBPLAYERS,MIN_PLAYERS,MAX_PLAYERS,1);
        spinner = new JSpinner(spinnerModel);
        ((DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);
        playersPanel.add(spinner);

        //Création des deux premiers joueurs :
        panelJoueur[1]  = aNewChallenger(1);
        panelJoueur[2]  = aNewChallenger(2);
        playersPanel.add(panelJoueur[1]);
        playersPanel.add(panelJoueur[2]);
        this.submit.addActionListener(this);

        /*Anciennes contraintes avec GidBagLayout
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.fill = GridBagConstraints.RELATIVE;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        */

        //En Cas de Changement de valeur sur le spinner :
        spinner.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent ce)
            {
                try {
                    spinner.commitEdit();
                }catch ( java.text.ParseException e){}
                int value = (int)spinner.getValue();
                for(int i = 2 ;i < value; i++) {
                    if (panelJoueur[i] == null) {
                        panelJoueur[i] = aNewChallenger(i);
                    }
                    if(!panelJoueur[i].isVisible()) {
                        panelJoueur[i].setVisible(true);
                        playersPanel.add(panelJoueur[i]);
                    }
                }
            }
        });
        return playersPanel;
    }


    private JPanel aNewChallenger(int value){
        JPanel challenger = new JPanel();
        GridLayout datalayout = new GridLayout(0,2);
        challenger.setLayout(datalayout);
        challenger.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

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
        challenger.add(new IhmImage());
        challenger.add(new JLabel("Humain : "));
        challenger.add(humanButton);
        challenger.add(new JLabel("Bot : "));
        challenger.add(cpuButton);
        challenger.add(new JLabel("Pseudonyme : "));
        challenger.add(nameIn);
        challenger.setLayout(new BoxLayout(challenger, BoxLayout.PAGE_AXIS));
        challenger.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));
        challenger.setBackground(Color.white);

        return challenger;
    }


    public void actionPerformed(ActionEvent e){
        if (e.getSource()== this.humanButton){
            if(this.humanButton.isSelected()){
                isHuman = true;
            }
        }
        else if(e.getSource()==this.submit) {
            for (int i = 1; i <= MAX_PLAYERS; i++) {
                if ((panelJoueur[i]).isVisible()) {
                    //On ajoute le joueur à la liste des joueurs
                }
            }
        }
    }


}
