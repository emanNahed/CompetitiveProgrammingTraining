package IEEEPractice;

import java.io.*;
import java.util.*;

public class MagicSquare {

    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(scan.readLine());


        int [][] arr= new int[n][n];

        for(int i= 0; i< n; i++){
            String [] item= scan.readLine().split(" ");
            for(int j= 0; j< n; j++){
                arr[i][j]= Integer.parseInt(item[j]);
            }
        }


        long mainSum= 0;
        List<Integer> list= new ArrayList<>();

        for(int i= 0; i< n; i++)
            mainSum += arr[i][i];

        long antiSum = 0;
        //test antidiagonal
        for(int i= 0; i< n; i++)
            antiSum += arr[n - i - 1][i];

        if(antiSum != mainSum)
            list.add(0);

        //test cols and rows
        for(int i= 0; i< n; i++){
            long currentSumC= 0;
            long currentSumR= 0;
            for(int j= 0; j< n; j++){
                currentSumC += arr[j][i];
                currentSumR += arr[i][j];
            }

            if(currentSumC != mainSum)
                list.add(-1 * (i + 1));

            if(currentSumR != mainSum)
                list.add(1 * (i + 1));
        }

        Collections.sort(list);

        System.out.println(list.size());

        for(int i= 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}