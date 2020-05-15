package Level_A;

import java.util.Scanner;

public class BuyAShovel {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int k= input.nextInt();

        int r= input.nextInt();

            int n= 1;

            while((n*k - r) % 10 != 0 && n*k % 10 != 0){
                n++;
            }

            System.out.println(n);

    }
}
