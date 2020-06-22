package Level_c;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class FrogJumps {
    private static Scanner scan= new Scanner(System.in);

    public static void main(String[] args) {
        int q= scan.nextInt();

        while (q != 0){
            String str= scan.next();
            //find longest L;

            int max= 1;
            int count = 1;

            boolean doL= false;
            for(int i= 0; i< str.length(); i++){
                if(str.charAt(i) == 'L' && !doL) doL = true;
                if(i > 0) {
                    if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == 'L') {
                        count++;
                    }
                    if (str.charAt(i) != 'L' || i == str.length() - 1) {
                        max = Math.max(count, max);
                        count = 1;
                    }
                }
            }

            System.out.println((doL)? max + 1: max);

            q--;
        }

    }

}
