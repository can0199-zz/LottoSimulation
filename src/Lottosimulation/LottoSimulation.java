package Lottosimulation;

import java.util.Scanner;

public class LottoSimulation {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        functions.wilkbanner();
        System.out.println("Bitte wählen Sie:\n1 Selber spielen\n2 Lottospiel simullieren bis zum Gewinn mit statischen Playerzahlen");

        int auswahl = sc.nextInt();
        sc.reset();

        if (auswahl == 1) {
            int nocheinmal = 0;
            do {
                play_manually();
                System.out.println("\n\nWollen Sie noch ein Spiel spielen?\nJa(1) oder Nein(2)");
                nocheinmal = sc.nextInt();
            } while (nocheinmal == 1);
        } else if (auswahl == 2) {
            play_static_player_numbers();
        }
        functions.ExitBanner();

    }

    static void play_manually() {
        Scanner sc = new Scanner(System.in);
        lottozahlenziehe lottozahlen = new lottozahlenziehe();
        int superzahl = lottozahlen.ziehesuperzahl();
        int playersuperzahl;
        boolean superzahlpruefung;
        //die Lottozahlen werden "gezogen"
        int[] zahlen = lottozahlen.ziehe();
        int[] auswahlplayer = new int[6];
        int[] vergleich;

        //Superzahl kann man sich selber ausssuchen da man ja auch im echten Lotto sich den Scheni aussuchen kann und sozusagen sich somit auch die Superzahl aussucht
        //die Funktion zur eingabe der Tipps wird aufgerufen
        //und die Superzahl wird in playersuperzahl gespeichert
        playersuperzahl = functions.playereingabe(sc, auswahlplayer);

        //hier wird das ergebniss von den tipp ohne superzahl ermittelt und in dem Array vergleich gespeichert
        vergleich = functions.ueberpruefen(auswahlplayer, zahlen);

        //hier wird die superzahl überprüft und in ner boolean gespeichert
        superzahlpruefung = functions.superzahlpruefen(playersuperzahl, superzahl);

        //diese funktion guckt nach ob und wenn was man gewonnen hat
        functions.gewinnausschuettung(vergleich, superzahlpruefung);

        //hier wird dann alles ausgeben ob man gewonnen hat, wieviele zahlen richtig waren und wenn welche richtg erraten wurden
        System.out.println("\nDie Lottozahlen und deine getippten Zahlen werden jetzt neben einander ausgegeben\nlinks sind die Lottozahlen deine sind die rechten Zahlen");
        functions.beidenebeneinander(zahlen, auswahlplayer, superzahl, playersuperzahl);
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

    }

    static void play_static_player_numbers() throws Exception {
        System.out.println("das Ergebniss wird analysiert\n");
        lottozahlenziehe lottozahlen = new lottozahlenziehe();
        int[] playerzahl = new int[6];
//        boolean srichtige = false;
//        int durchgaenge = 0;
//        int richtige = 0;
        playerzahl[0] = 15;
        playerzahl[1] = 10;
        playerzahl[2] = 25;
        playerzahl[3] = 27;
        playerzahl[4] = 34;
        playerzahl[5] = 49;

        for (int i = 0; i < 10; i++) {
            boolean srichtige = false;
            int durchgaenge = 0;
            int richtige = 0;
            while (srichtige == false) {
                richtige = 0;
                int[] lotto = lottozahlen.ziehe();
                for (int c = 0; c < 6; c++) {
                    for (int j = 0; j < 6; j++) {
                        if (playerzahl[c] == lotto[j]) {
                            richtige++;
                            break;
                        }
                    }
                }
                if (richtige == 6) {
                    srichtige = true;
                }
                durchgaenge++;
            }
            String file = "statischeplayerzahl_dynamischelottozahl.txt";
            String msg = "" + durchgaenge;
            functions.schreibe(file, msg);
        }

    }
}
