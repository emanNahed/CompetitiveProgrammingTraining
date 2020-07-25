package GUCTraining.DP.Contest1;

import Reusable_Peices.SScanner;

import java.io.IOException;
import java.util.Hashtable;

public class LargestBlock {
    static SScanner scan= new SScanner(System.in);

    public static void main(String [] args) throws IOException {
        int p= scan.nextInt();

        while(p-- != 0){
            int size= scan.nextInt();

            int [][] arr= new int[size][size];

            int n= scan.nextInt();

            while (n-- != 0){
                int r1= scan.nextInt();
                int c1= scan.nextInt();
                int r2= scan.nextInt();
                int c2= scan.nextInt();

                for(int i= r1; i<= r2; i++)
                    for(int j= c1; j<= c2; j++)
                        arr[i - 1][j - 1]= 1;
            }

            //prefix sum 2d array
            for(int i= 0; i< size; i++)
                for(int j= 0; j< size; j++)
                    arr[i][j] += (i == 0? 0 : arr[i - 1][j]) + (j == 0? 0: arr[i][j - 1])
                            - (i == 0 || j == 0 ? 0 : arr[i - 1][j - 1] /*overlap*/);

            int max= 0;
            for(int i= 0; i< size; i++)
                for(int j= 0; j< size; j++) //start points
                    for (int i1= i; i1< size; i1++)
                        for(int j1= j; j1< size; j1++){
                            int area= arr[i1][j1] - (i == 0? 0: arr[i - 1][j1]) - (j == 0? 0: arr[i1][j - 1])
                                    + (i == 0 || j == 0? 0: arr[i - 1][j - 1]);

                            if(area == 0) //all elements in this rectangle not blocking
                                max= Math.max(max, (i1 - i + 1) * (j1 - j + 1));
                        }

            System.out.println(max);
        }
    }
}
