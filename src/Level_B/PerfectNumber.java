package Level_B;

import java.util.Scanner;

public class PerfectNumber {
    private static Scanner scan= new Scanner(System.in);


    public static void main(String [] args) {
        int n = scan.nextInt();

        int count= 1;
        for(int i= 19; i< 1000000; i+= 9){
            if(perfect(i)){
                count++;
            }
            if(count == n){
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean perfect(int i) {
        int sum = 0;

        while(i != 0){
            sum += i % 10;
            i /= 10;
        }

        return (sum == 10);
    }
}
