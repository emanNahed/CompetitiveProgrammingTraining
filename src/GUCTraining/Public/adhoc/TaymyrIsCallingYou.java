package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class TaymyrIsCallingYou {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();
        int m= scan.nextInt();
        int z= scan.nextInt();


        int count = 0;
        for (int i= Math.min(n,m); i<= z; i++)
            if(i % n== 0 && i % m == 0) count++;

        System.out.println(count);
    }
}
