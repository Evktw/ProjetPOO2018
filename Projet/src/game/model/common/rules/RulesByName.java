/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.rules;

import game.model.common.PlayerList;

public class RulesByName extends Rules{

    public RulesByName(PlayerList p) {
        super(p);
        String theLower = getLowerNameInList();
        for (int i = 1; i < this.playerList.getSize() - 1; i++) {
            if ( theLower == (this.playerList.getPlayer(i)).getName())
                this.playerList.swap(0, i);
        }
    }

    public String getLowerNameInList() {
        String theLower = (this.playerList.getPlayer(0).getName()) ;
        for (int i = 0; i < this.playerList.getSize() - 1; i++) {
            String currentName = (this.playerList.getPlayer(i).getName());
            int y = 0;
            while (y < currentName.length()){
                if(currentName.charAt(y) < (theLower.charAt(y))){
                    theLower = currentName;
                    break;
                }
                else{
                    y++;
                }
          }
        }
        return theLower;
    }

}


