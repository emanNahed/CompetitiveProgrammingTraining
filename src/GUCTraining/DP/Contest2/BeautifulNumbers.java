package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;

import java.io.IOException;

public class BeautifulNumbers {

    static SScanner scan= new SScanner(System.in);
    public static void main(String [] args) throws IOException {
        int t= scan.nextInt();

        while (t-- != 0){
            int n= scan.nextInt();
            int m= scan.nextInt();

            System.out.println(numOfBeuty(n,m, 0));
        }
    }

    private static long numOfBeuty(int n, int m, int mask) {
        if(mask == 1 << n - 1) return 0;

        return 0;
    }
}
