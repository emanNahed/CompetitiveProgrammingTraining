package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class BearandFindingCriminals {
    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();
        int k= scan.nextInt();

        int [] arr= new int[n];
        for(int i= 0; i< n; i++){
            arr[i]= scan.nextInt();
        }
        int count = (arr[k - 1] == 1)? 1: 0;
        int i= k - 2;
        int j = k ;

        while(i >= 0 && j < n){
            count += (arr[i] == arr[j] && arr[i] == 1)? 2:0;
            i--; j++;
       }

        while(i >= 0){
            count += (arr[i] == 1)? 1 : 0;
            i--;
        }

        while(j < n){
            count += (arr[j] == 1)? 1 : 0;;
            j++;
        }
        System.out.println(count);
    }
}
