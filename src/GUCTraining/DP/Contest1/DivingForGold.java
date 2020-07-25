package GUCTraining.DP.Contest1;

import Reusable_Peices.SScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class DivingForGold {

    private static final SScanner scan= new SScanner(System.in);
    static int [] n;
    static int [] d;
    static StringBuilder sb;
    static long[][] dp= new long[32][1001];

    public static void main(String [] args) throws IOException, InterruptedException {
        String line;
        boolean one= false;
        Thread.sleep(1000); //this is an i/o problem :"(
            while (scan.ready()) {
                int t= scan.nextInt();
                int w= scan.nextInt();

                int treasures= scan.nextInt();
                n= new int[treasures];
                d= new int[treasures];

                for(int i= 0; i< treasures; i++){
                    int depth= scan.nextInt();
                    d[i] = w* depth + 2* w *depth;
                    n[i] = scan.nextInt();
                }


                for (long[] longs : dp) Arrays.fill(longs, -1);

                System.out.println(dp(0, t));

                sb= new StringBuilder();

                long count = trace(w, t);
                System.out.println(count);
                System.out.println(sb);

                if(scan.ready()) System.out.println();
            }
        }


    private static long trace(int w, int t) {
        long count= 0;
        for (int i = 0; i < n.length; i++) {
            if (dp(i, t) != dp(i + 1, t)){
                sb.append(d[i] / (w * 3)).append(" ").append(n[i]);
                if(i != n.length - 1) sb.append("\n");
                t -= d[i];
                count++;
            }
        }
        return count;
    }

    private static long dp(int i, int t) {
        if(t < 0)
            return Long.MIN_VALUE;

        if(i == n.length)
            return 0;

        if(dp[i][t] != -1)
            return dp[i][t];

        long take= n[i] + dp(i + 1, t- d[i]);
        long leave= dp(i + 1 , t);

        return dp[i][t]= Math.max(leave, take);
    }
}

