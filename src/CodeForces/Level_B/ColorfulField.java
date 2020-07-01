package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ColorfulField {

    //don't store all indecies
    // use treemap to sort indices for waste and query
    //use prefixsum to find the amount of shift..

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] line= scan.readLine().split(" ");

        int n= Integer.parseInt(line[0]);
        int m= Integer.parseInt(line[1]);
        int w= Integer.parseInt(line[2]);
        int q= Integer.parseInt(line[3]);

        TreeMap<Index, Long> arr= new TreeMap<>();
        Hashtable<Integer, Hashtable<Integer,Index>> indices= new Hashtable<>();
        for(int i= 0; i< w; i++){
            String [] wasteLine= scan.readLine().split(" ");

            int row= Integer.parseInt(wasteLine[0]);
            int col= Integer.parseInt(wasteLine[1]);

            Index index = new Index(row, col, 1, true);

            indices.putIfAbsent(row, new Hashtable<>());
            indices.get(row).put(col, index);

            arr.put(index, (long) 1);
        }

        //for make output sorted :))
        int [][] quries= new int[q][2];

        for(int i= 0; i< q; i++){
            String [] queryLine= scan.readLine().split(" ");

            int row= Integer.parseInt(queryLine[0]);
            int col= Integer.parseInt(queryLine[1]);
            quries[i][0]= row; quries[i][1]= col;

            if(indices.get(row) == null || indices.get(row).get(col) == null) {
                Index index = new Index(row, col, 0, false);

                indices.putIfAbsent(row, new Hashtable<>());
                indices.get(row).put(col, index);

                arr.put(index, (long) 0);
            }

        }

        //prefix sum
        long sum= 0;

        for(Index index: arr.keySet()){
            sum += arr.get(index);
            arr.put(index, sum);
        }

        for(int i= 0; i< q; i++){
            int row= quries[i][0];
            int col= quries[i][1];

            if(indices.get(row) != null && indices.get(row).get(col).isWaste){
                System.out.println("Waste");
            }
            else{
                long f= (row - 1) * m + col - arr.get(indices.get(row).get(col));

                if(f % 3 == 1){
                    System.out.println("Carrots");
                }
                else if(f % 3 == 2){
                    System.out.println("Kiwis");
                }
                else{
                    System.out.println("Grapes");
                }
            }

        }

    }

    static class Index implements Comparable<Index> {
        int row;
        int col;
        int val;
        boolean isWaste;

        Index(int row, int col, int val, boolean isWaste){
            this.row= row;
            this.col= col;
            this.val= val;
            this.isWaste= isWaste;
        }

        @Override
        public int compareTo(Index index) {
            if(this.row - index.row != 0)
                return this.row - index.row;

            return this.col - index.col;
        }
    }
}