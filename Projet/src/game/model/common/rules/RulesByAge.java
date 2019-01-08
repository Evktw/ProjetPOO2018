/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.rules;

import game.model.common.PlayerList;
import game.model.common.player.Human;

/**
 *
 * @author Opti-Pognon
 */
public class RulesByAge extends Rules {

    /**
     * Attributs
     */
    PlayerList sortedList = this.playerList;


    public RulesByAge(PlayerList p)
    {
        super(p);
        getFirstByLowerAge();
    }
    
    
    public PlayerList getFirstByLowerAge()
    {
        int agemin = getLowerAgeInList();
        for (int l=1; l< playerList.getSize(); l++) {
            for (int i = 0; i < this.playerList.getSize() - 1; i++) {
                if (this.playerList.getPlayer(i) instanceof Human) {
                    if (agemin == ((Human) this.playerList.getPlayer(i)).getAge())
                        this.playerList.swap(0, i);
                }
            }
            this.sortedList.addPlayer(this.playerList.getPlayer(0));
            this.playerList.removePlayer(this.playerList.getPlayer(0));
        }
        return this.sortedList;
    }        
    
    
    public int getLowerAgeInList()
    {
        int age=0;
        for (int l=1; l< this.playerList.getSize(); l++) {
            for (int i = 0; i < this.playerList.getSize() - 1; i++) {
                if (this.playerList.getPlayer(i) instanceof Human) {
                    int humanAge = ((Human) this.playerList.getPlayer(i)).getAge();

                    if (humanAge > age)
                        age = humanAge;
                }
            }
            return age;
    }        
    
    
}    

