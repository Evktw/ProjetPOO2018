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
        JPanel playersPanel = new JPanel();
        SpinnerModel spinnerModel;
        JSpinner spinner;
        this.submit.addActionListener(this);
        spinnerModel = new SpinnerNumberModel(DEFAULT_NBPLAYERS,MIN_PLAYERS,MAX_PLAYERS,1);
        spinner = new JSpinner(spinnerModel);
        ((DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);

        //Création de la grille et des contraintes de placement
        playersPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.fill = GridBagConstraints.RELATIVE;

        //On place le spinner
        playersPanel.add(spinner, gridConstraints);

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
                    JPanel player = panelJoueur[i];
                    if (player == null) {
                        player = aNewChallenger(i);
                    }
                    player.setVisible(true);

                    // On modifie les contraintes de placement en fonction de i :
                    if (i <= 4) {
                        gridConstraints.gridx = i - 1;
                        gridConstraints.gridy = 1;
                    }
                    if (i >= 5) {
                        gridConstraints.gridx = i - 5;
                        gridConstraints.gridy = 2;
                    }
                    playersPanel.add(player, gridConstraints);
                    //SecondaryPanel.add(player, gridConstraints);
                }
                //changeMainPanel();
            }
        });
        return playersPanel;
    }

   /*private JPanel changeMainPanel(JPanel old, JPanel new, SpinnerModel spinner){
        JPanel tochange = .remove()

   }
   */

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
