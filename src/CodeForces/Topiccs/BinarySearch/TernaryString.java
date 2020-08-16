package CodeForces.Topiccs.BinarySearch;

import java.util.*;
public class TernaryString {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int t= scan.nextInt();


        while(t != 0){
            String s= scan.next();

            //memorization :))
            int indexOne= -1; int indexTwo= -1; int indexThree= -1; //last index
            int min= Integer.MAX_VALUE;
            boolean found= false;

            for(int i= 0; i< s.length(); i++) {
                if (s.charAt(i) == '1') indexOne = i;
                else if (s.charAt(i) == '2') indexTwo = i;
                else if (s.charAt(i) == '3') indexThree = i;

                if (indexOne >= 0 && indexTwo >= 0 && indexThree >= 0) {
                    min= Math.min(min, 1 + Math.max(indexOne, Math.max(indexTwo, indexThree)) - Math.min(indexOne, Math.min(indexTwo, indexThree)));
                    found= true;
                }
            }
            if(found)
                System.out.println(min);
            else System.out.println(0);
            t--;
        }
    }
}
