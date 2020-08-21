package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class InfiniteSequence {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int a= scan.nextInt();
        int b= scan.nextInt();
        int c= scan.nextInt();

        if(c == 0)
            if(a == b)
                System.out.println("YES");
            else
                System.out.println("No");
        else {
            double n = (b - a) / (c * 1.0);
            if (n < 0 || n % 1 != 0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
