package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;

import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;
import java.util.Arrays;
public class ShoppingTrip {

    static SScanner scan= new SScanner(System.in);
    static double [][] arr;
    static double [][] save;
    static double [][] dp;
    static int saves;
    public static void main(String [] args) throws IOException {
        int t= scan.nextInt();

        while (t-- != 0){
            scan.nextLine();

            int stores= scan.nextInt();
            int roads= scan.nextInt();

            arr= new double[stores + 1][stores + 1]; // + 1 for home
            for(double[] doubles: arr) Arrays.fill(doubles, Double.MAX_VALUE);
            for(int i= 0; i< stores; i++) arr[i][i]= 0;

            for(int i= 0; i< roads; i++){
                int a= scan.nextInt();
                int b= scan.nextInt();

                double c= scan.nextDouble();

                arr[a][b]= Math.min(arr[a][b], c);
                arr[b][a] = arr[a][b];
            }

            saves= scan.nextInt();
            save= new double[saves + 1][2];
            save[0][0] = 0; save[0][1] = 0;
            for(int i= 1; i< saves + 1; i++) {
                int store= scan.nextInt();
                save[i][0] = store;
                save[i][1]= scan.nextDouble();
            }


            //apply floyd algorithm (my first time :")) )
            for(int intermediate= 0; intermediate < stores + 1; intermediate++)

                for(int src= 0; src < stores + 1; src++)

                    for(int dst= 0; dst< stores +1; dst++)
                        if(arr[src][intermediate] + arr[intermediate][dst] < arr[src][dst])
                            arr[src][dst]= arr[src][intermediate] + arr[intermediate][dst];


            dp= new double[stores + 1][(1 << save.length)];
            for(double [] doubles: dp) Arrays.fill(doubles, -1.0);

            double result= maxSave(0, 1);
            if(result > 0.0){
                System.out.print("Daniel can save $");
                System.out.printf("%.2f", result);
                System.out.println();
            }
            else
                System.out.println("Don't leave the house");
        }
    }

    private static double maxSave(int current, int mask) {
        if(mask == (1 << save.length) - 1) return - arr[(int)save[current][0]][0];

         if(dp[current][mask] != -1) {
             return dp[current][mask];
         }


        double max= -arr[(int)save[current][0]][0]; //which is better return home from this store or complete other stores?
        for(int i= 0; i< save.length; i++)
            if((mask & (1 << i)) == 0)
                max= Math.max(max,  (save[i][1] - arr[(int) save[current][0]][(int) save[i][0]]) + maxSave(i, mask | (1 << i)));

        return dp[current][mask]= max;
    }

}