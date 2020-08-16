package CodeForces.Level_A;

import java.util.Scanner;

public class NextRound {

    private static Scanner input= new Scanner(System.in);


    public static void main(String [] args){
        int n= input.nextInt();

        int place= input.nextInt() - 1;
        int numPlace= 0;

        int output= 0;
        for(int i= 0; i< n; i++){
            int num = input.nextInt();

            if(num > 0 && i<= place){
                output++;
                if(i == place){
                    numPlace= num;
                }
            }
            else if(num > 0 &&  num== numPlace){
                output++;
            }
        }

        System.out.println(output);
    }
}
