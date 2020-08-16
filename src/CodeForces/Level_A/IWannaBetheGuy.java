package CodeForces.Level_A;

import java.util.HashSet;
import java.util.Scanner;

public class IWannaBetheGuy {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        HashSet<Integer> levels= new HashSet<>();

        int p= scan.nextInt();

        for(int i= 0; i < p; i++){
            levels.add(scan.nextInt());
        }

        int q= scan.nextInt();

        for(int i= 0; i < q; i++){
            levels.add(scan.nextInt());
        }

        //System.out.println(xLittle+" " + yLittle+ " " +levels);

        for(int i= 1; i <= n; i++){
            if(!levels.contains(i)){
                System.out.println( "Oh, my keyboard!");
                return;
            }
        }

        System.out.println("I become the guy.");
    }
}
