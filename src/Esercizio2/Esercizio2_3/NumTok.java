package Esercizio2.Esercizio2_3;

public class NumTok extends Token {
    public int value;
    public NumTok(String s) { 
        super(Tag.NUM); 
        value = Integer.parseInt(s); 
    }
    public String toString() { return "<" + tag + ", " + value + ">"; }
}