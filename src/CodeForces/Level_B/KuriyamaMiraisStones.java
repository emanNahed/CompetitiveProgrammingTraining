package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
public class KuriyamaMiraisStones {

    private static BufferedReader scan =new BufferedReader(new InputStreamReader(System.in));


    //brute force solution make time limit exceeded, another good idea is using prefix sum


    public static void main(String [] args) throws IOException {
        int n= Integer.parseInt(scan.readLine());

        BigInteger[] arr= new BigInteger[n];
        BigInteger [] sortArr= new BigInteger[n];

        String [] str= scan.readLine().split(" ");
        BigInteger prefixSumA= BigInteger.ZERO;
        for(int i= 0; i< n; i++){
            BigInteger num= new BigInteger(str[i]);

            prefixSumA= prefixSumA.add(num);
            arr[i]= prefixSumA;
            sortArr[i]= num;
        }

        Arrays.sort(sortArr);

        prefixSumA= BigInteger.ZERO;
        for(int i= 0; i < n; i++){
            BigInteger num= new BigInteger(sortArr[i] + "");
            prefixSumA= prefixSumA.add(num);

            sortArr[i]= prefixSumA;
        }



        long m= Long.parseLong(scan.readLine());

        while (m != 0){
            String [] strm= scan.readLine().split(" ");
            int a= Integer.parseInt(strm[0]);
            int b= Integer.parseInt(strm[1]) - 1;
            int c= Integer.parseInt(strm[2]) - 1;

            if(a == 1)
            System.out.println(arr[c].subtract((b > 0)? arr[b - 1]: BigInteger.ZERO));
            else
                System.out.println(sortArr[c].subtract((b > 0)? sortArr[b - 1]: BigInteger.ZERO));

            m--;

            int y= 300000;
        }
    }
}
