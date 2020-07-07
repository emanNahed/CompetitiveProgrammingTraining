package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AddingReversedNumbers {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int t= Integer.parseInt(scan.readLine());

        while (t-- != 0){
            String [] str= scan.readLine().split(" ");
            int [] a= new int[str[0].length()];
            int [] b= new int [str[1].length()];

            for(int i= 0; i< str[0].length(); i++){
                a[i]= Integer.parseInt(str[0].charAt(i)+"");
            }

            for(int i= 0; i< str[1].length(); i++){
                b[i]= Integer.parseInt(str[1].charAt(i)+"");
            }
            int [] sum= sum(a,b);
            print(sum);
        }

    }

    private static void print(int[] sum) {
        for(int i= 0; i < sum.length - 1;i++){
            if(sum[i] == 0){
                sum[i] = -1;
            }
            else{
                break;
            }
        }

        if(sum[sum.length - 1] == 0) sum[sum.length - 1] = -1;

        for(int i= 0; i< sum.length; i++){
            System.out.print((sum[i] != -1)? sum[i]: "");
        }
        System.out.println();
    }

    private static int[] sum(int[] a, int[] b) {
        int [] sum= new int[Math.max(a.length, b.length) + 1];

        for(int i= 0; i< sum.length; i++){
            int localSum= sum[i];
            if(i < a.length) localSum += a[i];
            if(i < b.length) localSum += b[i];

            if(localSum / 10 > 0) {
                sum[i] = localSum % 10;
                sum[i + 1] = localSum / 10;
            }
            else{
                sum[i] = localSum;
            }
        }

        return sum;
    }

    private static int[] reverse(int[] b) {
        int [] reverse= new int[b.length];
        int index= 0;
        for(int i= b.length - 1; i>=0 ; i--){
            reverse[index++]= b[i];
        }

        return reverse;
    }
}
