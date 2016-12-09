package Lottosimulation; 

import java.util.Random;

public class lottozahlerstellen {

    int zahl;
    int superzahl;
    Random rand = new Random();

        //eine Zuffalszahl zwischen 1 und 49 wird erstellt und übergeben
        public int getZahl() {
                
        return this.zahl = rand.nextInt(49)+1 ;   
    }
         //eine Zuffalszahl zwischen 0 und 9 wird erstellt und übergeben
        public int getSuperzahl(){
            return this.superzahl = rand.nextInt(10);
        }

}
