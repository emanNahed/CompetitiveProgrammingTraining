package GUCTraining.DP.Contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Divisibility {

    private static final BufferedReader scan= new BufferedReader(new InputStreamReader(System.in));
    static int [] arr;
    static StringBuilder sb;
    static int[][] dp;

    public static void main(String [] args) throws IOException {
        int t= Integer.parseInt(scan.readLine());

        while (t-- != 0){
            String [] nk= scan.readLine().split(" ");

            int N= Integer.parseInt(nk[0]);
            int K= Integer.parseInt(nk[1]);

            arr= new int[N];
            String [] items= scan.readLine().split(" ");
            for(int i= 0; i< N; i++){
                arr[i]= Integer.parseInt(items[i]);
            }

            dp= new int[N][K + 1];
            for(int[] ints : dp) Arrays.fill(ints, -1);
            System.out.println( divisible(0,  0, K)? "Divisible": "Not divisible");
        }
    }

    private static boolean divisible(int i, int sum , int k) {
        if(i == arr.length)
            return sum % k == 0;
        if(dp[i][sum] != -1)
            return dp[i][sum] != 0;

        boolean plus= divisible(i + 1, (sum + arr[i] % k + k) % k, k);
        boolean minus= divisible(i + 1, (sum - arr[i] % k + k) % k , k);

        dp[i][sum] = (plus || minus) ? 1 : 0;
        return plus || minus;
    }
}
