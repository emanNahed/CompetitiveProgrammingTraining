package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class MultiplicationTable {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();
        long k= scan.nextLong();

        //find factors of k
        long count = 0;
        for(int i= 1; i<= Math.sqrt(k); i++)
            if(k % i == 0)
                if(k / i <= n && i <= n)
                    count += (k / i != i)? 2: 1;

        System.out.println(count);
    }
}
