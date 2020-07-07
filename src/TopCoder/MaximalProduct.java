package TopCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalProduct {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] sk= scan.readLine().split(" ");

        int s= Integer.parseInt(sk[0]);
        int k= Integer.parseInt(sk[1]);


        intializeArray();

        System.out.println(maximalProduct(s, k));
    }

    private static void intializeArray() {
        for(int i= 0; i< 100; i++){
            long[] a= new long[100];
            Arrays.fill(a, 0);
            results[i]= a;
        }
    }

    static long[][] results= new long[100][100];

    private static long maximalProduct(int s, int k) {
        if(k == 0 && s== 0)
            return 1;
        else if(k == 0)
            return 0;

        if(results[s][k] != 0)
            return results[s][k];

        long max= 0;
        for(int i= 1; i<= s; i++){
            long o= maximalProduct(s - i, k - 1);
            max=results[s][k]=  Math.max(max, o* i);
        }
        return max;
    }


}
