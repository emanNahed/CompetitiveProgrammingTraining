package Reusable_Peices;

import java.util.*;
import java.util.function.ToIntFunction;

public class GCD {

    public static void main(String [] args){
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        pq.offer(2);
        pq.offer(5);

        for(Integer p: pq){
            System.out.println(p);
        }
    }

    int LCM(int a, int b){
        return a* b / GCD(a,b);
    }

    int GCD(int a, int b){
        if(a > b) return EcluidGCD(a, b);


        return EcluidGCD(b,a);
    }



    int EcluidGCD(int a, int b){
        if(b == 0) return a;

        return EcluidGCD(b, a % b);
    }

}
