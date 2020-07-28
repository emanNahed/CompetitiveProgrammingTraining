package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;

import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;
import java.util.Arrays;

public class ShoppingTrip {

    static SScanner scan= new SScanner(System.in);
    static double [][] arr;
    static double [] save;
    public static void main(String [] args) throws IOException {
        int t= scan.nextInt();

        while (t-- != 0){
            //scan.nextLine();

            int stores= scan.nextInt();
            int roads= scan.nextInt();

             arr= new double[stores + 1][stores + 1]; // + 1 for home
            for(double[] doubles: arr) Arrays.fill(doubles, Double.MAX_VALUE);

            for(int i= 0; i< roads; i++){
                int a= scan.nextInt();
                int b= scan.nextInt();

                double c= scan.nextDouble();

                arr[a][b]= c;
                arr[b][a] = c;
            }

            int saves= scan.nextInt();
            save= new double[stores + 1];
            for(int i= 0; i< saves; i++) {
                int store= scan.nextInt();
                save[store] = scan.nextDouble();
            }


            //apply floyd algorithm (my first time :")) )
            for(int intermediate= 0; intermediate < stores; intermediate++)

                for(int src= 0; src < stores; src++)

                    for(int dst= 0; dst< stores; dst++)
                        if(arr[src][intermediate] + arr[intermediate][dst] < arr[src][dst])
                            arr[src][dst]= arr[src][intermediate] + arr[intermediate][dst];



            System.out.println(maxSave(0, 1));
        }
    }

    private static double maxSave(int current, int mask) {
        if(mask == (1 << arr.length) - 1) return - arr[current][0];

        double max= 0;
        for(int i= 0; i< arr.length; i++)
            if((mask & (1 << i)) == 0)
                max= Math.max(max,  (save[i] - arr[current][i]) + maxSave(i, mask | (1 << i)));



        return max;
    }
}
