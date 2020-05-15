package Level_A;

import java.util.Scanner;

public class WordCapitalization {


    private static Scanner input= new Scanner(System.in);
    public static void main(String [] args){
        String str= input.next();

        str= str.replaceFirst(str.charAt(0) + "",Character.toUpperCase(str.charAt(0))+"");

        System.out.println(str);
    }
}
