package Lottosimulation;

import java.util.Random;

public class lottozahlerstellen {

    int zahl;
    int superzahl;
    Random rand = new Random();


        public int getZahl() {
                
        return this.zahl = rand.nextInt(49)+1 ;   
    }
        public int getSuperzahl(){
            return this.superzahl = rand.nextInt(10);
        }

}
