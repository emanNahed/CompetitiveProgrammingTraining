package Topiccs.BinarySearch;

import java.util.*;

public class VanyaandLanterns {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();
        int l= scan.nextInt();

        int [] laterns= new int[n];

        for(int i= 0; i< n; i++){
            laterns[i] = scan.nextInt();
        }

        Arrays.sort(laterns);

        int [] a= new int[n];
        a[0]= laterns[0];
        for(int i= 1; i< n; i++){
            a[i] = laterns[i] - laterns[i - 1];
        }


        double max= 0;  int maxIndex= 0;
        for(int i= 0; i< n; i++){
            if((i != 0 && max < a[i] / 2.0) || (i == 0 && max < (a[i]))){
                max= (i == 0)? a[i]: a[i] / 2.0;
            }
        }
        if(laterns[n  - 1] != l){
            if(l - laterns[n - 1] > max) {
                max = Math.max(max, l - laterns[n - 1]);
            }
        }

        System.out.printf("%.10f",max);
    }
}
