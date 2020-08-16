package CodeForces.Level_B;

import java.util.*;
public class EasterEggs {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        char [] chars= {'R','O','Y','G','B','I','V'};

        int n= scan.nextInt();
        char [] output= new char[n];
        for(int i= 0; i< n; i++){
            if(i < 7) output[i] = chars[i];
            else output[i] = output[i - 4];
        }

        System.out.println(output);
    }
}
