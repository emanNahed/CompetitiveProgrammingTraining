package GUCTraining.DP.Contest1;


import Reusable_Peices.SScanner;


import java.io.IOException;
import java.util.Arrays;

public class Knapsack {

    private static final SScanner scan= new SScanner(System.in);
    static int [] n;
    static int [] w;
    static StringBuilder sb;
    static long[][] dp;

    public static void main(String [] args) throws IOException {
        int N= scan.nextInt();
        int W= scan.nextInt();

        n= new int[N];
        w= new int[N];

        for(int i= 0; i< N; i++){
            w[i]= scan.nextInt();
            n[i]= scan.nextInt();
        }

        /*sb= new StringBuilder();
        trace(0, W);

        System.out.println(sb);*/

        dp= new long[N][W + 1];
        for (long[] longs : dp) Arrays.fill(longs, -1);

        System.out.println(dp(0, W));
        //System.out.println(buttomUpdp(0, W));

    }


    private static long buttomUpdp(int remw) {

        long [] tableVal= new long[remw + 1];
        //tableVal[0] = 0;
        for(int i= n.length - 1; i >= 0; i--){
            for(int j= remw ; j >= 0; j--){
                long leave = tableVal[j];
                long take= (j - w[i] < 0) ? Long.MIN_VALUE : n[i] + tableVal[j - w[i]];

                tableVal[j]= Math.max(leave, take);
            }
        }

        return tableVal[tableVal.length - 1];
    }

    private static long dp(int i, int remw) {
        if(remw < 0)
            return Long.MIN_VALUE;

        if(i == n.length || remw == 0)
            return 0;

        if(dp[i][remw] != -1)
            return dp[i][remw];

        long take= (long)n[i] + dp(i + 1, remw - w[i]);
        long leave= dp(i + 1, remw);

        return dp[i][remw] = Math.max(take, leave);
    }

    static void trace(int idx, int rWeight){
        if(idx == n.length)
            return;

        if(dp(idx, rWeight) !=  dp(idx + 1, rWeight)) {
            sb.append(idx).append(" ").append(rWeight).append("\n");
            trace(idx + 1, rWeight - w[idx]);
        }
        else
            trace(idx + 1, rWeight);
    }

}



