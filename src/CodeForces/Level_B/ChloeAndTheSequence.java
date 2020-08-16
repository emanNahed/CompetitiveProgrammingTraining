package CodeForces.Level_B;


import java.util.*;
public class ChloeAndTheSequence {

    private static Scanner scan= new Scanner(System.in);


    public static void main(String [] args){
        int n= scan.nextInt();

        long x= scan.nextLong();
        int count = 1;
        while(count <= n){
            if(x % 2 == 1){
                System.out.println(count);
                break;
            }
            x /= 2;
            count++;
        }
    }
}
