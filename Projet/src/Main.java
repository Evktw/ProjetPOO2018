import game.model.common.PlayerList;
import game.model.common.player.CpuNim;
import game.model.common.player.HumanNim;
import game.model.nim.Nim;



public class Main
{

    public static void main(String[] args) throws Exception
    {
        Nim nim = null;


        /*
        //----------------------------------------------------------------------------

        //Permet de tester le Nim sans playerlist avec une méthode qui permet d'ajouter des joueurs au début du programme.

        nim = new Nim();
        nim.NimGame();

        */

        /*
        //----------------------------------------------------------------------------

        //Permet de tester le Nim avec des joueurs ajoutés à une PlayerList

        PlayerList pl = new PlayerList(nim);

        nim = new Nim(pl);

        CpuNim a = new CpuNim(nim);
        CpuNim b = new CpuNim(nim);
        CpuNim c = new CpuNim(nim);
        CpuNim d = new CpuNim(nim);
        CpuNim e = new CpuNim(nim);
        CpuNim f = new CpuNim(nim);
        CpuNim g = new CpuNim(nim);
        CpuNim h = new CpuNim(nim);


        HumanNim i = new HumanNim("Colin",27,nim);
        HumanNim j = new HumanNim("Kevin",2,nim);
        HumanNim k = new HumanNim("Mathieu",32,nim);
        HumanNim l = new HumanNim("Anae",29,nim);
        HumanNim m = new HumanNim("Anad",1,nim);
        HumanNim n = new HumanNim("Anac",79,nim);
        HumanNim o = new HumanNim("Ana",7,nim);
        HumanNim p = new HumanNim("Belly",27,nim);


        pl.addPlayer(a);
        pl.addPlayer(b);
        pl.addPlayer(c);
        pl.addPlayer(d);
        pl.addPlayer(e);
        pl.addPlayer(f);
        pl.addPlayer(g);
        pl.addPlayer(h);

        nim.NimGame();


        //----------------------------------------------------------------------------
        */

        /*

        Notre IHM ne fonctionnant pas parfaitement, nous avons décidé de ne pas l'instancier, vous pouvez toutefois
        la tester en executant la classe game.ihm.graphic.interface



        */



    }
}
