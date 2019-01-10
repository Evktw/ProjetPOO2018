package game.model.common.player;

import game.model.nim.Nim;
import java.util.Scanner;

/**
 *
 * @author Opti-Pognon
 */
public class HumanNim extends Human implements PlayerNim {


    /**
     * Constructeur de HumanNim
     * @param name
     * @param age
     * @param nim
     */
    public HumanNim(String name, int age, Nim nim) {
        super(name, age, nim);
    }

    /**
     * Override de la méthode play quand le joueur est Humain
     * @param nbtotal
     * @param nbperturn
     * @return int
     */
    @Override
    public int play(int nbtotal, int nbperturn) 
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
        
        return valeur;
    }
}
