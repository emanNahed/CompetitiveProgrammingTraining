package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;

import java.io.IOException;
import java.util.Arrays;

public class OptimalArrayMultiplicationSequence {
    static SScanner scan= new SScanner(System.in);
    static int [][] arr;
    static long[][] dp;
    static StringBuilder sb;
    public static void main(String [] args) throws IOException, InterruptedException {
        int testCase= 1;
        int n;
        while ((n= scan.nextInt()) != 0){
            arr= new int[n][2];

            for(int i= 0; i< n; i++){
                int a= scan.nextInt();
                int b= scan.nextInt();

                arr[i][0]= a; arr[i][1]= b;
            }

            dp=new long[n + 1][n + 1];
            for(long [] longs: dp) Arrays.fill(longs, -1);
            System.out.println("Case " + testCase + ": "+ trace(0, n - 1));

            testCase++;
        }
    }

    static long minMylt(int i, int j){
        if(i >= j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        long min= Long.MAX_VALUE;
        for(int k= i; k < j; k++){
            min= Math.min(min, arr[i][0] * arr[j][1] *arr[k][1] + minMylt(i, k) + minMylt(k + 1, j));
        }


        return dp[i][j]= min;
    }

    static String trace(int i, int j){
        if(i == j) return "A" + (i+1);

        for(int k= i; k< j; k++) {
            if (minMylt(i, j) == arr[i][0] * arr[j][1] * arr[k][1] + minMylt(i, k) + minMylt(k + 1, j)){
                return String.format("(%s x %s)", trace(i, k), trace(k + 1, j));
        }
        }

        return null;
    }
}
