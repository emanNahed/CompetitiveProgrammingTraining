package CodeForces.Level_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Woodcutters {


    static int n;
    static long [][] arr;
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        n= Integer.parseInt(scan.readLine());
        arr=  new long[n][4];

        long [][] trees= new long[n][2];

        for(int i= 0; i< n; i++){
            String [] tree= scan.readLine().split(" ");
            long c= Long.parseLong(tree[0]);
            long h= Long.parseLong(tree[1]);

            trees[i][0]= c; trees[i][1]= h;
        }

        long count= Math.min(2, trees.length);
        for(int i= 1; i< trees.length - 1; i++){
            if(trees[i][0] -  trees[i][1] >  trees[i - 1][0]) count++;
            else if(trees[i][0] +  trees[i][1] <  trees[i + 1][0]){
                count++;
                trees[i][0] += trees[i][1];
            }
        }
        System.out.println(count);
    }


}
