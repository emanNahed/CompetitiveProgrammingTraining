package Level_A;

import java.util.Scanner;

public class MahmoudandLUS {

    private static Scanner input =new Scanner(System.in);

    public static void main(String[] args){
        String a= input.next();
        String b= input.next();

        if(a.length() != b.length()){
            System.out.println(Math.max(a.length(),b.length()));
        }
        else if(!a.equals(b)){
            System.out.println(a.length());
        }
        else{
            System.out.println(-1);
        }
    }
}
