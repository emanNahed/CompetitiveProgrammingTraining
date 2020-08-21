package GUCTraining.Public.adhoc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class VisitingAFriend {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args) {
        int numPigs = scan.nextInt();
        int fHouse = scan.nextInt();

        int[] interval = new int[101];
        for (int i = 0; i < numPigs; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            interval[start] = 1;
            if (end < 100) interval[end + 1] = -1;
        }


        //prefix sum
        for(int i= 1; i< 101; i++)
            interval[i] += interval[i - 1];

        for(int i= 0; i <= fHouse; i++)
            if(interval[i] <= 0){
                System.out.println("NO");
                return;
            }

        System.out.println("YES");
    }
}
