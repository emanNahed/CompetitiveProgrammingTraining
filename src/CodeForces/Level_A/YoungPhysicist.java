package CodeForces.Level_A;

import java.util.Scanner;

public class YoungPhysicist {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        int sumX = 0, sumY= 0, sumZ= 0;
        while(n != 0){
            sumX += input.nextInt();
            sumY += input.nextInt();
            sumZ += input.nextInt();
            n--;
        }

        if(sumX == 0 && sumY ==0 && sumZ == 0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
