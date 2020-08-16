package CodeForces.Level_B;

import java.math.BigInteger;
import java.util.Scanner;

public class Pipeline {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        BigInteger n= new BigInteger(scan.next()).subtract(BigInteger.ONE);

        BigInteger k= new BigInteger(scan.next()).subtract(BigInteger.ONE);

        BigInteger test= k.add(BigInteger.ONE).multiply(k).divide(BigInteger.TWO);
        if(test.compareTo(n) < 0){
            System.out.println(- 1);
            return;
        }

        if(n.compareTo(BigInteger.ONE) < 0){
            System.out.println(0);
            return;
        }

        BigInteger low= BigInteger.ONE;
        BigInteger high= k;


        while (low.compareTo(high) <= 0){
            BigInteger mid = high.add(low).divide(BigInteger.TWO);

            BigInteger mm= mid.subtract(BigInteger.ONE);


            BigInteger sumB= mm.add(BigInteger.ONE).multiply(mm).divide(BigInteger.TWO);

            BigInteger midVal= test.subtract(sumB);

            if(midVal.equals(n)) {
                System.out.println(k.subtract(mid).add(BigInteger.ONE));
                return;
            }

            if(midVal.compareTo(n) > 0){
                low =  mid.add(BigInteger.ONE);
            }
            else{
                high =  mid.subtract(BigInteger.ONE);
            }

        }

        System.out.println(k.subtract(low).add(BigInteger.TWO));
    }
}
