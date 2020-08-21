package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class CheapTravel {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();
        int m= scan.nextInt();
        int a= scan.nextInt();
        int b= scan.nextInt();

        if(n < m) m = n;
            System.out.println(Math.min(b * (n / m) +Math.min(a * (n % m), b), a * n));

    }
}
