package CodeForces.Level_A;

import java.util.Scanner;

public class Word {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        String word= input.next();
        int countLower= 0;
        for(int i= 0; i< word.length(); i++){
            if(Character.isLowerCase(word.charAt(i))){
                countLower++;
            }
        }


        int countUpper= word.length()- countLower;

        if(countUpper > countLower){
            System.out.println(word.toUpperCase());
        }
        else{
            System.out.println(word.toLowerCase());
        }
    }
}
