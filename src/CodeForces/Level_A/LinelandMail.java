package CodeForces.Level_A;

import java.util.Scanner;

public class LinelandMail {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        int [] arr= new int[n];
        for(int i= 0; i<n; i++){
            arr[i]= input.nextInt();
        }

        for(int i=0; i< arr.length; i++){
            int min= Math.min(((i > 0)?arr[i] - arr[i - 1]: Integer.MAX_VALUE),
                    (i < arr.length - 1)? arr[i+1] - arr[i]: Integer.MAX_VALUE);

            int max= Math.max(arr[i] - arr[0], arr[arr.length - 1] - arr[i]);

            System.out.println(min + " " + max);
        }
    }
}
