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
    int indexdoppelt;
    int superzahl;

    public int[] ziehe() {
        for (int i = 0; i < 6; i++) {
            lottozahlen[i] = z.getZahl();
        }
        while (prüfe(lottozahlen) == true) {
            ersetze(indexdoppelt, lottozahlen);
        }
        int cache = 0;
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
    public int ziehesuperzahl(){
        this.superzahl = z.getSuperzahl();
        return superzahl;
    }

    public boolean prüfe(int[] array) {
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

    public void ersetze(int index, int[] array) {
        lottozahlerstellen zz = new lottozahlerstellen();
        array[index] = zz.getZahl();
    }

}
