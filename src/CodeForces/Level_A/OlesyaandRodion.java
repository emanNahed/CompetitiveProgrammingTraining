package CodeForces.Level_A;

import java.math.BigInteger;
import java.util.Scanner;

public class OlesyaandRodion {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt() - 1;

        int m= scan.nextInt();

        BigInteger firstNum= BigInteger.ONE;
        BigInteger power= BigInteger.TEN;

        firstNum= firstNum.multiply(power).pow(n);

        BigInteger mod= new BigInteger(m + "");

        BigInteger reach= firstNum.add(power).subtract(BigInteger.ONE);//.subtract(BigInteger.ONE);
            while(!firstNum.equals(reach)){
            if(firstNum.mod(mod).equals(BigInteger.ZERO)){
                System.out.println(firstNum);
                return;
            }

            firstNum = firstNum.add(BigInteger.ONE);
        }

        System.out.println("-1");
    }
}
