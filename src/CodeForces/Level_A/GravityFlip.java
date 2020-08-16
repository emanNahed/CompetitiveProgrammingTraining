package CodeForces.Level_A;

import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        int [] arr= new int[n];

        for(int i= 0; i< n; i++){
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);

        for(int i= 0; i< n; i++){
            System.out.print(arr[i]);
            if(i < n- 1){
                System.out.print(" ");
            }
            else{
                System.out.println();
            }
        }
    }
}
