package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class MahmoudAndLongestUncommonSubsequence {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        String a= scan.nextLine();
        String b= scan.nextLine();

        if(a.equals(b))
            System.out.println(-1);
        else
            System.out.println(Math.max(a.length(), b.length()));
    }
}
