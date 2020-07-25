package FaceBook;


import Reusable_Peices.Reader;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TravelRestrictions {

    public static void main(String [] args) throws IOException {
        Reader scan= new Reader("input.txt");
        FileWriter fr= new FileWriter("output.out");

        int t= Integer.parseInt(scan.readLine());

        int current= 0;

        while (current != t){
            int n= Integer.parseInt(scan.readLine());


            boolean [] I= new boolean[n];
            boolean[] O= new boolean[n];

            String strI= scan.readLine();
            String strO= scan.readLine();
            for(int i= 0; i< n; i++)
                I[i]= (strI.charAt(i) == 'Y');


            for(int i= 0; i< n; i++)
                O[i]= (strO.charAt(i) == 'Y');


            char[][] arr= new char[n][n];
            for(char [] chars: arr) Arrays.fill(chars, 'N');

            for(int i= 0; i< n; i++){
                arr[i][i] = 'Y';
                if(i > 0){
                    arr[i][i - 1] = O[i] &&  I[i - 1]? 'Y': 'N';
                }
                if(i < n - 1){
                    arr[i][i + 1]= O[i] && I[i + 1]? 'Y': 'N';
                }
            }

            for(int i= 0; i< n; i++){

                Queue<Integer> q= new LinkedList<>();
                q.offer(i);

                long mask= 1 << i;

                while (!q.isEmpty()){
                    int p = q.poll();
                    arr[i][p] = 'Y';

                    for(int j= 0; j< n; j++){
                        if(arr[p][j] == 'Y' && checkMask(mask, j)) {
                            mask= mask | 1 << j;
                            q.offer(j);
                        }
                    }
                }
            }

            StringBuilder output= new StringBuilder();
            for(int i= 0; i< n; i++){
                for(int j= 0; j< n; j++){
                    output.append(arr[i][j]);
                }
                 if(i != n - 1)   output.append("\n");
            }

            fr.write("Case #" + (current + 1)+":\n");
            fr.write(output.toString());
            current++;
            if(current != t) fr.write("\n");
        }
        fr.close();
    }

    private static boolean checkMask(long mask, int j) {
        return (mask & (1 << j)) == 0;
    }
}
