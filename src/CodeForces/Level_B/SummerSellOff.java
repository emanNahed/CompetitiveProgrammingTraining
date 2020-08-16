package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;

public class SummerSellOff {


    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String[] dayProduct = scan.readLine().split(" ");

        int n = Integer.parseInt(dayProduct[0]);
        int f = Integer.parseInt(dayProduct[1]);

        TreeMap<Integer, HashSet<Integer>> diff = new TreeMap<>(Comparator.reverseOrder());

        int[][] days = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] day = scan.readLine().split(" ");
            days[i][0] = Integer.parseInt(day[0]);
            days[i][1] = Integer.parseInt(day[1]);

            int difference = days[i][1] - days[i][0];
            if(difference > 0){
                int a= days[i][0];
                int b= Math.min(days[i][0] * 2, days[i][1]);
                int difference2= b - a;
                diff.putIfAbsent(difference2, new HashSet<>());
                diff.get(difference2).add(i);
            }
        }
        //search about minimum difference

        if(f != 0)
        for(int d: diff.keySet()){
            for(int index: diff.get(d)){
                days[index][0] *= 2;
                f--;
                if(f == 0) break;
            }
            if(f == 0) break;
        }

        long out= 0;

        for(int i= 0; i< days.length; i++){
            out += Math.min(days[i][0], days[i][1]);
        }

        System.out.println(out);
    }

}
