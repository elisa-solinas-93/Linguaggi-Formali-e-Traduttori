/*
*   Il DFA implementato da questo programma e' una modifica all'automa 
*   dell'esercizio precedente in modo che ci sia la possibilità di avere 
*   stringhe prima e dopo.
*   L'idea e' che sia possibile avere eventualmente commenti (anche multipli)
*   immersi in una sequenza di simboli dell'alfabeto.
*/
package Esercizio1;

import java.lang.Character;
import java.util.Scanner;

public class Esercizio_1_8 {
    public static boolean scan (String s){
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()){
            char c = s.charAt(i++);
            switch (state){
                case 0:
                    if (c == '/')
                        state = 1;
                    else if (c == 'a' || c == '*')
                        state = 0;
                    else
                        state = -1;
                    break;
                case 1:
                    if (c == 'a')
                        state = 0;
                    else if (c == '/')
                        state = 1;
                    else if (c ==  '*')
                        state = 2;
                    else 
                        state = -1;
                    break;
                case 2:
                    if (c == 'a' || c == '/')
                        state = 2;
                    else if (c == '*')
                        state = 3;
                    else 
                        state = -1;
                    break;
                case 3:
                    if (c == 'a')
                        state = 2;
                    else if (c == '*')
                        state = 3;
                    else if (c ==  '/')
                        state = 0;
                    else 
                        state = -1;
                    break;
            }
        }
        return (state == 0);
    }
    public static void main (String[] args){
        Scanner key = new Scanner(System.in);
        System.out.println("LFT-LAB: Esercizio 1.8");
        System.out.println("Commenti multipli");
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
