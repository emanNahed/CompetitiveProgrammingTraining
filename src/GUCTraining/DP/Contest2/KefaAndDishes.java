package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;

import java.io.IOException;
import java.util.Arrays;

public class KefaAndDishes {

    static SScanner scan = new SScanner(System.in);
    static long[][] arr;
    static int[] dishes;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();

        dishes = new int[n + 1];
        for (int i = 1; i <= n; i++)
            dishes[i] = scan.nextInt();

        arr = new long[n + 1][n + 1];
        for (long[] ints : arr) Arrays.fill(ints, 0);
        while (k-- != 0) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int c = scan.nextInt();

            arr[x][y] = c;
        }

        dp = new long[1 << (n + 1)][n + 1];
        for (long[] ints : dp) Arrays.fill(ints, -1);


        System.out.println(maxCost(0, 0, 1, m));
       // trace(0,0,1,m);
        //System.out.println(sb);

    }

    private static long maxCost(int node, int count, int mask, int m) {
        if(node == arr.length) return 0;

        if(count == m||mask == (1 << arr.length) - 1) return dishes[node];

        if(dp[node][mask] != -1) return dp[node][mask];


        long max= 0;
        for(int i= 0; i< arr.length; i++){
            if(checkMask(mask, i))
                max= Math.max(max, dishes[node] +arr[node][i] + maxCost(i, count+ 1, setMask(mask, i),m)); //take//leave
        }


        return dp[node][mask]= max;
    }

    private static int setMask(int mask, int i) {
        return (mask | (1 << i));
    }


    private static boolean checkMask(int mask, int i) {
        return (mask & (1 << i)) == 0;
    }

    static StringBuilder sb= new StringBuilder();
    static void trace(int node , int count, int mask, int m){
        if(node == arr.length) return;
        if(count == m || mask == (1 << arr.length) - 1) {
            sb.append(node).append( " ");
            return;
        }

        for(int i= 0; i< arr.length; i++) {
            if(checkMask(mask, i))
            if (maxCost(node, count, mask, m) == dishes[node] + arr[node][i] + maxCost(i, count + 1, setMask(mask, i), m)) {

                sb.append(i).append(" ");
                trace(i, count + 1, setMask(mask, i), m);
                break;
            }
        }

    }

}


