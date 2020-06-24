package CodeForces.Topiccs.BinarySearch;

import java.util.Scanner;

public class SportMafia {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n= scan.nextInt();
        int k= scan.nextInt();

        int s= 1; int e= n;

        while(s <= e){
            int mid = (s + e) / 2;

            long val= (long)mid * (mid + 1) /2;

            val -= k;

            if(val + mid == n){
                System.out.println(val);
                return;
            }
            else if (val + mid> n){
                e= mid- 1;
            }
            else {
                s = mid + 1;
            }
        }
        System.out.println(s);

    }
}
