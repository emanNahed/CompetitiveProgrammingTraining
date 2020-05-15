package Level_A;

import java.util.Scanner;

public class Presents {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();
        int [] arr= new int[n];

        for(int i= 0; i< n; i++){
            int num= input.nextInt();
            arr[num - 1] = i + 1;
        }

        for(int i= 0; i< n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
