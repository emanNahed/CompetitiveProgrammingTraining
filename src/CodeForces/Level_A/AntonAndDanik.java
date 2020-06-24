package CodeForces.Level_A;

import java.util.Scanner;

public class AntonAndDanik {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        int count = 0;

        String wins= input.next();
        for(int i= 0; i< n; i++){
            char win= wins.charAt(i);
            if(win == 'A'){
                count++;
            }
        }

        if((int)Math.ceil(n/2.0) > count){
            System.out.println("Danik");
        }
        else if(n % 2== 0 && n/2 == count){
            System.out.println("Friendship");
        }
        else{
            System.out.println("Anton");
        }
    }
}
