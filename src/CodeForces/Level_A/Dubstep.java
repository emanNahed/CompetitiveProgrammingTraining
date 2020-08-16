package CodeForces.Level_A;

import java.util.Scanner;

public class Dubstep {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args) {
        StringBuilder a= new StringBuilder("");

        String input= scan.nextLine();

        input= input.replace("WUB"," ");

        String [] output= input.split("\\s");

        for(int i= 0; i< output.length; i++){
            if(!output[i].isEmpty()){
                System.out.print(output[i]+ " ");
            }
        }

    }
}
