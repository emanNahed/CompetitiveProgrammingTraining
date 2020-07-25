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

        dp = new long[n][1 << m + 1];
        for (long[] ints : dp) Arrays.fill(ints, -1);


        System.out.println(maxCost(0, 1, 1, m));

    }

    private static long maxCost(int node, int idx, int mask, int m) {
        if (mask == m) //visit all nodes
            return dishes[node];
        if (idx == arr.length) return 0;


        if(mask > m) return Long.MIN_VALUE;

        long take = arr[node][idx] + dishes[node] + maxCost(idx, idx + 1, mask + 1, m);
        long leave = maxCost(node, idx + 1, mask, m);


        return Math.max(take, leave);
    }

    private static int setMask(int mask, int i) {
        return (mask | (1 << i));
    }


    private static boolean checkMask(int mask, int i) {
        return (mask & (1 << i)) == 0;
    }

}
