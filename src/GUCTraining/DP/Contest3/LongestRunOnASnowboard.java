package GUCTraining.DP.Contest3;

import Reusable_Peices.SScanner;

import java.io.IOException;
import java.util.*;

public class LongestRunOnASnowboard {

    private static Scanner scan= new Scanner(System.in);
    private static long [][] dp;
    private static int [][] weights;

    public static void main(String [] args) throws IOException, InterruptedException {
        int t= scan.nextInt();
        while (t-- != 0){
            String name= scan.next();

            int n= scan.nextInt();
            int m= scan.nextInt();

            weights= new int[n][m];
            for(int i= 0; i< n; i++)
                for(int j= 0; j< m; j++)
                    weights[i][j]= scan.nextInt();

            dp= new long[n][m];
            for(long [] longs: dp) Arrays.fill(longs, -1);

            long max= 0;

            for(int i= 0; i< n; i++)
                for(int j= 0; j< m; j++)
                    max = Math.max(max, longestPath(i, j) + 1);
            System.out.println(name + ": "+ max);
        }
    }

    private static long longestPath(int i, int j) {
        if(i < 0 || j < 0 || i >= weights.length || j >= weights[0].length)
            return 0;

        if(dp[i][j] != -1) return dp[i][j];

        long max= 0;
        max =i > 0 && weights[i - 1][j] < weights[i][j]? Math.max(max, 1 + longestPath(i - 1, j)): max;
        max =i < weights.length - 1 && weights[i + 1][j] < weights[i][j]? Math.max(max, 1 + longestPath(i + 1, j)): max;
        max =j > 0 && weights[i][j - 1] < weights[i][j]? Math.max(max, 1 + longestPath(i, j - 1)): max;
        max =j < weights[0].length - 1 && weights[i][j + 1] < weights[i][j]? Math.max(max, 1 + longestPath(i, j + 1)): max;

        return dp[i][j]=  max;
    }
}
