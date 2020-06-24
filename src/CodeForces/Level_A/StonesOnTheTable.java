package CodeForces.Level_A;

import java.util.Scanner;

public class StonesOnTheTable {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        String str= input.next();

        int current= 0;
        int walk = current+1;
        int count = 0;
        while(current < n){
            while(walk < n && str.charAt(current) == str.charAt(walk)){
                walk++;
                count++;
            }

            current= walk;
            walk++;
        }
        System.out.println(count);
    }
}
