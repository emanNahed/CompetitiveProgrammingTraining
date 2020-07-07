package CodeForces.Level_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Vacations {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(scan.readLine());

        int [] days= new int[n];
        String[] daysRead= scan.readLine().split(" ");

        for(int i= 0;i< n; i++){
            days[i]= Integer.parseInt(daysRead[i]);
        }
        int [][] rests= new int[n][3];

        intializeArray(rests);
        System.out.println(minRest(rests, days, 0, 2));
    }

    private static void intializeArray(int[][] rests) {
        for(int i= 0; i< rests.length; i++){
            int[] a= new int[3];
            Arrays.fill(a, 0);
            rests[i]= a;
        }
    }


    private static int minRest(int[][] rests, int[] days, int index, int previousTask) {
        if(index == days.length)
            return 0;

        if(rests[index][previousTask] != 0)
            return rests[index][previousTask];

        int min= Integer.MAX_VALUE;
        if(previousTask != 0 && days[index] != 0 && days[index] != 1)
            min= rests[index][previousTask]= Math.min(min, minRest(rests, days, index + 1, 0));

        if(previousTask != 1 && days[index] !=  0&& days[index] != 2)
            min= rests[index][previousTask] = Math.min(min, minRest(rests, days, index + 1, 1));


        if(days[index] == 0 || (previousTask == 0 && days[index] == 2) || (previousTask == 1 && days[index] == 1) )
            min= rests[index][previousTask] = Math.min(min, 1 + minRest(rests, days, index+ 1, 2));

        return min;
    }
}
