package CodeForces.Level_A;

import java.util.Scanner;

public class BlackSquare {


    private static Scanner input= new Scanner(System.in);


    public static void main(String [] args){
        int [] arr= new int[4];

        for(int i= 0; i< 4; i++){
            arr[i]= input.nextInt();
        }


        String str= input.next();
        int calories= 0;
        for(int i= 0; i< str.length(); i++){
            int index= Integer.parseInt(str.charAt(i) + "") - 1;
            calories += arr[index];
        }

        System.out.println(calories);
    }
}
