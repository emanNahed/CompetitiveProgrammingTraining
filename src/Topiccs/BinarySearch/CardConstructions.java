package Topiccs.BinarySearch;

import java.util.Scanner;
public class CardConstructions {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int t= scan.nextInt();

        while(t != 0){
            int n= scan.nextInt();

            int count = 0;

            while(n > 1){
                int low = 1;  int high = n;
                 int max= 0;
                while(low <= high){
                    int mid= (low + high) /2;

                    long val= 2 * (long)mid + 3* mid * ((long)mid - 1) / 2;


                    if(n - val < 0){
                        high = mid - 1;
                    }
                    else{
                        max = Math.max(max,  (int)val);
                        low = mid+ 1;
                    }
                }
                n -= max;

                if(n >= 0) count++;
            }
            System.out.println(count);
            t--;
        }
    }
}
