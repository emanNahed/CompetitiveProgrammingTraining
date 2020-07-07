package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Escape {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        double vp= Double.parseDouble(scan.readLine());
        double vd= Double.parseDouble(scan.readLine());

        double t= Double.parseDouble(scan.readLine());
        double f= Double.parseDouble(scan.readLine());

        double c= Double.parseDouble(scan.readLine());

        if(vp > vd){
            System.out.println(0);
            return;
        }
        double positionPrincess= t*vp;
        int positionMonster= 0;

        long count = 0;
        double currentTime= t;

        while(positionPrincess < c){
            double n= positionPrincess /(1.0*vd - vp);


            positionPrincess += vp* n;
            positionMonster += vd*n;

            if(positionPrincess < c) {
                count++;
                positionPrincess += 1.0 * vp * (f + positionPrincess / vd);
                currentTime += (n + f + positionPrincess / vd);
            }

        }
        System.out.println(count);
    }
}
