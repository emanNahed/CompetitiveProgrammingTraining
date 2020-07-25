package FaceBook;


import Reusable_Peices.SScanner;

import java.io.*;
import java.util.StringTokenizer;

public class Alchemy {

    public static void main(String [] args) throws IOException {
        SScanner scan = new SScanner(new FileInputStream("eman.in"));
        FileWriter fr = new FileWriter("output.out");

        int t= Integer.parseInt(scan.nextLine());

        int current= 0;
        while (current != t){
            int n= Integer.parseInt(scan.nextLine());

            String s= scan.nextLine();

            int countA= 0;
            int countB= 0;
            for(int i= 0; i< n; i++){
                if(s.charAt(i) == 'A')
                    countA++;
                else countB++;
            }

            current++;

            if(Math.abs(countA - countB) == 1)
                fr.write("Case #" + current+ ": Y");
            else
                fr.write("Case #" + current+ ": N");

            if(current != t) fr.write("\n");
        }
        fr.close();
    }
}

