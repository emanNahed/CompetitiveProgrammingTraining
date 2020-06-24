package CodeForces.Level_A;

import java.util.Scanner;

public class CarrotCakes {


    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();   //total k nubers

        int t= input.nextInt();   // time to bake k cakes

        int k= input.nextInt();

        int d= input.nextInt();   // time to build new oven

        int cookCakes= n - k * (int)Math.floor(d*1.0 / t);


        if (cookCakes > k){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
