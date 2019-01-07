package game.model.common.rules;

public class Main {


    public static void main(String[] args) {
        String currentName = "toto";
        String theLower = "albert";
        for (int y = 0; y < 4; y++) {
            if (currentName.charAt(y) < (theLower.charAt(y))) {
                System.out.println("c'est inférieur");
            } else {
                System.out.print("C'est supérieur");
            }
        }
    }

}