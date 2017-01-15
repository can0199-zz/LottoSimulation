package Lottosimulation;

import java.util.Scanner;

public class LottoSimulation_main_play {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lottozahlenziehe lottozahlen = new lottozahlenziehe();
        int superzahl = lottozahlen.ziehesuperzahl();
        int playersuperzahl;
        boolean superzahlpruefung;
        //die Lottozahlen werden "gezogen"
        int[] zahlen = lottozahlen.ziehe();
        int[] auswahlplayer = new int[6];
        int[] vergleich;

        auswertung.wilkbanner();

        //Superzahl kann man sich selber ausssuchen da man ja auch im echten Lotto sich den Scheni aussuchen kann und sozusagen sich somit auch die Superzahl aussucht
        //die Funktion zur eingabe der Tipps wird aufgerufen
        //und die Superzahl wird in playersuperzahl gespeichert
        playersuperzahl = auswertung.playereingabe(sc, auswahlplayer);

        //hier wird das ergebniss von den tipp ohne superzahl ermittelt und in dem Array vergleich gespeichert
        vergleich = auswertung.ueberpruefen(auswahlplayer, zahlen);

        //hier wird die superzahl überprüft und in ner boolean gespeichert
        superzahlpruefung = auswertung.superzahlpruefen(playersuperzahl, superzahl);

        //diese funktion guckt nach ob und wenn was man gewonnen hat
        auswertung.gewinnausschuettung(vergleich, superzahlpruefung);

        //hier wird dann alles ausgeben ob man gewonnen hat, wieviele zahlen richtig waren und wenn welche richtg erraten wurden
        System.out.println("\nDie Lottozahlen und deine getippten Zahlen werden jetzt neben einander ausgegeben\nlinks sind die Lottozahlen deine sind die rechten Zahlen");
        auswertung.beidenebeneinander(zahlen, auswahlplayer, superzahl, playersuperzahl);
        System.out.println("\nAuswertung:");
        if (vergleich[6] != 0) {
            System.out.println("Deine richtig erratenen Lottozahlen sind: ");
            for (int i = 0; i < 6; i++) {
                if (vergleich[i] != -1) {
                    System.out.println(zahlen[vergleich[i]]);
                }
            }
        } else {
            System.out.println("Du hast leider keine einzige Lottozahl richtig erraten");
        }

        if (superzahlpruefung == true) {
            System.out.println("die Superzahl hast du richtig erraten: " + superzahl);
        } else {
            System.out.println("die Superzahl hast du leider nicht richtig erraten");
        }

        auswertung.ExitBanner();

    }
}
