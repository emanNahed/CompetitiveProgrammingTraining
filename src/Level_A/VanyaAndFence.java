package Level_A;

import java.util.Scanner;

public class VanyaAndFence {
    private static Scanner input= new Scanner(System.in);

    //implementation
    public static void main(String [] args){
        int numOfFriends= input.nextInt();

        int height= input.nextInt();



        int minWidth= 0;
        while (numOfFriends != 0){
            int a= input.nextInt();
            if(a > height)
                minWidth += 2;
            else
                minWidth += 1;
            numOfFriends--;
        }


        System.out.println(minWidth);
    }
}
