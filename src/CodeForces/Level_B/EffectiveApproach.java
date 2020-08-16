package CodeForces.Level_B;

import java.util.*;
public class EffectiveApproach {
    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        Hashtable<Integer, Integer> vasya= new Hashtable<>();
        Hashtable<Integer, Integer> petya= new Hashtable<>();

        int n= scan.nextInt();

        for(int i= 0; i< n; i++){
            int  num= scan.nextInt();
            vasya.putIfAbsent(num, i + 1);
            petya.put(num, n - i);
        }

        int m= scan.nextInt();
        long vasyaSum= 0; long petyaSum= 0;
        for(int i= 0; i< m; i++){
            int num= scan.nextInt();
            vasyaSum += vasya.get(num);
            petyaSum += petya.get(num);
        }

        System.out.println(vasyaSum + " " + petyaSum);
    }
}
