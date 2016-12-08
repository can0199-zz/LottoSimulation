package Lottosimulation;

import java.util.Scanner;

public class LottoSimulation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lottozahlenziehe lottozahlen = new lottozahlenziehe();
        int superzahl = lottozahlen.ziehesuperzahl();
        int playersuperzahl;
        boolean superzahlprüfung;
        int[] zahlen = lottozahlen.ziehe();
        int[] auswahlplayer = new int[6];
        int[] vergleich;

        wilkbanner();
        //Superzahl kann man sich selber ausssuchen da man ja auch im echten Lotto sich den Scheni aussuchen kann und sozusagen sich somit auch die Superzahl aussucht
        playersuperzahl = playereingabe(sc, auswahlplayer, lottozahlen);
        vergleich = überprüfen(auswahlplayer, zahlen);
        superzahlprüfung = superzahlprüfen(playersuperzahl, superzahl);
        gewinnausschüttung(vergleich, superzahlprüfung);
        System.out.println("\nDie Lottozahlen und deine getippten Zahlen werden jetzt neben einander ausgegeben\nlinks sind die Lottozahlen deine sind die rechten Zahlen");
        beidenebeneinander(zahlen, auswahlplayer, superzahl, playersuperzahl);       
        System.out.println("\nAuswertung:");
        if (vergleich[6] != 0) {
            System.out.println("Deine richtig erratenen Lottozahlen sind: ");
            for (int i = 0; i < 6; i++) {
                if (vergleich[i] != -1) {
                    System.out.println(zahlen[vergleich[i]]);
                }
            }
        }else{
            System.out.println("Du hast leider keine einzige Lottozahl richtig erraten");
        }
        
        if (superzahlprüfung == true) {
            System.out.println("die Superzahl hast du richtig erraten: " + superzahl);
        }else{
            System.out.println("die Superzahl hast du leider nicht richtig erraten");
        }

    }

    static void gewinnausschüttung(int[] vergleich, boolean superzahlprüfung) {

        if (vergleich[6] <= 2) {
            gewinnklassen(0, vergleich, superzahlprüfung);
        } else if (vergleich[6] == 2 & superzahlprüfung == true) {
            gewinnklassen(9, vergleich, superzahlprüfung);
        } else if (vergleich[6] == 3 & superzahlprüfung == false) {
            gewinnklassen(8, vergleich, superzahlprüfung);
        } else if (vergleich[6] == 3 & superzahlprüfung == true) {
            gewinnklassen(7, vergleich, superzahlprüfung);
        } else if (vergleich[6] == 4 & superzahlprüfung == false) {
            gewinnklassen(6, vergleich, superzahlprüfung);
        } else if (vergleich[6] == 4 & superzahlprüfung == true) {
            gewinnklassen(5, vergleich, superzahlprüfung);
        } else if (vergleich[6] == 5 & superzahlprüfung == false) {
            gewinnklassen(4, vergleich, superzahlprüfung);
        } else if (vergleich[6] == 5 & superzahlprüfung == true) {
            gewinnklassen(3, vergleich, superzahlprüfung);
        } else if (vergleich[6] == 6 & superzahlprüfung == false) {
            gewinnklassen(2, vergleich, superzahlprüfung);
        } else if (vergleich[6] == 6 & superzahlprüfung == true) {
            gewinnklassen(1, vergleich, superzahlprüfung);
        }
    }

    static void gewinnklassen(int klasse, int[] vergleich, boolean superzahl) {
        System.out.println("\n");
        if (klasse == 9) {
            System.out.println("Herzlichen Glückwunsch!\nDu hast 2 Lottoahlen richtig erraten + die Superzahl ist auch richtig!");
        } else if (klasse == 8) {
            System.out.println("Herzlichen Glückwunsch!\nDu hast 3 Lottozahlen richtig erraten die Superzahl ist aber leider falsch!");
        } else if (klasse == 7) {
            System.out.println("Herzlichen Glückwunsch!\nDu hast 3 Lottozahlen  richtig erraten die + Superzahl ist auch richtig!");
        } else if (klasse == 6) {
            System.out.println("Herzlichen Glückwunsch!\nDu hast 4 Lottozahlen  richtig erraten die Superzahl ist aber leider falsch!");
        } else if (klasse == 5) {
            System.out.println("Herzlichen Glückwunsch!\nDu hast 4 Lottozahlen  richtig erraten die + Superzahl ist auch richtig!");
        } else if (klasse == 4) {
            System.out.println("Herzlichen Glückwunsch!\nDu hast 5 Lottozahlen  richtig erraten die Superzahl ist aber leider falsch!");
        } else if (klasse == 3) {
            System.out.println("Herzlichen Glückwunsch!\nDu hast 5 Lottozahlen  richtig erraten die + Superzahl ist auch richtig!");
        } else if (klasse == 2) {
            jackpotbanner();
            System.out.println("Herzlichen Glückwunsch!\nDu hast 6 Lottozahlen  richtig erraten die Superzahl ist aber leider falsch!");
        } else if (klasse == 1) {
            megajackpotbanner();
            System.out.println("\nHerzlichen Glückwunsch!\nDu hast alle Lottozahlen  und die Superzahl richtig erraten");
        } else if (klasse == 0) {
            if (vergleich[6] == 1 & superzahl == false) {
                System.out.println("\nDu hast: Eine Zahl richtig");
            } else {
                if (superzahl == true) {
                    if (vergleich[6] != 0) {

                        System.out.println("\nDu hast: " + vergleich[6] + " richtige und die Superzahl ist auch richtig");
                    } else {
                        System.out.println("\nDu hast: " + vergleich[6] + " richtige aber die Superzahl hast du richtig erraten");
                    }
                } else {                    
                    System.out.println("\nDu hast: " + vergleich[6] + " richtige die Superzahl hast du leider nicht erraten");
                    
                }
            }
            System.out.println("Du hast leider verloren!");
            System.out.println("Um mindestens 5€ zu gewinnen musst du 2 richtige und die Superzahl richtig haben");
        }
    }

    static int playereingabe(Scanner sc, int[] auswahlplayer, lottozahlenziehe lottozahlen) {
        int superzahl;
        int ii = 0;
        System.out.println("\nBitte wählen Sie 6 Zahlen zwischen 1 und 49 keine dürfen doppelt sein!\n");
        for (int i = 0; i < 6; i++) {

            do {
                System.out.println("Bitte wählen Sie ihre " + (i + 1) + ". Zahl");
                auswahlplayer[i] = sc.nextInt();
            } while (auswahlplayer[i] < 1 | auswahlplayer[i] > 49);

        }

        while (lottozahlen.prüfe(auswahlplayer) == true) {
            System.out.println("Sie haben mindestens 1 Zahl doppelt eingeben bitte berichtigen!");
            System.out.println("Folgende Zahle haben sie verwendet: ");
            arrayausgabe(auswahlplayer);
            System.out.println("Bitte geben sie jetzt eine neue Zahl ein");
            do {
                if (ii != 0) {
                    System.out.println("\nEs sind nur Zahlen zwischen 1 und 49 erlaubt\nAchten Sie auf die Zahlen die Sie schon eigegeben haben");
                }
                auswahlplayer[lottozahlen.indexdoppelt] = sc.nextInt();
                ii++;
            } while (auswahlplayer[lottozahlen.indexdoppelt] < 1 | auswahlplayer[lottozahlen.indexdoppelt] > 49);
            ii = 0;
        }
        System.out.println("\nBitte geben Sie ihre Superzahl ein\nErlaubt sind Zahlen zwischen 0 und 9");
        do {
            if (ii != 0) {
                System.out.println("\nEs sind nur Zahlen zwischen 0 und 9 erlaubt!");
            }
            superzahl = sc.nextInt();
            ii++;
        } while (superzahl < 0 | superzahl > 9);

        sc.close();
        return superzahl;
    }

    static void arrayausgabe(int[] array) {
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (int i = 0; i < array.length; i++) {

            System.out.println("                                          " + (i + 1) + ". Lottozahl: " + array[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    static void arrayausgabesuper(int[] array, int superzahl) {
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (int i = 0; i < array.length; i++) {

            System.out.println("                                          " + (i + 1) + ". Lottozahl: " + array[i]);
        }
        System.out.println("                                             Superzahl: " + superzahl);
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    static void beidenebeneinander(int[] array, int[] playerarray, int superzahl, int playersuperzahl) {
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

    static int[] überprüfen(int[] player, int[] lotto) {
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

    static boolean superzahlprüfen(int playersuperzahl, int superzahl) {

        if (playersuperzahl == superzahl) {
            return true;
        }
        return false;
    }

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
