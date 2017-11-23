/*
*   Il DFA implementato da questo programma riconosce il linguaggio delle
*   stringhe che contengono un numero di matricola seguito (subito) da un 
*   cognome, dove la combinazione di matricola e cognome corrisponde a 
*   studenti del turno T2 o T3 del laboratorio di LFT, ricordando che:
*       Turno 1: cognomi la cui iniziale è compresa tra A e K, 
            e il numero di matricola è dispari;
*       Turno 2: cognomi la cui iniziale è compresa tra A e K, 
            e il numero di matricola è pari;
*       Turno 3: cognomi la cui iniziale è compresa tra L e Z, 
            e il numero di matricola è dispari;
*       Turno 4: cognomi la cui iniziale è compresa tra L e Z, 
            e il numero di matricola è pari.
*   Un numero di matricola non ha un numero prestabilito di cifre (ma deve 
*   essere composto di almeno una cifra). Un cognome corrisponde a una 
*   sequenza di lettere, e deve essere composto di almeno una lettera.
*/
package Esercizio1;

import java.util.Scanner;
import java.lang.Character;

public class Esercizio_1_3 {
    public static boolean scan (String s){
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()){
            char c = s.charAt(i++);
            if (!Character.isLetterOrDigit(c))
                return false;
            switch(state){
                case 0:
                    if (Character.isDigit(c)){
                        if (Character.getNumericValue(c) % 2 == 0)
                            state = 1;
                        else
                            state = 2;
                    }
                    break;
                case 1:
                    if (Character.isDigit(c)){
                        if (Character.getNumericValue(c) % 2 == 0)
                            state = 1;
                        else
                            state = 2;
                    }
                    else{
                        if (c >= 'A' && c <= 'J')
                            state = 3;
                        else
                            state = -1;
                    }
                    break;
                case 2: 
                    if (Character.isDigit(c)){
                        if (Character.getNumericValue(c) % 2 == 0)
                            state = 1;
                        else
                            state = 2;
                    }
                    else{
                        if (c >= 'L' && c <= 'Z')
                            state = 3;
                        else
                            state = -1;
                    }
                    break;
                case 3:
                    if (!Character.isLetter(c))
                        state = -1;
            }
        }
        return (state == 3);
    }
    public static void main (String[] args){
        Scanner key = new Scanner(System.in);
        System.out.println("LFT-LAB: Esercizio 1.3");
        System.out.println("Matricole del turno T2 o T3");
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
