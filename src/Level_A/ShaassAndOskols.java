package Level_A;

import java.util.Scanner;

public class ShaassAndOskols {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){

        int n= input.nextInt();

        int [] arr= new int[n];

        for(int i= 0; i< n; i++){
            arr[i]= input.nextInt();
        }

        int m= input.nextInt();

        for(int i= 0; i< m; i++){
            int x= input.nextInt() - 1;
            int y= input.nextInt();

            if(x > 0){
                arr[x - 1] += y - 1;
            }

            if(x < n - 1){
                arr[x + 1] += arr[x] - y;
            }

            arr[x] = 0;
        }


        for(int i= 0; i< n; i++){
            System.out.println(arr[i] + " ");
        }
    }

}
