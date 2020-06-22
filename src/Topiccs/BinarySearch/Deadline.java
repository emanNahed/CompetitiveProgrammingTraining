package Topiccs.BinarySearch;
import java.util.Scanner;

public class Deadline {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args) {
        int t= scan.nextInt();

        while (t != 0) {
            int n = scan.nextInt();
            int d = scan.nextInt();

            if (d <= n) {
                System.out.println("YES");
                t--;
                continue;
            }

            int low = 1;
            int high = n;
            while (low <= high){
                int mid= (low + high) / 2;

                int val = mid + (int)Math.ceil(d / (mid + 1.0));

                if(val <= n) {
                    System.out.println("YES");
                    break;
                }
                else if ((int)Math.ceil(d / (mid + 1.0)) > mid){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            if(low > high){
                System.out.println("NO");
            }
            t--;
        }
    }
}
