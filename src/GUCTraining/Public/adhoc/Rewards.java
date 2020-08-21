package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class Rewards {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int sumCubs= scan.nextInt() + scan.nextInt()+ scan.nextInt();
        int sumMedals= scan.nextInt() + scan.nextInt() + scan.nextInt();

        int n= scan.nextInt();

        int test= sumCubs / 5 + (sumCubs % 5 == 0? 0: 1) + sumMedals / 10 + (sumMedals % 10 == 0? 0 : 1);
        if(test <= n)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
