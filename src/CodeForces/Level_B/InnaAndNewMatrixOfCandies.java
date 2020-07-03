package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InnaAndNewMatrixOfCandies {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String[] line= scan.readLine().split(" ");
        int n= Integer.parseInt(line[0]);
        int m= Integer.parseInt(line[1]);

        TreeSet<Interval> intervals= new TreeSet<>();

        char[][] arr= new char[n][m];
        for(int i= 0; i< n; i++){
            String item= scan.readLine();
            int sIndex= -1;
            int gIndex= -1;
            for(int j= 0; j< m; j++){
                arr[i][j]= item.charAt(j);
                if(arr[i][j] == 'S') sIndex= j;
                if(arr[i][j] == 'G') gIndex= j;
            }
            if(sIndex < gIndex) {
                System.out.println(-1);
                return;
            }
            intervals.add(new Interval(sIndex, gIndex));
        }

        System.out.println(intervals.size());



    }

    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        Interval(int start, int end){
            this.start= start;
            this.end= end;
        }


        private int distance(){
            return this.end - this.start;
        }
        @Override
        public int compareTo(Interval interval) {
            return this.distance() - interval.distance();
        }
    }
}
