package game.model.common.player;

import game.model.nim.Nim;
import java.util.Scanner;

public class HumanNim extends Human implements PlayerNim 
{
    
    public HumanNim(String name, int age, Nim nim) {
        super(name, age, nim);
    }

    @Override
    public int play(int nbperturn) 
    {
        Scanner sc = new Scanner(System.in);
        int valeur;
        do
        {
            valeur = sc.nextInt();
            
            if(valeur == 0)
                return -1;
             
            
            if(valeur > nbperturn || valeur < 1)
                System.out.println("Nombre invalide, rentrez une autre valeur");
        }
        while(valeur > nbperturn || valeur < 1);
        
        return valeur;
    }
}
