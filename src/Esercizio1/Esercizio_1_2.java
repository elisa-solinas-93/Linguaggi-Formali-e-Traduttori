/*
*   Il DFA implementato da questo programma riconosce il linguaggio 
*   degli identificatori in un linguaggio in stile Java: un 
*   identificatore e' una sequenza non vuota di lettere, numeri ed 
*   il simbolo di underscore ('_').
*   Le sequenze che fanno parte del linguaggio non possono, inoltre, 
*   cominciare con un numero e non possono essere composte soltanto 
*   dal simbolo '_'.
*/

package Esercizio1;

import java.lang.Character;
import java.util.Scanner;

public class Esercizio_1_2 {
    public static boolean scan (String s){
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()){
            char c = s.charAt(i++);
            if (i == 1 && (c == '_' || Character.isDigit(c)))
                state = -1;
            else if (Character.isLetterOrDigit(c) || c == '_')
                state = 1;
            else 
                state = -1;
        }
        return state > 0;
    }
    public static void main (String[] args){
        Scanner key = new Scanner(System.in);
        System.out.println("LFT-LAB: Esercizio 1.2");
        System.out.println("Identificatori");
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
