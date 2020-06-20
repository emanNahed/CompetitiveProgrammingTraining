package Level_A;

import java.util.Scanner;

public class IsItrated {

    private static Scanner scan= new Scanner(System.in);


    public static void main(String [] args){
        //read input
        int n= scan.nextInt();

        int [][] arr= new int[n][2];

        for(int i= 0; i< arr.length; i++){
            arr[i][0]= scan.nextInt();
            arr[i][1]= scan.nextInt();
        }

        //check if rated
        for (int i= 0; i< n; i++){
            if(arr[i][0] != arr[i][1]){
                System.out.println("rated");
                return;
            }
        }


        for(int i= 1; i< n; i++){
            if(arr[i][0] > arr[i - 1][0]){
                System.out.println("unrated");
                return;
            }
        }

        for(int i= 1; i< n; i++){
            if(arr[i][0] == arr[i - 1][0]){
                System.out.println("maybe");
                return;
            }
        }

        System.out.println("rated");
    }
}
