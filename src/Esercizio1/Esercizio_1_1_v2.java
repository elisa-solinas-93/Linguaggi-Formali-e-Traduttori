/*
*   Il DFA implementato da questo programma riconosce il linguaggio 
*   delle stringhe formate dai simboli '0' e '1' che NON contengono 3 
*   zeri consecutivi.
*/

package Esercizio1;

import java.util.Scanner;

public class Esercizio_1_1_v2 {
    public static boolean scan (String s){
       int state = 0;
       int i = 0;
       while (state >= 0 && i < s.length()){
           char c = s.charAt(i++);
           switch(state){
               case 0:
                   if (c == '0')
                       state = 1;
                   else if (c == '1')
                       state = 0;
                   else
                       state = -1;
                   break;
               case 1:
                   if (c == '0')
                       state = 2;
                   else if (c == '1')
                       state = 0;
                   else
                       state = -1;
                   break;
               case 2:
                   if (c == '0')
                       state = 3;
                   else if (c == '1')
                       state = 0;
                   else
                       state = -1;
                   break;
               case 3:
                   if (c == '0' || c == '1')
                       state = 3;
                   else if (c == '1')
                       state = 0;
                   else
                       state = -1;
                   break;
           }
       }
       return (state != 3);
    }
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("LFT-LAB: Esercizio 1.1 versione 2");
        System.out.println("Stringhe che non contengono tre zeri consecutivi.");
        while (true){
            System.out.println("Inserire una stringa (per uscire digitare EXIT):");
            String s = key.nextLine();
            if (!s.equals("EXIT"))
                System.out.println(scan(s) ? "OK." : "NOPE.");
            else
                System.exit(0);
        }
    }
}
