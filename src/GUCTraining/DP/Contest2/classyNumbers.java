package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;

import java.io.IOException;
import java.util.Arrays;

public class classyNumbers {

    static SScanner scan= new SScanner(System.in);
    static long [][][] dp;
    public static void main(String [] args) throws IOException {
        int t= scan.nextInt();
        while(t-- != 0){
            char [] a= String.valueOf(scan.nextLong() - 1).toCharArray();
            char [] b= String.valueOf(scan.nextLong()).toCharArray();

            dp= new long[b.length + 1][2][4];
            init(dp);
            long bAns= solve(b, 0, 1, 0);
            init(dp);
            long aAns= solve(a, 0, 1, 0);

            System.out.println(bAns - aAns);

        }
    }

    private static void init(long[][][] dp) {
        for(long [][] longs: dp)
            for(long [] longs1: longs)
                Arrays.fill(longs1, -1);
    }

    static long solve(char[] num, int idx, int flag, int nonZero){
        if(nonZero == 4)
            return 0;

        if(idx == num.length)
            return 1;

        if(dp[idx][flag][nonZero] != -1)
            return dp[idx][flag][nonZero];


        int end= flag == 1? num[idx] - '0': 9;

        long sum = 0;
        for(int i= 0 ; i<= end; i++)
            sum +=solve(num, idx + 1,
                    flag == 1 && i == end ? 1 : 0, i == 0? nonZero: nonZero + 1);

        return dp[idx][flag][nonZero]= sum;
    }
}