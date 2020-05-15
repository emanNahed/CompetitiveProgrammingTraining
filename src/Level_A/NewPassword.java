package Level_A;

import java.util.Arrays;
import java.util.Scanner;

public class NewPassword {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();
        int k= input.nextInt();

        int t = 1;
        char ch= 'a';
        while(t <= n){
            System.out.print(ch++);
            if(t % k == 0){
                ch= 'a';
            }
            t++;
        }
    }
}
