package Level_A;

import java.util.Scanner;

public class WayTooLongWords {

    private static Scanner input= new Scanner(System.in);
    public static void main(String [] args){
        int n= input.nextInt();

        while(n != 0){
            String str= input.next();
            int length= str.length();
            if(length <= 10){
                System.out.println(str);
            }
            else{
                System.out.println(str.charAt(0) + ((str.length() - 2)+"") + str.charAt(length - 1));
            }

            n--;
        }
    }
}
