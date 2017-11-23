/*
*   Il DFA implementato da questo programma e' una modifica all'automa 
*   dell'esercizio precedente in modo che riconosca le combinazioni di matricole 
*   e cognomi di studenti del T2 o del T3, ma in cui il cognome precede il 
*   numero di matricola.
*/

package Esercizio1;

import java.lang.Character;
import java.util.Scanner;

public class Esercizio_1_5 {
    public static boolean scan (String s){
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()){
            char c = s.charAt(i++);
            if (!(Character.isLetterOrDigit(c) || c == ' '))
                return false;
            switch(state){
                case 0:
                    if (Character.isLetter(c)){
                        if (c >= 'A' && c <= 'J')
                            state = 1;
                        else
                            state = 2;
                    }
                    break;
                case 1:
                    if (Character.isDigit(c)){
                        if (Character.getNumericValue(c) % 2 == 0)
                            state = 3;
                        else
                            state = 4;
                    }
                    else if (c != ' ' && !(Character.isLetter(c))){
                        state = -1;
                        System.err.println("ERRORE.");
                    }
                    break;
                case 2: 
                    if (Character.isDigit(c)){
                        if (Character.getNumericValue(c) % 2 == 0)
                            state = 5;
                        else
                            state = 6;
                    }
                    else if (c != ' ' && !(Character.isLetter(c))){
                        state = -1;
                        System.err.println("ERRORE.");
                    }
                    break;
                case 3: //PARI
                    if (Character.isDigit(c)){
                        if (Character.getNumericValue(c) % 2 != 0)
                            state = 4;
                    }
                    else
                        state = -1;
                    break;
                case 4: //DISPARI
                    if (Character.isDigit(c)){
                        if (Character.getNumericValue(c) % 2 == 0)
                            state = 3;
                    }
                    else
                        state = -1;
                    break;
                case 5: //PARI
                    if (Character.isDigit(c)){
                        if (Character.getNumericValue(c) % 2 != 0)
                            state = 6;
                    }
                    else
                        state = -1;
                    break;
                case 6: //DISPARI
                    if (Character.isDigit(c)){
                        if (Character.getNumericValue(c) % 2 == 0)
                            state = 5;
                    }
                    else
                        state = -1;
                    break;
            }
        }
        return (state == 3 || state == 6);
    }
    public static void main (String[] args){
        Scanner key = new Scanner(System.in);
        System.out.println("LFT-LAB: Esercizio 1.5");
        System.out.println("Matricole del turno T2 o T3 con spazi invertite");
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
