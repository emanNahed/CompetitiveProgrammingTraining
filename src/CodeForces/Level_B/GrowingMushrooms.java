package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class GrowingMushrooms {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] compete= scan.readLine().split(" ");

        int n= Integer.parseInt(compete[0]);
        int t1= Integer.parseInt(compete[1]);
        int t2= Integer.parseInt(compete[2]);
        int k= Integer.parseInt(compete[3]);

        TreeMap<Double, TreeSet<Integer>> results= new TreeMap<>(Comparator.reverseOrder());

        for(int i= 0; i< n; i++){
            String [] participant= scan.readLine().split(" ");

            int a= Integer.parseInt(participant[0]);
            int b= Integer.parseInt(participant[1]);

            double choice0= (a* t1 - (k* a * t1 * 1.0) / 100.0) + b*t2*1.0;
            double choice1= (b* t1 - (k* b * t1 * 1.0) / 100.0) + a*t2*1.0;

            if(choice0 > choice1){
                double r=(int)(choice0 * 100) / 100.0;
                results.putIfAbsent( choice0 , new TreeSet<>());
                results.get(choice0).add(i + 1);
            }
            else{
                double r=(int)(choice1 * 100) / 100.0;
                results.putIfAbsent( choice1 , new TreeSet<>());
                results.get(choice1).add(i + 1);
            }
        }

        for(Double val: results.keySet()){
            for(Integer index: results.get(val)){
                System.out.print(index + " ");
                System.out.printf("%.2f", val);
                System.out.println();
            }
        }
    }
}
