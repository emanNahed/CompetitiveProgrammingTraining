package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;

import java.io.IOException;
import java.util.*;

public class NutsForNuts {

   static SScanner scan= new SScanner(System.in);
    static int[][] weight;
    static int valBase;
    static int [][] dp;

    public static void main(String[] args) throws IOException, InterruptedException {
        //Thread.sleep(1000);
        while (scan.ready()) {
            String[] nm = scan.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            char[][] arr = new char[n][m];
            int count = 0;
            Hashtable<Integer, Index> hs = new Hashtable<>();
            for (int i = 0; i < n; i++) {
                String item = scan.nextLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = item.charAt(j);
                    if (arr[i][j] == 'L' || arr[i][j] == '#') {
                        hs.putIfAbsent(count, new Index(i, j, count));
                        valBase = arr[i][j] == 'L' ? count : valBase;
                        count++;
                    }
                }
            }

            weight = new int[count][count];
            for (int[] ints : weight) Arrays.fill(ints, Integer.MAX_VALUE);

            for (Index nuts1 : hs.values()) {
                for (Index nuts2 : hs.values()) {
                    weight[nuts1.val][nuts2.val] = Math.min(weight[nuts1.val][nuts2.val], distance(nuts1, nuts2));
                }
            }
            // i try to solve it by loop in min element in each row start from valBase, but it was wrong,
            //counter example assume that the min element in r(valBase)= {1,1}, in second row we have this
            // {9,1,10,7} now the min one is 10 why becuar we visit the index one and can't take it's value...

            dp= new int[weight.length][(1 << weight.length)];
            for(int[] ints: dp) Arrays.fill(ints, -1);
            System.out.println(minPath(valBase, 1 << valBase));
        }
    }



    static int minPath(int val, int mask){
        if(mask == (1 << weight.length)- 1)  return weight[val][valBase];
        if(dp[val][mask] != -1) return dp[val][mask];

        int min=  Integer.MAX_VALUE;
        for(int i= 0; i< weight.length; i++){
            if((mask & (1 << i)) == 0){
                min= Math.min(min, weight[val][i] + minPath(i, (mask | (1 << i)) ));
            }
        }

        return dp[val][mask]=  min;
    }

    private static int distance(Index nuts1, Index nuts2) {
        return Math.abs(nuts1.r - nuts2.r) + Math.abs(nuts2.c - nuts1.c)
                - Math.min(Math.abs(nuts1.r - nuts2.r) , Math.abs(nuts2.c - nuts1.c));
    }


    static class Index{
        int r;
        int c;
        int val;

        Index(int r, int c, int val){
            this.r= r;
            this.c= c;
            this.val= val;
        }
    }
}
