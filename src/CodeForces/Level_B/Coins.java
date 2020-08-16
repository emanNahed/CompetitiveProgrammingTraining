package CodeForces.Level_B;
import java.util.Arrays;
import java.util.Scanner;

public class Coins {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String [] args){
        int t= 0;

        int [] arr= new int[3];
        while (t++ < 3){
            String read= scan.next();

            if(read.charAt(1) == '<') arr[read.charAt(2) - 'A']++;
            else arr[read.charAt(0) - 'A']++;
        }

        int countA= arr[0], countB= arr[1], countC= arr[2];

        Arrays.sort(arr);

        if(arr[0] == 0 && arr[1] == 1 && arr[2] == 2){
            int q= 3;

            while (q-- != 0) {
                int min = Math.min(countA, Math.min(countB, countC));
                if (min == countA) {
                    System.out.print('A');
                    countA = 3;
                } else if (min == countB) {
                    System.out.print('B');
                    countB = 3;
                } else {
                    System.out.print('C');
                    countC = 3;
                }
            }
        }
        else System.out.println("Impossible");


    }
}
