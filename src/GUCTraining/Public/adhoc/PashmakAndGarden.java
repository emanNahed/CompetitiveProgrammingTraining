package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class PashmakAndGarden {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int x0= scan.nextInt();
        int y0= scan.nextInt();
        int x1= scan.nextInt();
        int y1= scan.nextInt();

        if(x1 - x0 == 0){
            System.out.print((x0 + Math.abs(y0 - y1)) + " " + y0 + " " + (x1 + Math.abs(y1 - y0)) + " " + y1);
            return;
        }
        if(y1 - y0 == 0){
            System.out.println(x0 + " " + (y0 + Math.abs(x0 - x1)) + " " + x1 +" " + (y1 + Math.abs(x0 - x1)));
            return;
        }

        if(Math.abs(x1 - x0) == Math.abs(y1 - y0))
              System.out.println(x1 + " " + y0 + " " + x0 + " " + y1);
        else
            System.out.println(-1);
    }
}
