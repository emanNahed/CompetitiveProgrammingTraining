package Level_A;

import java.util.Scanner;

public class EvenOdd {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        long n= scan.nextLong();

        long position = scan.nextLong();

        long mid= (n % 2 == 0)? n / 2 : n / 2 + 1;
        long output;
        if(position <= mid){
            output= 2*position - 1;
        }
        else{
            output= 2 * (position - mid) ;
        }

        System.out.println(output);
    }
}
