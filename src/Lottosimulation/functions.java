/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lottosimulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Can
 */
public class functions {

    static void gewinnausschuettung(int[] vergleich, boolean superzahlpruefung) {
        //in der funktion überprüfen wurde ja ein array erstellt und auf dem 6 platz wurde gespeichert wieviele zahlen richtig erraten wurden
        //hier wird nun die jeweilige gewinnklasse ermittelt und dann die Funktion "gewinnklassen" mit den entsprechenden Parametern aufgerufen
        if (vergleich[6] <= 2) {
            gewinnklassen(0, vergleich, superzahlpruefung);
        } else if (vergleich[6] == 2 & superzahlpruefung == true) {
            gewinnklassen(9, vergleich, superzahlpruefung);
        } else if (vergleich[6] == 3 & superzahlpruefung == false) {
            gewinnklassen(8, vergleich, superzahlpruefung);
        } else if (vergleich[6] == 3 & superzahlpruefung == true) {
            gewinnklassen(7, vergleich, superzahlpruefung);
        } else if (vergleich[6] == 4 & superzahlpruefung == false) {
            gewinnklassen(6, vergleich, superzahlpruefung);
        } else if (vergleich[6] == 4 & superzahlpruefung == true) {
            gewinnklassen(5, vergleich, superzahlpruefung);
        } else if (vergleich[6] == 5 & superzahlpruefung == false) {
            gewinnklassen(4, vergleich, superzahlpruefung);
        } else if (vergleich[6] == 5 & superzahlpruefung == true) {
            gewinnklassen(3, vergleich, superzahlpruefung);
        } else if (vergleich[6] == 6 & superzahlpruefung == false) {
            gewinnklassen(2, vergleich, superzahlpruefung);
        } else if (vergleich[6] == 6 & superzahlpruefung == true) {
            gewinnklassen(1, vergleich, superzahlpruefung);
        }
    }

    static void gewinnklassen(int klasse, int[] vergleich, boolean superzahl) {
        //diese klasse gibt den Spieler dann rückmeldung ob und wieviele Zahlen er richtig erraten hat 
        //die Funktion baut auf der Funktion "gewinnauschuettung auf"
        System.out.println("\n");
        if (klasse == 9) {
            System.out.println("Herzlichen Glueckwunsch!\nDu hast 2 Lottoahlen richtig erraten + die Superzahl ist auch richtig!");
        } else if (klasse == 8) {
            System.out.println("Herzlichen Glueckwunsch!\nDu hast 3 Lottozahlen richtig erraten die Superzahl ist aber leider falsch!");
        } else if (klasse == 7) {
            System.out.println("Herzlichen Glueckwunsch!\nDu hast 3 Lottozahlen  richtig erraten die + Superzahl ist auch richtig!");
        } else if (klasse == 6) {
            System.out.println("Herzlichen Glueckwunsch!\nDu hast 4 Lottozahlen  richtig erraten die Superzahl ist aber leider falsch!");
        } else if (klasse == 5) {
            System.out.println("Herzlichen Glueckwunsch!\nDu hast 4 Lottozahlen  richtig erraten die + Superzahl ist auch richtig!");
        } else if (klasse == 4) {
            System.out.println("Herzlichen Glueckwunsch!\nDu hast 5 Lottozahlen  richtig erraten die Superzahl ist aber leider falsch!");
        } else if (klasse == 3) {
            System.out.println("Herzlichen Glueckwunsch!\nDu hast 5 Lottozahlen  richtig erraten die + Superzahl ist auch richtig!");
        } else if (klasse == 2) {
            jackpotbanner();
            System.out.println("Herzlichen Glueckwunsch!\nDu hast 6 Lottozahlen  richtig erraten die Superzahl ist aber leider falsch!");
        } else if (klasse == 1) {
            megajackpotbanner();
            System.out.println("\nHerzlichen Glueckwunsch!\nDu hast alle Lottozahlen  und die Superzahl richtig erraten");
        } else if (klasse == 0) {
            if (vergleich[6] == 1 & superzahl == false) {
                System.out.println("\nDu hast: Eine Zahl richtig");
            } else if (superzahl == true) {
                if (vergleich[6] != 0) {

                    System.out.println("\nDu hast: " + vergleich[6] + " richtige und die Superzahl ist auch richtig");
                } else {
                    System.out.println("\nDu hast: " + vergleich[6] + " richtige aber die Superzahl hast du richtig erraten");
                }
            } else {
                System.out.println("\nDu hast: " + vergleich[6] + " richtige die Superzahl hast du leider nicht erraten");

            }
            System.out.println("Du hast leider verloren!");
            System.out.println("Um mindestens 5€ zu gewinnen musst du 2 richtige und die Superzahl richtig haben");
        }
    }

    static int playereingabe(Scanner sc, int[] auswahlplayer) {
        int superzahl, cache;
        int ii = 0;
        System.out.println("\nBitte wählen Sie 6 Zahlen zwischen 1 und 49 keine duerfen doppelt sein!\n");
        //Hier werden die 6 Zahlen vom Player eingegeben
        for (int i = 0; i < 6; i++) {

            do {
                System.out.println("Bitte wählen Sie ihre " + (i + 1) + ". Zahl");
                auswahlplayer[i] = sc.nextInt();
            } while (auswahlplayer[i] < 1 | auswahlplayer[i] > 49);

        }
        //Hier wird ueberprueft ob zahlen doppelt vorhanden sind
        while (lottozahlenziehe.pruefe(auswahlplayer) == true) {
            System.out.println("Sie haben mindestens 1 Zahl doppelt eingeben bitte berichtigen!");
            System.out.println("Folgende Zahle haben sie verwendet: ");
            arrayausgabe(auswahlplayer);
            //wenn doppelte da sind wird hier jetzt ne neue eingegeben
            System.out.println("Bitte geben sie jetzt eine neue Zahl ein");
            do {
                if (ii != 0) {
                    System.out.println("\nEs sind nur Zahlen zwischen 1 und 49 erlaubt\nAchten Sie auf die Zahlen die Sie schon eigegeben haben");
                }
                auswahlplayer[lottozahlenziehe.indexdoppelt] = sc.nextInt();
                ii++;
            } while (auswahlplayer[lottozahlenziehe.indexdoppelt] < 1 | auswahlplayer[lottozahlenziehe.indexdoppelt] > 49);
            ii = 0;
        }
        cache = auswahlplayer[0];
        auswahlplayer[0] = auswahlplayer[1];
        auswahlplayer[1] = cache;
        cache = auswahlplayer[4];
        auswahlplayer[4] = auswahlplayer[3];
        auswahlplayer[3] = cache;
        cache = auswahlplayer[2];
        auswahlplayer[2] = auswahlplayer[5];
        auswahlplayer[5] = cache;
        //superzahl wird eingeben
        System.out.println("\nBitte geben Sie ihre Superzahl ein\nErlaubt sind Zahlen zwischen 0 und 9");
        do {
            if (ii != 0) {
                System.out.println("\nEs sind nur Zahlen zwischen 0 und 9 erlaubt!");
            }
            superzahl = sc.nextInt();
            ii++;
        } while (superzahl < 0 | superzahl > 9);

        sc.reset();
        return superzahl;
    }

    static void arrayausgabe(int[] array) {
        //die funktion ist da damit man nicht immer for schleifen erstellen muss um ein array auszugeben 
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (int i = 0; i < array.length; i++) {

            System.out.println("                                          " + (i + 1) + ". Lottozahl: " + array[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    static void beidenebeneinander(int[] array, int[] playerarray, int superzahl, int playersuperzahl) {
        //funktion um die lottozahlen und die player eingabe neben einander darzustellen
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 10) {
                System.out.println("                       " + (i + 1) + ". Lottozahl: " + array[i] + "  " + "             deine " + (i + 1) + ". Zahl: " + playerarray[i]);
            } else {
                System.out.println("                       " + (i + 1) + ". Lottozahl: " + array[i] + " " + "             deine " + (i + 1) + ". Zahl: " + playerarray[i]);
            }

        }
        System.out.println("                                Superzahl: " + superzahl + " deine Superzahl: " + playersuperzahl);
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    static int[] ueberpruefen(int[] player, int[] lotto) {
        //hier werden beide arrays auf einstimmungen überprüft
        int[] vergleich = new int[7];
        for (int i = 0; i < 6; i++) {
            vergleich[i] = -1;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (player[i] == lotto[j]) {
                    vergleich[i] = j;
                    vergleich[6]++;
                    break;
                }
            }
        }
        return vergleich;
    }

    static boolean superzahlpruefen(int playersuperzahl, int superzahl) {
        //die super zahl wird überprüft
        if (playersuperzahl == superzahl) {
            return true;
        }
        return false;
    }

//    static void schreibe(String file, String msg) throws Exception {
//        Writer fw = null;
//        try {
//            fw = new FileWriter(file, true);
//            fw.write(msg);
//            fw.append(System.getProperty("line.separator")); // e.g. "\n"
//            fw.flush();
//        } catch (IOException e) {
//            System.err.println("Konnte Datei nicht erstellen");
//        } finally {
//            if (fw != null) {
//                try {
//                    fw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

//    static void schreibeersetze(String file, String msg) throws Exception {
//        Writer fw = null;
//        try {
//            fw = new FileWriter(file);
//            fw.write(msg);
//            fw.flush();
//        } catch (IOException e) {
//            System.err.println("Konnte Datei nicht erstellen");
//        } finally {
//            if (fw != null) {
//                try {
//                    fw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

//    static Vector lese(String datName) {
//        Vector vec = new Vector();
//
//        File file = new File(datName);
//
//        if (!file.canRead() || !file.isFile()) {
//            System.exit(0);
//        }
//
//        BufferedReader in = null;
//        try {
//            in = new BufferedReader(new FileReader(datName));
//            String zeile = null;
//            while ((zeile = in.readLine()) != null) {
//                vec.add(zeile);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                }
//            }
//        }
//        return vec;
//    }
    //static int[] prüfe_schreibe(String file, int az, int[] playerzahl) throws Exception {
    static int[] prüfe( int az, int[] playerzahl,int wievielerichtig){
        lottozahlenziehe lottozahlen = new lottozahlenziehe();
        int[] vec = new int[az];
        for (int i = 0; i < az; i++) {
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
                if (richtige == wievielerichtig) {
                    srichtige = true;
                }
                durchgaenge++;
            }
            vec[i] = durchgaenge;

            //String msg = "" + durchgaenge;
            //schreibe(file, msg);
        }
        return vec;
    }

//    static int start() {
//        int numberofstarts = -1;
//        File file = new File("option.inf");
//
//        if (!file.canRead() || !file.isFile()) {
//            System.exit(0);
//        }
//
//        BufferedReader in = null;
//        try {
//            in = new BufferedReader(new FileReader("option.inf"));
//            String zeile = null;
//            while ((zeile = in.readLine()) != null) {
//                numberofstarts = Integer.parseInt(zeile);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                    return numberofstarts;
//                } catch (IOException e) {
//                }
//            }
//        }
//        return numberofstarts;
//    }

    static void wilkbanner() {
        System.out.println("      __      __.__.__  .__   __                                                               \n"
                + "     /  \\    /  \\__|  | |  | |  | ______   _____   _____   ____   ____   __________ __  _____  \n"
                + "     \\   \\/\\/   /  |  | |  | |  |/ /  _ \\ /     \\ /     \\_/ __ \\ /    \\  \\___   /  |  \\/     \\ \n"
                + "      \\        /|  |  |_|  |_|    <  <_> )  Y Y  \\  Y Y  \\  ___/|   |  \\  /    /|  |  /  Y Y  \\\n"
                + "       \\__/\\  / |__|____/____/__|_ \\____/|__|_|  /__|_|  /\\___  >___|  / /_____ \\____/|__|_|  /\n"
                + "            \\/                    \\/           \\/      \\/     \\/     \\/        \\/           \\/ \n"
                + "    .____           __    __          _________.__              .__          __                \n"
                + "    |    |    _____/  |__/  |_  ____ /   _____/|__| _____  __ __|  | _____ _/  |_  ___________ \n"
                + "    |    |   /  _ \\   __\\   __\\/  _ \\\\_____  \\ |  |/     \\|  |  \\  | \\__  \\\\   __\\/  _ \\_  __ \\\n"
                + "    |    |__(  <_> )  |  |  | (  <_> )        \\|  |  Y Y  \\  |  /  |__/ __ \\|  | (  <_> )  | \\/\n"
                + "    |_______ \\____/|__|  |__|  \\____/_______  /|__|__|_|  /____/|____(____  /__|  \\____/|__|   \n"
                + "            \\/                              \\/          \\/                \\/                   ");
    }

    static void jackpotbanner() {
        System.out.println("     ____.                 __                      __   \n"
                + "    |    |_____     ____  |  | ________    ____  _/  |_ \n"
                + "    |    |\\__  \\  _/ ___\\ |  |/ /\\____ \\  /  _ \\ \\   __\\\n"
                + "/\\__|    | / __ \\_\\  \\___ |    < |  |_> >(  <_> ) |  |  \n"
                + "\\________|(____  / \\___  >|__|_ \\|   __/  \\____/  |__|  \n"
                + "               \\/      \\/      \\/|__|                   ");
    }

    static void megajackpotbanner() {
        System.out.println("   _____                                 ____.   _____            __                      __   \n"
                + "  /     \\    ____     ____  _____       |    |  /  _  \\    ____  |  | ________    ____  _/  |_ \n"
                + " /  \\ /  \\ _/ __ \\   / ___\\ \\__  \\      |    | /  /_\\  \\ _/ ___\\ |  |/ /\\____ \\  /  _ \\ \\   __\\\n"
                + "/    Y    \\\\  ___/  / /_/  > / __ \\_/\\__|    |/    |    \\\\  \\___ |    < |  |_> >(  <_> ) |  |  \n"
                + "\\____|__  / \\___  > \\___  / (____  /\\________|\\____|__  / \\___  >|__|_ \\|   __/  \\____/  |__|  \n"
                + "        \\/      \\/ /_____/       \\/                   \\/      \\/      \\/|__|                  ");
    }

    static void ExitBanner() {
        System.out.println("_________________________________________________________");
        System.out.println("\n   Developed by Can Karadağ                            ");
        System.out.println("                             Copyright© by Can Karadağ   ");
        System.out.println("_________________________________________________________");
    }

}
