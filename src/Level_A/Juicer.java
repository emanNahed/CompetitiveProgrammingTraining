package Level_A;

import java.util.Scanner;

public class Juicer {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        int b= input.nextInt();

        int d= input.nextInt();

        int sum = 0;
        int empty = 0;
        for(int i= 0; i< n; i++){
            int size= input.nextInt();

            if(size <= b){
                sum += size;
            }

            if(sum > d){
                empty++;
                sum= 0;
            }
        }

        System.out.println(empty);
    }
}
