package game.ihm.graphic;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CreationsPlayers
{
    private final int MAX_PLAYERS = 8;
    private final int MIN_PLAYERS = 2;
    private final int DEFAULT_NBPLAYERS = 2;
    
    
    public Interface CreationsPlayers()
    {
        
        JPanel panelNbjoueurs, panelJoueur[];
        SpinnerModel spinnerModel;
        JSpinner spinner;
        int oldValue = DEFAULT_NBPLAYERS;
        
        panelNbjoueurs = new JPanel(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        
        panelNbjoueurs.setBackground(Color.green);
        
        spinnerModel = new SpinnerNumberModel(DEFAULT_NBPLAYERS,MIN_PLAYERS,MAX_PLAYERS,1);
        spinner = new JSpinner(spinnerModel);
        ((DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);
        
        spinner.addChangeListener(new ChangeListener()
        {
            
            @Override
            public void stateChanged(ChangeEvent ce)
            {
                int value = (int)spinner.getValue();
                
                if(value > oldValue)
                {
                    //On ajoute un joueur
                }    
                else if(value < oldValue)
                {
                    //On enleve un joueur
                    
                } 
                
                oldValue = value;
                
            }
            
        });
        
        
        
        
        
        
        return null;
        
        
        
        
        
        
    }
    
    
    
}
