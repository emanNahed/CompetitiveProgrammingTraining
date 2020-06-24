package CodeForces.Level_A;

import java.util.Scanner;

public class BeautifulMatrix {
    private static Scanner input= new Scanner(System.in);


    public static void main(String [] args){

        int rowIndex= 0;
        int colIndex= 0;
        for(int i= 1; i<= 5; i++){
            for (int j= 1; j <= 5; j++){
                int a= input.nextInt();

                if(a == 1){
                    rowIndex= i;
                    colIndex= j;
                }
            }
        }


        int distance= Math.abs(rowIndex - 3) + Math.abs(colIndex - 3);
        System.out.println(distance);
    }
}
