/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.rules;

import game.model.common.PlayerList;

/**
 *
 * @author Opti Pognon
 */

//Pour les mot clés, faire une interface implémenté par tous les jeux (voir avec la prof)

public abstract class Rules
{
    public PlayerList playerList;
    
    Rules(PlayerList p)
    {
        this.playerList = p;
    }        
}
