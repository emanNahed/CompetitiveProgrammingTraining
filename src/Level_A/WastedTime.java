package Level_A;

import java.util.Scanner;

public class WastedTime {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        int k= scan.nextInt();

        int totalCoordinateA= 0, totalCoordinateB= 0;

        int a= scan.nextInt();
        int b= scan.nextInt();

        double out= 0;

        for(int i= 0; i< n - 1; i++){
            int newA= scan.nextInt();
            int newB= scan.nextInt();

            totalCoordinateA = Math.abs(newA - a);
            totalCoordinateB = Math.abs(newB - b);

           out += Math.sqrt(Math.pow(totalCoordinateA,2) + Math.pow(totalCoordinateB,2));
            a= newA; b= newB;
        }

        out *= (k/50.0);

        System.out.printf("%.9f",out);
    }
}
