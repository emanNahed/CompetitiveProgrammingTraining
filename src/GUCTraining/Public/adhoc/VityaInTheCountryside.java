package GUCTraining.Public.adhoc;

import java.util.Arrays;
import java.util.Scanner;

public class VityaInTheCountryside {
    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        int [] arr= new int[n];
        for(int i= 0; i< arr.length; i++)
            arr[i]= scan.nextInt();

        if(n == 1) {
            if(arr[0] == 15)
                System.out.println("DOWN");
            else if(arr[0] == 0)
                System.out.println("UP");
            else
            System.out.println(-1); return;
        }
        if(arr[arr.length - 1]> arr[arr.length - 2]) {
            if (arr[arr.length - 1] == 15)
                System.out.println("DOWN");
            else
                System.out.println("UP");
        }
        else {
            if (arr[arr.length - 1] == 0)
                System.out.println("UP");
            else
                System.out.println("DOWN");
        }


    }
}
