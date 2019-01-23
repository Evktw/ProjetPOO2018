package game.ihm.graphic;

import game.model.common.PlayerList;
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
    private List<Player> playerList;

    private JRadioButton humanButton = new JRadioButton();
    private JRadioButton cpuButton = new JRadioButton();
    private ButtonGroup species = new ButtonGroup();
    private JTextField nameIn = new JTextField("");
    private boolean isHuman = false;
    private JButton submit = new JButton("Valider");
    
    public JPanel PlayersPanel() {
        JPanel completePanel = new JPanel();
        JPanel panelNbjoueurs;
        SpinnerModel spinnerModel;
        JSpinner spinner;
        this.submit.addActionListener(this);
        
        panelNbjoueurs = new JPanel(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 1;
        grid.gridy = 0;
        
        panelNbjoueurs.setBackground(Color.green);
        
        spinnerModel = new SpinnerNumberModel(DEFAULT_NBPLAYERS,MIN_PLAYERS,MAX_PLAYERS,1);
        spinner = new JSpinner(spinnerModel);
        ((DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);

        //On place le spinner
        completePanel.add(spinner);


        //En Cas de Changement de valeur sur le spinner :
        spinner.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent ce)
            {
                try {
                    spinner.commitEdit();
                }catch ( java.text.ParseException e){}
                int value = (int)spinner.getValue();
                for(int i = 2 ;i <= value; i++){
                    if(panelJoueur[i].isVisible() == false){
                        if(panelJoueur[i] == null) {
                            panelJoueur[i] = aNewChallenger(i);
                        }
                        panelJoueur[i].setVisible(true);
                        if(i <= 4){
                            grid.gridx = i - 1;
                            grid.gridy = 0;
                            panelNbjoueurs.add(panelJoueur[i], grid);
                        }
                        else{
                            grid.gridx = i-5;
                            grid.gridy = 1;
                            panelNbjoueurs.add(panelJoueur[i], grid);
                            }
                    }
                }
            }
        });
        completePanel.add(panelNbjoueurs);
        return completePanel ;
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
        //On ajoute l'avatar qui est crée dans la classe IhmImage
        challenger.add(new IhmImage());

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
