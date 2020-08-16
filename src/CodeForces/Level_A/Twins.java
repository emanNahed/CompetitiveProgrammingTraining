package CodeForces.Level_A;

import java.util.Arrays;
import java.util.Scanner;

public class Twins {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        int sum= 0;
        int [] arr= new int[n];

        for(int i= 0; i< n; i++){
            arr[i] = input.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);


        int mySum= 0;
        for(int i= n-1; i>= 0; i--){
            mySum += arr[i];
            sum -= arr[i];

            if(mySum > sum){
                System.out.println(n - i);
                break;
            }
        }
    }
}
