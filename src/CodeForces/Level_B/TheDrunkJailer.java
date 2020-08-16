package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheDrunkJailer {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(scan.readLine());

        //odd factor= number has a pow(n, 0.5)

        while (n-- != 0){
            System.out.println((int) Math.floor(Math.sqrt(Integer.parseInt(scan.readLine()))));
        }
    }

}
