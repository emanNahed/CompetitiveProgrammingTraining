package CodeForces.Level_A;

import java.util.*;

public class PouringRain {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int d= scan.nextInt();
        int h= scan.nextInt();
        int v= scan.nextInt();
        int e= scan.nextInt();


        double result= 4.0 * v / (Math.PI * Math.pow(d,2))  - e; // this give us how we have to consume (height)

        result = h/ result;

        if(result < 0){
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
            System.out.printf("%.6f",result);
        }


    }
}
