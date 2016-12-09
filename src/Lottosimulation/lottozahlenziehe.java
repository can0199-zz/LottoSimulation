package Lottosimulation;

import java.util.Arrays;

/**
 *
 * @author ckara
 */
public class lottozahlenziehe {

    public static int doppelteZahlNr;
    lottozahlerstellen z = new lottozahlerstellen();
    int[] lottozahlen = new int[6];
    static int indexdoppelt;
    int superzahl;

    //Hier wird in einem Array 6 Zuffalszahlen gespeichert und überprüft ob doppelte vorhanden sind wenn ja wird die doppelte Zahl durch eine neue Zuffalszahl ersetzt
    public int[] ziehe() {
        for (int i = 0; i < 6; i++) {
            lottozahlen[i] = z.getZahl();
        }
        while (pruefe(lottozahlen) == true) {
            ersetze(indexdoppelt, lottozahlen);
        }
        int cache = 0;
        //dieser Schritt ist da um die Zuffalszahlen die geordnet waren wieder zu verwirren
        cache = lottozahlen[0];
        lottozahlen[0] = lottozahlen[1];
        lottozahlen[1] = cache;
        cache = lottozahlen[4];
        lottozahlen[4] = lottozahlen[3];
        lottozahlen[3] = cache;
        cache = lottozahlen[2];
        lottozahlen[2] = lottozahlen[5];
        lottozahlen[5] = cache;
        return lottozahlen;
    }
    //hier wird die zuffalszahl gezogen und übergeben
    public int ziehesuperzahl(){
        this.superzahl = z.getSuperzahl();
        return superzahl;
    }
    //diese Funktion überprüft ein Array das übergeben wird ob es gleiche werte hat und liefert ein boolean wert zurück
    public static boolean pruefe(int[] array) {
        Arrays.sort(array);
        boolean doppelt = false;
        for (int i = 5; i > 0; i--) {
            if (array[i] == array[i - 1]) {
                doppelt = true;
                indexdoppelt = i;
            }
        }
        return doppelt;
    }
    //diese Funktion ersetzt dann die Zahl die doppelt ist 
    public void ersetze(int index, int[] array) {
        lottozahlerstellen zz = new lottozahlerstellen();
        array[index] = zz.getZahl();
    }

}
