package GUCTraining.Public.adhoc;

import java.util.Arrays;
import java.util.Scanner;

public class Punctuation {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        String [] str= scan.nextLine().split("\\s+");

        for(int i= 0; i< str.length; i++) {
            str[i] = str[i].replace(",", ", ");
            str[i] = str[i].replace("?", "? ");
            str[i] = str[i].replace(".", ". ");
            str[i] = str[i].replace("!", "! ");

            if(i != 0 && checkString(str[i]) && str[i - 1].charAt(str[i- 1].length() - 1) != ' ')
                System.out.print(" ");


            System.out.print(str[i]);
        }

    }

    private static boolean checkString(String s) {
        return s.charAt(0) != '.' && s.charAt(0) != ','
                && s.charAt(0) != '?' && s.charAt(0) != '!'
                && s.charAt(s.length() - 1) != '?' && s.charAt(s.length() - 1) != '!'
                && s.charAt(s.length() - 1) != '.' && s.charAt(s.length() - 1) != ',';
    }
}
