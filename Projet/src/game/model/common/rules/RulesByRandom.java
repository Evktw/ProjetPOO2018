/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.rules;

import game.model.common.PlayerList;
/**
 *
 * @author Opti-Pognon
 */
public class RulesByRandom extends Rules {
           
    public RulesByRandom(PlayerList p) 
    {
        super(p);
        this.playerList.shuffle();
    }
    
    
    
    
}
