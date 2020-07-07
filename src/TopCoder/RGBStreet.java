package TopCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RGBStreet {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        //we will guess that's we can read input in that way :))
        String[] firstHouseCost= scan.readLine().split(" ");
        String[] secondHouseCost= scan.readLine().split(" ");
        String[] thirdHouseCost= scan.readLine().split(" ");

        int [] r= new int[3];
        int [] g= new int[3];
        int [] b= new int[3];

        r[0]= Integer.parseInt(firstHouseCost[0]);
        r[1]= Integer.parseInt(secondHouseCost[0]);
        r[2]= Integer.parseInt(thirdHouseCost[0]);

        g[0]= Integer.parseInt(firstHouseCost[1]);
        g[1]= Integer.parseInt(secondHouseCost[1]);
        g[2]= Integer.parseInt(thirdHouseCost[1]);

        b[0]= Integer.parseInt(firstHouseCost[2]);
        b[1]= Integer.parseInt(secondHouseCost[2]);
        b[2]= Integer.parseInt(thirdHouseCost[2]);

        intializeArray(costs);

        System.out.println(minCost(r,g,b, 0,3));
    }

    private static void intializeArray(long[][] costs) {

        for(int i= 0; i< 3; i++){
            long[] a= new long[4];
            Arrays.fill(a, 0);
            costs[i]= a;
        }
    }

    //apply the concept of memoization

    static long[][] costs= new long[3][4];



    private static long minCost(int[] r, int[] g, int[] b, int index, int previousColor) {
        if(index == 3)
            return 0;

        if(costs[index][previousColor] != 0)
            return costs[index][previousColor];

        long min= Long.MAX_VALUE;
        if(previousColor != 0)
             min = costs[index][previousColor] =Math.min(min, r[index] + minCost(r,g,b, index+1, 0));

        if(previousColor != 1)
            min = costs[index][previousColor] =Math.min(min, g[index] + minCost(r,g,b, index + 1, 1));

        if(previousColor != 2)
            min =costs[index][previousColor] = Math.min(min, b[index]  + minCost(r,g,b, index + 1, 2));



        return  min;
    }
}
