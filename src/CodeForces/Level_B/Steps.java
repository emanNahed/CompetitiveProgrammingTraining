package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Steps {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] yard= scan.readLine().split(" ");

        int n= Integer.parseInt(yard[0]);
        int m= Integer.parseInt(yard[1]);

        String [] current= scan.readLine().split(" ");

        int currentX= Integer.parseInt(current[0]);
        int currentY= Integer.parseInt(current[1]);

        int moves= Integer.parseInt(scan.readLine());

        BigInteger totalTime= BigInteger.ZERO;
        while(moves-- != 0){
            String [] moveItem= scan.readLine().split(" ");
            int sxi= Integer.parseInt(moveItem[0]);
            int syi= Integer.parseInt(moveItem[1]);

            long timeX= Long.MAX_VALUE; long timey= Long.MAX_VALUE;
            if(sxi < 0)  timeX= (1 - currentX) / sxi;
            else if(sxi > 0) timeX= (n - currentX) / sxi;

            if(syi < 0)  timey= (1 - currentY) / syi;
            else if(syi > 0) timey= (m - currentY) / syi;


            totalTime = totalTime.add(new BigInteger(Long.toString(Math.min(timeX, timey))));
            currentX += Math.min(timeX, timey)* sxi;
            currentY += Math.min(timeX, timey) * syi;
        }

        System.out.println(totalTime);
    }
}
