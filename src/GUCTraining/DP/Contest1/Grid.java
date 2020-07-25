package GUCTraining.DP.Contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Grid {


    private static final BufferedReader scan= new BufferedReader(new InputStreamReader(System.in));
    static char [][] arr;
    static StringBuilder sb;
    static long[][] dp;

    public static void main(String [] args) throws IOException {
        String [] nm= scan.readLine().split(" ");

        int n= Integer.parseInt(nm[0]);
        int m= Integer.parseInt(nm[1]);

        arr= new char[n][m];

        for(int i= 0; i< n; i++){
            String  rItem= scan.readLine();
            for(int j= 0; j< m; j++){
                arr[i][j]= rItem.charAt(j);
            }
        }

        dp= new long[n][m];
        for(long[] longs: dp) Arrays.fill(longs, -1);
        System.out.println(countPath(0, 0));
    }

    private static long countPath(int rIdx, int cIdx) {
        if(rIdx == arr.length || cIdx == arr[0].length || arr[rIdx][cIdx] == '#')
            return 0;

        if(rIdx == arr.length - 1 && cIdx == arr[0].length - 1)
            return 1;

        if(dp[rIdx][cIdx] != -1)
            return dp[rIdx][cIdx];

        long right= countPath(rIdx, cIdx + 1);
        long down= countPath(rIdx + 1, cIdx);

        return dp[rIdx][cIdx]= (right + down) % (long)(Math.pow(10, 9) + 7) ;
    }
}
