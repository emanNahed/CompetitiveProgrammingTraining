package CodeForces.Level_A;

import java.util.HashSet;
import java.util.Scanner;

public class AntonAndLetters {

    private static Scanner input= new Scanner(System.in);


    public static void main(String [] args){
        HashSet<Character> hs= new HashSet<>();

        String str= input.nextLine();

        for(int i= 0; i< str.length(); i++){
            if(str.charAt(i) != ',' && str.charAt(i) != ' '){
                hs.add(str.charAt(i));
            }
        }

        System.out.println(hs.size() - 2 /* for brackets; */);
    }
}
