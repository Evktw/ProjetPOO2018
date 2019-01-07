/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.common.player;

import game.model.nim.Nim;
import java.util.Scanner;

/**
 *
 * @author evktw
 */
public class HumanNim extends Human implements PlayerNim {
    
    public HumanNim(String name, int age, Nim nim) {
        super(name, age, nim);
    }

    @Override
    public int play(int nbperturn, int nbtotal) 
    {
        Scanner sc = new Scanner(System.in);
        int valeur;
        
        do
        {
            valeur = sc.nextInt();
            
            if(valeur > nbperturn || valeur < 1)
                System.out.println("Nombre invalide, rentrez une autre valeur");
        }
        while(valeur > nbperturn || valeur < 1);
        
        return nbtotal-valeur;
    }


    
    
    
    
}
