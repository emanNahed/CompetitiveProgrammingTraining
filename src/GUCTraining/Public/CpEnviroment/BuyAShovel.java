package GUCTraining.Public.CpEnviroment;
import java.util.Scanner;
public class BuyAShovel {

    private static Scanner scan= new Scanner(System.in);
    public static void main(String [] args){
        int onePrice= scan.nextInt();
        int k= scan.nextInt();

        int totalPrice= onePrice;
        long count = 1;
        while(totalPrice % 10 != 0 && (totalPrice - k) % 10 != 0){
            totalPrice += onePrice; count++;
        }


        System.out.println(count);
    }

}
