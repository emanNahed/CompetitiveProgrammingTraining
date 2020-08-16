package CodeForces.Level_A;

import java.util.Scanner;

public class PoliceRecruits {


    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();


        int countHiring= 0;
        int untreatment= 0;

        for(int i= 0; i< n; i++){
            int num= input.nextInt();

            if(num >= 0){
                countHiring += num;
            }
            else{
                if(countHiring == 0){
                    untreatment++;
                }
                else {
                    countHiring--;
                }
            }


        }

        System.out.println(untreatment);
    }
}
