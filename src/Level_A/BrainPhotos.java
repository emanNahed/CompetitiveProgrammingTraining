package Level_A;

import java.util.Scanner;

public class BrainPhotos {

    private static Scanner scan= new Scanner(System.in);
    public static void main(String [] args){
        int n= scan.nextInt();
        int m= scan.nextInt();

        scan.nextLine();
        for(int i= 0; i< n; i++){
            String [] str= scan.nextLine().split(" ");

            for(int j= 0; j< m; j++){
                if(str[j].equals("Y") || str[j].equals("M") ||str[j].equals("C")){
                    System.out.println("#Color");
                    return;
                }
            }
        }

        System.out.println("#Black&White");
    }
}
