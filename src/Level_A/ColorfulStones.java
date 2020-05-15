package Level_A;

import java.util.Scanner;

public class ColorfulStones {


    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        String s= input.next();

        String t= input.next();

        int index= 0;

        for(int i= 0; i< t.length(); i++){
            if(index < s.length() - 1 && t.charAt(i) == s.charAt(index)){
                index++;
            }
        }

        System.out.println(index + 1);
    }
}
