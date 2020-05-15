package Level_A;

import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Team {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        int count= 0;
        input.nextLine();
        while(n != 0){
            String a= input.nextLine();
            int acceptingCount= 0;
            if(a.charAt(0) == '1'){
                acceptingCount++;
            }
            if(a.charAt(2) == '1'){
                acceptingCount++;
            }
            if(a.charAt(4) == '1'){
                acceptingCount++;
            }

            if(acceptingCount >= 2){
                count++;
            }


            n--;
        }

        System.out.println(count);
    }
}
