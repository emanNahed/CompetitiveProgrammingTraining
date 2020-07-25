package GUCTraining.DP.Contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChestOfDrawers {


    private static final BufferedReader scan= new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int n;
    static int s;
    static long[][][] dp;

    public static void main(String [] args) throws IOException {
        String line;
        while(Integer.parseInt((line= scan.readLine()).split(" ")[0]) >= 0){
            String [] ns= line.split(" ");
            n= Integer.parseInt(ns[0]);
            s= Integer.parseInt(ns[1]);

            dp= new long[n][n][3];
            for(long[][] longs: dp)
                for(long []longs1: longs) Arrays.fill(longs1, -1);
            System.out.println(countSecure(0, 0,0));
        }
    }

    private static long countSecure(int idx, int countSecure, int previous) {
        if(idx == n)
            return (countSecure == s)? 1: 0;

        if(dp[idx][countSecure][previous] != -1)
            return dp[idx][countSecure][previous];


        long secure= countSecure(idx + 1, (previous != 2)? countSecure+ 1: countSecure, 1);
        long unSecure= countSecure(idx + 1, countSecure, 2);

        return dp[idx][countSecure][previous] = (secure + unSecure);
    }
}
