package Level_A;

import java.util.Scanner;

public class Magnets {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        StringBuilder str= new StringBuilder("");

        while (n != 0){
            str.append(input.next());
            n--;
        }
        int count= 0;
        for(int i= 1; i< str.length() - 1; i+=2){
            if(str.charAt(i) == str.charAt(i + 1)){
                count++;
            }
        }

        System.out.println(count+1);
    }
}
