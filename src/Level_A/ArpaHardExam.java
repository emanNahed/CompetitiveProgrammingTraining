package Level_A;

import java.math.BigInteger;
import java.util.Scanner;

public class ArpaHardExam {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        String  n= scan.nextLine();

        BigInteger num= new BigInteger("1378");

        num= num.modPow(new BigInteger(n), BigInteger.TEN);

        System.out.println(num);
    }
}
