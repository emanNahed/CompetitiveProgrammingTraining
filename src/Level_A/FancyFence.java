package Level_A;

import java.util.Scanner;

public class FancyFence {

    // i search on google about regular polygons, and i find this rule: internal angel= (n - 2) * 180 / n;


    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        while(n != 0) {
            double internalAngle = scan.nextDouble();

            internalAngle = 180.0 - internalAngle;

            internalAngle = 360.0 / internalAngle;


            if ((int) (internalAngle * 1000) != (int) internalAngle * 1000) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

            n--;
        }
    }
}

