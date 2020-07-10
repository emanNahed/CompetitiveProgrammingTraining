package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BearAndStrings {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String str= scan.readLine();

        int previous= 0;
        long total= 0;
        for(int i= 0; i< str.length() - 3; i++){
            if(str.charAt(i)== 'b' && str.charAt(i + 1) == 'e' && str.charAt(i + 2) == 'a' && str.charAt(i+3) =='r'){
                total += (long) (i + 1 - previous) * (str.length() - (i + 3));
                previous= i+ 1;
            }
        }




        System.out.println(total);
    }
}
