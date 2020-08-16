package CodeForces.Level_A;

import java.util.HashSet;
import java.util.Scanner;

public class Horseshoe {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        HashSet<Integer> hs= new HashSet<>();

        for(int i= 1; i <= 4; i++){
            hs.add(input.nextInt());
        }


        System.out.println(4 - hs.size());
    }
}
