package game.model.common.rules;

import game.model.common.PlayerList;
import game.model.common.player.Human;

public class RulesByAge extends Rules
{

    public RulesByAge(PlayerList p)
    {
        super(p);
        getFirstByLowerAge();
    }
/*
    private PlayerList getFirstByLowerAge() {
        PlayerList sortedList = new PlayerList(this.playerList.getGame());
        while (this.playerList.getSize() != 1) {
            int agemin = getLowerAgeInList();
            for (int i = 0; i < this.playerList.getSize() - 1; i++) {
                if (this.playerList.getPlayer(i) instanceof Human) {
                    if (agemin == ((Human) this.playerList.getPlayer(i)).getAge())
                        this.playerList.swap(0, i);
                }
            }
            sortedList.addPlayer(this.playerList.getPlayer(0));
            this.playerList.removePlayer(this.playerList.getPlayer(0));
        }
        for (int i = 0; i < sortedList.getSize() - 1; i++) {
            this.playerList.addPlayer(sortedList.getPlayer(i));
        }
        return this.playerList;
    }

    private int getLowerAgeInList() {
        int age = -1;
        for (int l=1; l< this.playerList.getSize(); l++) {
            for (int i = 0; i < this.playerList.getSize() - 1; i++) {
                if (this.playerList.getPlayer(i) instanceof Human) {
                    if(age == -1){
                        age = ((Human) this.playerList.getPlayer(i)).getAge();
                    }
                    int humanAge = ((Human) this.playerList.getPlayer(i)).getAge();

                    if (humanAge < age)
                        age = humanAge;
                }
            }
        }
            return age;
        }

*/
    
    private PlayerList getFirstByLowerAge() 
    {   
        int id = 0;

        while(id < this.playerList.getSize())
        {
            if(this.playerList.getPlayer(id) instanceof Human)
            {    
                int lowerage = ((Human) this.playerList.getPlayer(id)).getAge();

                if(this.playerList.getPlayer(id) instanceof Human)
                {
                    for(int i = 0; i < this.playerList.getSize(); i++)
                    {
                        if(this.playerList.getPlayer(i) instanceof Human)
                        {
                            if(((Human) this.playerList.getPlayer(i)).getAge() < lowerage)
                            {
                                lowerage = ((Human) this.playerList.getPlayer(i)).getAge();
                                this.playerList.swap(id,i);
                            }    
                        }    
                    }    
                }  
            
            } 
            id++;
        }    
        
        this.playerList.reverse();
        
        return this.playerList;
    }
    
}    

