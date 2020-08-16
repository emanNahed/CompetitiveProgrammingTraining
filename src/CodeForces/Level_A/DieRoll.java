package CodeForces.Level_A;

import java.util.Scanner;

public class DieRoll {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int a= input.nextInt();

        int b= input.nextInt();

        int dot= 6 - Math.max(a,b) + 1;

        switch(dot){
            case 1:
                System.out.println(1 + "/" + 6);
                break;
            case 2:
                System.out.println(1 + "/" + 3);
                break;
            case 3:
                System.out.println(1 + "/" + 2);
                break;
            case 4:
                System.out.println(2 + "/" + 3);
                break;
            case 5:
                System.out.println(5 + "/" + 6);
                break;
            case 6:
                System.out.println(1 + "/" + 1);
                break;
        }


    }
}
