package Level_A;

import java.util.Scanner;

public class SerejaAndDima {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();


        Integer [] arr= new Integer[n];

        for(int i=0; i< n; i++){
            arr[i]= input.nextInt();
        }


        int turn= 0;
        int [] sums= new int[2];

        int low = 0, high = n-1;

        while (low <= high){
            if(arr[low] > arr[high]){
                sums[turn] += arr[low++];
            }
            else{
                sums[turn] += arr[high--];
            }

            turn= (turn == 0)?1 : 0;
        }
        System.out.println(sums[0]+ " " + sums[1]);
    }
}
