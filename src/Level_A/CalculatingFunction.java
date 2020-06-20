package Level_A;

import java.util.Scanner;

public class CalculatingFunction {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        long n= scan.nextLong();

        if(n % 2 == 0){
            n /= 2;
        }
        else{
            n = ((n - 1) / 2 - n);
        }

        System.out.println(n);
    }
}
