package GUCTraining.DP.Contest1;

import Reusable_Peices.SScanner;

import java.io.IOException;
import java.util.Arrays;

public class ChangingAString {

    static SScanner scan= new SScanner(System.in);
    static String s;
    static String t;
    static long [][]dp;
    static StringBuilder sb;

    public static void main(String [] args) throws IOException {
        s = scan.nextLine();
        t = scan.nextLine();

        dp = new long[s.length()][t.length()];
        for (long[] longs : dp) Arrays.fill(longs, -1);
        System.out.println(minChange(0, 0));

        sb = new StringBuilder();
        trace(0, 0, 0);

        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
            System.out.print(sb);
        }
    }

    private static long minChange(int i, int j) {
        if(i == s.length()) // in this case i reach to the end of s and you have to insert elements
            return t.length() - j;  // # elements you will insert

        if(j == t.length()) // in this case j reach to the end of t and you should delete the remaining elements in s
            return s.length() - i; // # elements you will delete

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = minChange(i + 1, j+ 1); // you don't have to make any move



        long insert= 1 +minChange(i, j+1); // you don't add any char actually then you will not move the cursor
        long delete= 1 + minChange(i + 1, j); //ignore the current pos
        long replace= 1 + minChange(i + 1, j+ 1);

        return dp[i][j]= Math.min(replace, Math.min(delete, insert));
    }


    static void trace(int i, int j, int currentPos){
        if((i == s.length() && j == t.length()))
            return;

        if(i == s.length()){
            sb.append("Insert ").append(i + currentPos + 1).append(" ").append(t.charAt(j)).append("\n");
            trace(i, j+ 1, currentPos+ 1);
        }


        else if(j == t.length()){
            sb.append("Delete ").append(i + currentPos + 1).append("\n");//.append(" ").append(t.charAt(j));
            trace(i + 1, j, currentPos- 1);
        }

        else if(s.charAt(i) == t.charAt(j)) {
            trace(i + 1, j + 1, currentPos);
        }

        //insert
        else if(minChange(i, j)== 1 + minChange(i , j+ 1)){
            sb.append("Insert ").append(i + currentPos + 1).append(" ").append(t.charAt(j)).append("\n");
            trace(i, j+ 1, currentPos+ 1);
        }

        else if(minChange(i, j) == minChange(i + 1, j) + 1){
            sb.append("Delete ").append(i + currentPos + 1).append("\n");//.append(" ").append(t.charAt(j));
            trace(i + 1, j, currentPos- 1);
        }
        else if(minChange(i, j) == minChange(i + 1, j + 1) + 1){
            sb.append("Replace ").append(i + currentPos + 1).append(" ").append(t.charAt(j)).append("\n");
            trace(i + 1, j+ 1, currentPos);
        }

    }
}
