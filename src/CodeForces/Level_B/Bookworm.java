package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bookworm {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] line= scan.readLine().split(" ");
        int v= Integer.parseInt(line[0]);
        int c= Integer.parseInt(line[1]);
        int s= Integer.parseInt(line[2]);
        int e= Integer.parseInt(line[3]);

        if(s <= e)
            System.out.println((e - s)* c * 2+ (e - s - 1)* v);
        else
            System.out.println((s - e) * c * 2 + (s - e + 1) * v);
    }
}
