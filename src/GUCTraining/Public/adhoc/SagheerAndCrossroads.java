package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class SagheerAndCrossroads {

    static Scanner scan= new Scanner(System.in);
    public static void main(String [] args){
        int [][] arr= new int[4][4];

        for(int i= 0; i< 4; i++) {
            boolean isOne = false;
            for (int j = 0; j < 4; j++) {
                arr[i][j] = scan.nextInt();
                if(arr[i][j] == 1) if(j == 3 && isOne){
                    System.out.println("YES");
                    return;
                }
                else isOne = true;
            }
        }


        if(arr[0][3] == 1 && (arr[1][0] == 1 || arr[2][1] == 1 || arr[3][2] == 1))
            System.out.println("YES");
        else if(arr[1][3] == 1 && (arr[0][2] == 1 || arr[3][1] == 1 || arr[2][0] == 1))
            System.out.println("YES");
        else if(arr[2][3] == 1 && (arr[0][1] == 1 || arr[1][2] == 1 || arr[3][0] == 1))
            System.out.println("YES");
        else if(arr[3][3] == 1 && (arr[0][0] == 1 || arr[1][1]== 1 || arr[2][2] == 1))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
