package CodeForces.Topiccs.TwoPointers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreePartsOfTheArray {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args) {
        int n= scan.nextInt();

        List<BigInteger> arr= new ArrayList<>();
        for(int i= 0; i< n;i++){
            arr.add(new BigInteger(scan.next()));
        }

        int lengthA= 0; int lengthB= 0;
        int start= 0; int end= n - 1;
        int startAttempt= 0; int endAttempt= n - 1;
        BigInteger sumA= BigInteger.ZERO; BigInteger sumB= BigInteger.ZERO; //don't change length until sumA= sumB;

        while(start <= end){
          if(sumA.compareTo(sumB) <= 0) sumA = sumA.add(arr.get(start++));
          if(sumA.equals(sumB)){
              lengthA += start - startAttempt;
              startAttempt= start;
              lengthB += endAttempt - end;
              endAttempt = end;
          }
          if(end != start - 1) {
              if(sumA.compareTo(sumB) >= 0) sumB= sumB.add(arr.get(end--));
              if (sumA.equals(sumB)) {
                  lengthA += start - startAttempt;
                  startAttempt = start;
                  lengthB += endAttempt - end;
                  endAttempt = end;
              }
          }

        }

        BigInteger sumOut= BigInteger.ZERO;

        for(int i= 0; i< lengthA; i++){
            sumOut= sumOut.add(arr.get(i));
        }

        System.out.println(sumOut);
    }
}
