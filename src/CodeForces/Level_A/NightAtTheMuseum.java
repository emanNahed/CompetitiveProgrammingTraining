package CodeForces.Level_A;

import java.util.Scanner;

public class NightAtTheMuseum {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        String name= input.next();


        char current= 'a';
        int sum = 0;
        for(int i= 0; i< name.length(); i++){
            //counterclockwise
            int x= Math.max(current,name.charAt(i));
            int y= Math.min(current,name.charAt(i));

            int a= x - y;
            int b= (26 - x) + y;
            sum += Math.min(a,b);

            current= name.charAt(i);
        }

        System.out.println(sum);
    }
}
