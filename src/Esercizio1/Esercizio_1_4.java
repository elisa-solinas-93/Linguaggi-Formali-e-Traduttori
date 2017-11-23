/*
*   Il DFA implementato da questo programma e' una modifica all'automa 
*   dell'esercizio precedente in modo che riconosca le combinazioni di matricole 
*   e cognomi di studenti del T2 o del T3, dove il numero di matricola e il 
*   cognome possono essere separati da una sequenza di spazi e possono essere 
*   precedute e/o seguite da sequenze eventualmente vuote di spazi.
*   Per questo esercizio, i cognomi composti (con un numero arbitrario di parti)
*   possono essere accettati.
*/

package Esercizio1;

import java.util.Scanner;
import java.lang.Character;

public class Esercizio_1_4 {
    public static boolean scan (String s){
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()){
            char c = s.charAt(i++);
            if (!(Character.isLetterOrDigit(c) || c == ' '))
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
                    else if (Character.isLetter(c)){
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
                    else if (Character.isLetter(c)){
                        if (c >= 'L' && c <= 'Z')
                            state = 3;
                        else
                            state = -1;
                    }
                    break;
                case 3:
                    if (!(Character.isLetter(c) || c == ' '))
                        state = -1;
            }
        }
        return (state == 3);
    }
    public static void main (String[] args){
        Scanner key = new Scanner(System.in);
        System.out.println("LFT-LAB: Esercizio 1.4");
        System.out.println("Matricole del turno T2 o T3 con spazi");
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
