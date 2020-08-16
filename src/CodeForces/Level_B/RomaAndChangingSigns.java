package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class RomaAndChangingSigns {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] nk= scan.readLine().split(" ");

        int n= Integer.parseInt(nk[0]);
        int k= ( Integer.parseInt(nk[1]));

        int [] arr= new int[n];
        int finishNegative = -1;

        String[] str= scan.readLine().split(" ");
        for(int i= 0; i< n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        if(arr[arr.length - 1] < 0) finishNegative= arr.length - 1;

        int index= 0;
        while(index < arr.length && arr[index] < 0 && k> 0){
            arr[index++] *= -1;
            k--;
        }

        Arrays.sort(arr);
        arr[0] *=(k % 2 == 0)? 1: -1;


        System.out.println(sum(arr));
    }

    private static long sum(int[] arr) {
        long sum = 0;
        for(int a: arr)
            sum += a;

        return sum;
    }
}
