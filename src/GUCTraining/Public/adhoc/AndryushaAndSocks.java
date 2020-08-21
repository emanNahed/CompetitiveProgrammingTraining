package GUCTraining.Public.adhoc;

import java.util.HashSet;
import java.util.Scanner;

public class AndryushaAndSocks {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        HashSet<Integer> hs= new HashSet<>();
        int maxDistinct= 0;
        int distinct= 0;

        for(int i= 0; i< 2*n ; i++){
            int sock= scan.nextInt();
            if(hs.contains(sock)) distinct--;
            else {hs.add(sock); distinct++;}

            maxDistinct= Math.max(distinct, maxDistinct);
        }

        System.out.println(maxDistinct);
    }
}
