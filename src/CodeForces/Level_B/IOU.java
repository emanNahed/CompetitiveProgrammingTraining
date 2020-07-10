package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IOU {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] line= scan.readLine().split(" ");

        int n= Integer.parseInt(line[0]);
        int m= Integer.parseInt(line[1]);


        long[] vals= new long[n];
        for(int i= 0; i< m; i++){
            String [] d= scan.readLine().split(" ");
            int a= Integer.parseInt(d[0]);
            int b= Integer.parseInt(d[1]);
            int c= Integer.parseInt(d[2]);

            vals[a - 1] -= c;
            vals[b - 1] += c;
        }

        long sum = 0;
        for(long x: vals)
            sum += Math.max(0,x);

        System.out.println(sum);
    }

}