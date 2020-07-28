package GUCTraining.DP.Contest2;

import Reusable_Peices.SScanner;
import java.io.IOException;

public class WavioSequence{

    static SScanner scan= new SScanner(System.in);
    public static void main(String [] args) throws IOException, InterruptedException {
        Thread.sleep(10000);
        while (scan.ready()) {
            int n = scan.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scan.nextInt();

            int[] a = new int[n]; // binary search on this array, but this array contains indices so we will take val from arr;
            int[] lis = new int[n];
            int size0 = 0;
            for (int i = 0; i < n; i++) {
                int lo = 0;
                int hi = size0 - 1;
                int ans = size0; // if i don't find any element bigger than me i will put myself in a[size]

                while (lo <= hi) {
                    int mid = lo + hi >> 1;
                    if (arr[a[mid]] >= arr[i]) {
                        ans = mid;
                        hi = mid - 1;
                    } else
                        lo = mid + 1;
                }
                a[ans] = i;
                if (ans == size0)
                    size0++;
                lis[i] = ans + 1;
            }


            a = new int[n]; // binary search on this array, but this array contains indices so we will take val from arr;
            int[] dis = new int[n];
            int size1 = 0;
            for (int i = n - 1; i >= 0; i--) {
                int lo = 0;
                int hi = size1 - 1;
                int ans = size1; // if i don't find any element bigger than me i will put myself in a[size]

                while (lo <= hi) {
                    int mid = lo + hi >> 1;
                    if (arr[a[mid]] >= arr[i]) {
                        ans = mid;
                        hi = mid - 1;
                    } else
                        lo = mid + 1;
                }
                a[ans] = i;
                if (ans == size1)
                    size1++;
                dis[i] = ans + 1;
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                // wrong: max = Math.max(max, (lis[i] == 1 || dis[i] == 1)? 1: lis[i] + dis[i] - 1);
                max= Math.max(max, Math.min(lis[i], dis[i]) * 2 - 1);
            }

            System.out.println(max);
        }
    }
}

