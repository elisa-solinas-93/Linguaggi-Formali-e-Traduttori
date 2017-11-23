/*
*   Il DFA implementato da questo programma riconosce il linguaggio delle
*   stringhe composte da numeri binari il cui valore e' multiplo di 3.
*
*   SUGGERIMENTO: usare tre stati per rappresentare il resto della divisione
*   per 3 del numero.
*/

package Esercizio1;

import java.lang.Character;
import java.util.Scanner;

public class Esercizio_1_6 {
    public static boolean scan (String s){
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()){
            char c = s.charAt(i++);
            switch (state){
                case 0:
                    if (c == '1')
                        state = 1;
                    else if (c == '0')
                        state = 0;
                    else
                        state = -1;
                    break;
                case 1:
                    if (c == '1')
                        state = 0;
                    else if (c == '0')
                        state = 2;
                    else
                        state = -1;
                    break;
                case 2:
                    if (c == '1')
                        state = 2;
                    else if (c == '0')
                        state = 1;
                    else
                        state = -1;
                    break;
            }
        }
        return (state == 0);
    }
    public static void main (String[] args){
        Scanner key = new Scanner(System.in);
        System.out.println("LFT-LAB: Esercizio 1.6");
        System.out.println("Binari divisibili per 3");
        while (true){
            System.out.println("Inserire una stringa (per uscire digitare EXIT):");
            String s = key.nextLine();
            if (!s.equals("EXIT"))
                System.out.println("String " + s + ": " + (scan(s) ? "OK." : "NOPE."));
            else
                System.exit(0);
        }
    }
}
