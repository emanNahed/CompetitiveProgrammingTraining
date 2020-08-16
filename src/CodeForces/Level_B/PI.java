package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PI {


    public static void main(String [] args) throws IOException {
        BufferedReader scan =new BufferedReader(new InputStreamReader(System.in));


        int t;
        while((t= Integer.parseInt(scan.readLine())) != 0) {
            int[] arr = new int[t];
            for (int i = 0; i < t; i++) {
                arr[i] = Integer.parseInt(scan.readLine());
            }

            long count = 0;
            for (int i = 0; i < t; i++) {
                for (int j = i + 1; j < t; j++) {
                    if (EcluidGCD(arr[i], arr[j]) == 1) count++;
                }
            }

            if (count == 0) {
                System.out.println("No estimate for this data set.");

            continue;
        }

            System.out.printf("%.6f", Math.sqrt(6.0 / (count/ ( (t * (t - 1) / 2.0))) ));
            System.out.println();
        }
    }



    static int EcluidGCD(int a, int b){
        if(b == 0) return a;

        return EcluidGCD(b, a % b);
    }
}
