package CodeForces.Topiccs.BinarySearch;

import java.util.Scanner;

public class LetWatchFootball {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int a= scan.nextInt();
        int b= scan.nextInt();
        int c= scan.nextInt();

        int totalUnits= a*c;

        int low = 1; int high = totalUnits;

        int min= Integer.MAX_VALUE;
        while(low <= high){
            int mid= (low + high) / 2;

            int totalTest= mid + b * c;

            if(totalTest >= totalUnits){
                min= Math.min(min, (int)Math.ceil(mid / (b* 1.0)));
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        System.out.println(min);
    }
}
