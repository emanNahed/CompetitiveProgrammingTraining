package Topiccs.BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Worms {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scan.nextInt();

        int[] arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum  = sum +  scan.nextInt();
            arr[i] = sum;
        }

        //prefix sum
        int m = scan.nextInt();

        while (m != 0) {
            int search = scan.nextInt();

            int low = 0;
            int high = n;

            while (low <= high) {
                int mid = (low + high) / 2;

                int a = arr[mid];
                int b = ((mid > 0) ? arr[mid - 1] : 0);

                if (search > b && search <= a) {
                    System.out.println(mid + 1);
                    break;
                }  else if (search > a) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            m--;
        }
    }
}