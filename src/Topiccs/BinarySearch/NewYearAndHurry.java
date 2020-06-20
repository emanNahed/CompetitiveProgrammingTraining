package Topiccs.BinarySearch;
import java.util.Scanner;


//level A
public class NewYearAndHurry {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        int k= scan.nextInt();

        if(k / 60.0 >= 4.0){
            System.out.println(0);
            return;
        }

        int low= 1;
        int high= n;

        int max= 0;
        while(low <= high) {
            int mid = (low + high) / 2;

            double time= 5.0 * (mid) * (mid + 1) /2.0 + k;

            if(time/60.0 > 4.0){
                high = mid - 1;
            }
            else{
                max= Math.max(max, mid);
                low= mid + 1;
            }
        }

        System.out.println(max);
    }
}
