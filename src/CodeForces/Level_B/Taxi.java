package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Taxi {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] str= scan.readLine().split(" ");

        int pariMoney= Integer.parseInt(str[0]);
        int pariIncrease= Integer.parseInt(str[1]);
        int taxiMoney= Integer.parseInt(str[2]);
        int taciIncrease= Integer.parseInt(str[3]);
        int end = 0;

        if(pariMoney >= taxiMoney){
            System.out.println(pariMoney);
            return;
        }

       while(pariMoney <= taxiMoney){
           if(pariMoney + pariIncrease <= taxiMoney) {
               pariMoney += pariIncrease;
               end= pariMoney;
           }
           else {
               System.out.println(taxiMoney);
               return;
           }


           if(taxiMoney - taciIncrease >= pariMoney) {
               taxiMoney -= taciIncrease;
               end= taxiMoney;
           }
           else{
               System.out.println(pariMoney);
               return;
           }
       }

        System.out.println(end);


    }
}
