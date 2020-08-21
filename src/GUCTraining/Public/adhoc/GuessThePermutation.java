package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class GuessThePermutation {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        int [][] arr= new int[n][n];
        for(int i= 0; i< n; i++)
            for(int j= 0; j < n; j++)
                arr[i][j] = scan.nextInt();


        int [] result= new int[n];
        int max= 0;
        for(int i= 0; i< n ;i++) {
            int localMax= 0;

            for(int j= 0; j< n; j++){
                localMax= Math.max(arr[i][j], localMax);
                localMax= Math.max(arr[j][i], localMax);
            }
            result[i] = (max == localMax)? localMax + 1: localMax;
            max= Math.max(localMax, max);

            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
