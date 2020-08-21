package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class BachgoldProblem {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        int count = n / 2;
        System.out.println(count);

        count +=  (n % 2 != 0? -1: 0);
        while (count-- != 0)
            System.out.print(2 + " ");

        if(n % 2 != 0) System.out.println(3);
        else System.out.println();
    }
}
