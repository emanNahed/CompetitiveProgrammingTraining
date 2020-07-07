package CodeForces.Level_B;

import java.io.*;
import java.util.*;

public class ChatOnline {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String[]  line= scan.readLine().split(" ");

        int p= Integer.parseInt(line[0]);
        int q= Integer.parseInt(line[1]);

        int l= Integer.parseInt(line[2]);
        int r= Integer.parseInt(line[3]);

        int [][] xIntervals= new int[p][2];
        for(int i= 0; i< p; i++){
            String [] xInterval= scan.readLine().split(" ");

            xIntervals[i][0]= Integer.parseInt(xInterval[0]);
            xIntervals[i][1]= Integer.parseInt(xInterval[1]);
        }

        int [][] yIntervals= new int[q][2];

        for(int i= 0; i< q; i++){
            String [] yInterval= scan.readLine().split(" ");

            yIntervals[i][0]= Integer.parseInt(yInterval[0]);
            yIntervals[i][1]= Integer.parseInt(yInterval[1]);
        }

        //store intervals

        List<List<Integer>> intervals = new ArrayList<>();
        for(int i= 0; i< q; i++){
            int ys= yIntervals[i][0];
            int ye= yIntervals[i][1];
            for(int j= 0; j< p; j++){
                int xs= xIntervals[j][0];
                int xe= xIntervals[j][1];
                int diff0= xs - ye;
                int diff1= xe - ys;

                int index0= -1;
                int index1 = -1;

                if(!inside(diff0, diff1, l , r)){
                    if(diff0 <= l && diff1 >= r){
                        index0= 0;
                        index1= r - l;
                    }
                    else {
                        if(diff1 >= r){
                            index1= r - l;
                            index0= diff0 - l;
                        }
                        if(diff0 <= l){
                            index0 = 0;
                            index1 = diff1 - l;
                        }
                        if(diff0 >= l && diff1 <= r){
                            index1= diff1 - l ;//= 1;
                            index0= diff0 - l; //= 1;
                        }
                    }
                }
                if(index0 != -1 && index1 != -1) {
                    List<Integer> interval = new ArrayList<>();
                    interval.add(index0);
                    interval.add(index1);
                    intervals.add(interval);
                }
            }

        }

        int [] testArray= new int[r - l + 1];

        for(List<Integer> inerval: intervals){
            int i= inerval.get(0);
            int j= inerval.get(1);

            testArray[i] += 1;
            if(j < r - l)  testArray[j + 1] -= 1;
        }


        int count= 0;
        for(int i= 1; i< testArray.length; i++){
            testArray[i] += testArray[i - 1];

            if(testArray[i] >= 1) count++;
        }

        System.out.println(count+ ((testArray[0] >= 1)? 1: 0));
    }



    private static boolean inside(int diff0, int diff1, int l, int r) {
        return  (diff0 < l && diff1 < l) || (diff0 > r && diff1 > r);
    }

}
