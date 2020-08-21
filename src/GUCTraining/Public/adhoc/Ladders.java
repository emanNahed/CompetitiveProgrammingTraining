package GUCTraining.Public.adhoc;

import java.util.Arrays;
import java.util.Scanner;

public class Ladders {

    public static void main(String [] args){
        Scanner scan= new Scanner(System.in);

        int n= scan.nextInt();
        int q= scan.nextInt();

        long [] arr= new long[n];
        for(int i= 0; i< n; i++) arr[i]= scan.nextLong();

        while(q-- != 0){
            int l= scan.nextInt() - 1;
            int r= scan.nextInt() - 1;

            boolean ladders= true;
            int stopIndex= -1; //x

            if(l == r) {System.out.println("Yes"); continue;}

            for(int i= l+ 1; i<= r; i++)
                if(arr[i] < arr[i - 1]) {
                    stopIndex= i;
                    break;
                }

            if(stopIndex != -1)
            for(int i= stopIndex + 1; i<= r; i++)
                if(arr[i] > arr[i - 1]){
                    ladders= false;
                    break;
                }

            System.out.println(ladders? "Yes": "NO");
        }
    }
}
