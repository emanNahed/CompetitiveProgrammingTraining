package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class TheIslands {

    //this is a Bitonic TSP problem read about it in CP3 book ch9.3

    static SScanner scan= new SScanner(System.in);
    static int[][] coordinate;
    static  int a,b;
    static StringBuilder spath1;
    static StringBuilder spath2;
    static double [][][][] dp;

    public static void main(String [] args) throws IOException {
        int caseNo= 1;
        String line;
        while (!(line= scan.nextLine()).equals("0 0 0")){

            String [] nab= line.split(" ");
            int n= Integer.parseInt(nab[0]);
             a= Integer.parseInt(nab[1]);
             b= Integer.parseInt(nab[2]);

            coordinate= new int[n][2];
            for(int i= 0; i< n; i++) {
                coordinate[i][0] = scan.nextInt();
                coordinate[i][1]= scan.nextInt();
            }

            dp= new double[n + 1][n + 1][2][2];
            for(double[][][] longs: dp)
                for(double[][] longs1: longs)
                    for(double[] longs2: longs1)
                        Arrays.fill(longs2, -1.0);


            System.out.print("Case " + caseNo + ": ");
            System.out.printf("%.2f\n",Math.round(100*minPath(0, 0, false, false)) / 100.0); // a, b can't be start point

            spath2= new StringBuilder(); spath2.append(0).append(" ");
            spath1= new StringBuilder(); spath1.append(0).append(" ");
            trace(0,0, false,false);
            String [] s= spath2.toString().split(" ");
            for(int i= s.length - 1; i>= 0; i--)
                spath1.append(" ").append(Integer.parseInt(s[i]));
            System.out.println(spath1);

            caseNo++;
        }
    }

    private static double minPath(int p1, int p2, boolean path1, boolean path2) {
        int v= 1 + Math.max(p1 , p2);
        if(v == coordinate.length - 1) // reach to most east point
            return distance(coordinate[v], coordinate[p1]) + distance(coordinate[v], coordinate[p2]); //connect two paths

        if(dp[p1][p2][path1? 1: 0][path2? 1: 0] != -1.0) return dp[p1][p2][path1? 1: 0][path2? 1: 0];
        double distance1= distance(coordinate[v], coordinate[p1]);
        double distance2= distance(coordinate[v], coordinate[p2]);

        double connectPath1= ((v== a || v== b))? (path1? Long.MAX_VALUE: distance1+minPath(v, p2, true, path2))
                : distance1+ minPath(v, p2, path1, path2) ;
        double connectPath2=((v== a || v== b))? (path2? Long.MAX_VALUE: distance2+minPath(p1, v, path1, true)):
                distance2+minPath(p1, v, path1, path2) ;

        return dp[p1][p2][path1? 1: 0][path2? 1: 0]= Math.min(connectPath1, connectPath2);
    }


    private static double distance(int [] p1 , int[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    static void trace(int p1, int p2, boolean path1, boolean path2){
        int v= 1 + Math.max(p1, p2);

        if(v== coordinate.length - 1){
            spath1.append(v);
            return;
        }
        double distance1= distance(coordinate[v], coordinate[p1]);
        double distance2= distance(coordinate[v], coordinate[p2]);
        if( minPath(p1,p2, path1, path2) == distance1 + minPath(v, p2, path1||v == a || v == b, path2)){
            spath1.append(v).append(" ");
            trace(v, p2, path1|| v == a || v == b , path2);
        }
        else if( minPath(p1, p2, path1, path2) == distance2 + minPath(p1, v, path1, path2||v== a ||  v == b)){
            spath2.append(v).append(" ");
            trace(p1, v, path1, path2 || v== a ||  v == b);
        }

    }

}
