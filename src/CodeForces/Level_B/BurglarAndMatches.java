package CodeForces.Level_B;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class BurglarAndMatches {
     private static Scanner scan= new Scanner(System.in);

        public static void main(String [] args){
            long n= scan.nextLong();
            int m= scan.nextInt();

            TreeMap<Integer, Long> warehouse= new TreeMap<>(Collections.reverseOrder());

            for(int i= 0; i< m; i++){
                long a= scan.nextLong();
                int b= scan.nextInt();
                warehouse.putIfAbsent(b, (long)0);
                warehouse.put(b, warehouse.get(b) +  a);
            }

            long count= 0;
            for(Integer match: warehouse.keySet()){
                if(n - warehouse.get(match) >= 0){
                    count += warehouse.get(match) * match;
                    n -= warehouse.get(match);
                }
                else{
                    count += n * match;
                    n = 0;
                }

                if(n <= 0) break;
            }

            System.out.println(count);
        }
}
