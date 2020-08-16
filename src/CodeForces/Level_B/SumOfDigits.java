package CodeForces.Level_B;

import java.math.BigInteger;
import java.util.*;

public class SumOfDigits {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        StringBuilder b= new StringBuilder(scan.nextLine());

        int count = 0;

        if(b.length() == 1){
            System.out.println(0);
            return;
        }
        do {
            b= sumOfDigit(b);
            count++;
        }while(numOfDigit(b) != 1);

        System.out.println(count);
    }

    private static int numOfDigit(StringBuilder b) {
        return b.length();
    }

    private static StringBuilder  sumOfDigit(StringBuilder b) {
        BigInteger a= BigInteger.ZERO;
        int index = 0;
        while(index < b.length()){
            a= a.add(new BigInteger(b.charAt(index) + ""));
            index++;
        }

        return new StringBuilder(a.toString());
    }
}
