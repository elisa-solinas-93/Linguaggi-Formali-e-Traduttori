/*
*   Il DFA implementato da questo programma riconosce il linguaggio delle
*   stringhe formate dai simboli dell'alfabeto {/, *, a} che costituiscono
*   i commenti di un linguaggio simil-Java. 
*/

package Esercizio1;

import java.util.Scanner;
import java.lang.Character;

public class Esercizio_1_7 {
    public static boolean scan (String s){
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()){
            char c = s.charAt(i++);
            switch (state){
                case 0:
                     if (c == '/')
                        state = 1;
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
        System.out.println("LFT-LAB: Esercizio 1.7");
        System.out.println("Commenti singoli");
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
