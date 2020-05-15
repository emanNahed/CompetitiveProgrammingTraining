package Level_A;

import java.util.Scanner;

public class BearBigBrother {

    private static Scanner input= new Scanner(System.in);
    public static void main(String [] args){
        int a= input.nextInt();

        int b= input.nextInt();

        if(a==b){
            System.out.println(1);
        }
        else{
            int c= (int) (Math.floor(Math.log(b*1.0/a)/Math.log(1.5))) + 1;
            System.out.println(c);
        }

    }
}
