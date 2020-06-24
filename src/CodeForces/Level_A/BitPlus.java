package CodeForces.Level_A;

import java.util.Scanner;

public class BitPlus {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        int initial = 0;
        while(n != 0){
            String str= input.next();
            if(str.charAt(1) == '+'){
                initial++;
            }
            else{
                initial--;
            }
            n--;
        }

        System.out.println(initial);
    }
}
