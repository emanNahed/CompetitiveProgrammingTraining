package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;

import java.io.IOException;
import java.util.Arrays;

public class Trainsorting {
    static SScanner scan= new SScanner(System.in);
    public static void main(String [] args) throws IOException {
        int t = scan.nextInt();
        while (t-- != 0) {
            int n = scan.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = scan.nextInt();

            int[] a = new int[n];
            int[] lis = new int[n];
            int size = 0;
            for (int i = n - 1; i >= 0; i--) {
                int lo = 0;
                int hi = size - 1;
                int ans = size;
                while (lo <= hi) {
                    int mid = lo + hi >> 1;
                    if (arr[a[mid]] <= arr[i]) {
                        ans = mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                a[ans] = i;
                if (ans == size) // i don't find any element less than me
                    size++;
                lis[i] = ans + 1;
            }

            int[] b = new int[n];
            int[] dis = new int[n];
            int size1 = 0;
            for (int i = n - 1; i >= 0; i--) {
                int lo = 0;
                int hi = size1 - 1;
                int ans = size1;
                while (lo <= hi) {
                    int mid = lo + hi >> 1;

                    if (arr[b[mid]] >= arr[i]) {
                        ans = mid;
                        hi = mid - 1;
                    } else lo = mid + 1;
                }
                b[ans] = i;
                if (ans == size1)
                    size1++;
                dis[i] = ans + 1;
            }
           // System.out.println(Arrays.toString(arr));
            //System.out.println(Arrays.toString(lis));
            //System.out.println(Arrays.toString(dis));
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(lis[i] + dis[i] - 1, max);
            }

            System.out.println(max);

        }
    }
}
