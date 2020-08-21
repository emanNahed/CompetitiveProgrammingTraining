package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class CurrencySystemInGeraldion {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        for(int i= 0; i< n; i++)
            if(scan.nextInt() == 1) {
                System.out.println(-1); return;
            }

        System.out.println(1);
    }
}
