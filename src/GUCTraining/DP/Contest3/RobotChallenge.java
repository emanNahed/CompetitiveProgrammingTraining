package GUCTraining.DP.Contest3;

import java.util.Arrays;
import java.util.Scanner;
public class RobotChallenge {

    private static Scanner scan= new Scanner(System.in);
    private static double [][] dp;
    private static StringBuilder sb;
    private final static Target start= new Target(0, 0, 0);
    private final static Target end= new Target(100, 100, 0);
    public static void main(String [] args){
        int n;
        while ((n = scan.nextInt()) != 0){
            Target prev= start;

            while (n-- != 0){
                Target cur= new Target(scan.nextInt(), scan.nextInt(), scan.nextInt());
                prev.setNext(cur);
                prev= cur;
            }

            prev.setNext(end);


            dp= new double[101][101];
            for(double [] d: dp) Arrays.fill(d,-1.0);
            System.out.printf("%.3f\n",Math.round(1000*minScore(start)) / 1000.0);

            //sb= new StringBuilder();
           // trace(start);
            //System.out.println(sb);
        }
    }

    private static double minScore(Target start) {
        if(start == null) return 0;

        if(dp[start.i][start.j] != -1.0) return dp[start.i][start.j];
        Target next= start.next;
        double take= distance(start,next) + (next != null? 1: 0) + minScore(next);
        double leave= next == null || next.next == null? Double.MAX_VALUE: distance(start, next.next) + next.penalty + minScore(next.next) + (next.next == end? 1 : 0);


        return dp[start.i][start.j]= Math.min(take, leave);
    }

    private static double distance(Target next, Target next1) {
        if(next == null || next1 == null) return 0;
        return Math.sqrt(Math.pow(next.i- next1.i, 2) + Math.pow(next.j- next1.j, 2));
    }

    private static void trace(Target start){
        if (start == null) return;

        if(minScore(start) == minScore(start.next) + distance(start, start.next) + (start.next == null? 0: 1)) {
            if(start.next != null)
            sb.append(start.next.i).append(" ").append(start.next.j);
        }
        trace(start.next);

    }


    static class Target{
        int i;
        int j;
        int penalty;
        Target next;


        Target(int i, int j, int penalty){
            this.i= i;
            this.j= j;
            this.penalty = penalty;
        }

        public void setNext(Target next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Target{" +
                    "i=" + i +
                    ", j=" + j +
                    ", penalty=" + penalty +
                    ", next=" +
                    (next == null? "null": next) +
                    '}';
        }
    }
}
