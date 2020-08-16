package CodeForces.Level_B;


import java.util.*;
public class Fence {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();
        int k= scan.nextInt();

        long [] arr= new long[n];
        long sum = 0;

        for(int i= 0; i< n; i++){
            sum += scan.nextLong();
            arr[i]= sum;
        }

        //System.out.println(Arrays.toString(arr));
        long min= Integer.MAX_VALUE;
        int minIndex= 0;
        for(int i= k - 1; i< n ; i++){
            long val=  arr[i] - ((i - k + 1 > 0)? arr[i - k]: 0);
            if(min >= val) {
                min = val;
                minIndex= i;
            }
        }

        System.out.println(minIndex- k + 2);
    }
}
