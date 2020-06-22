package Topiccs.BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Worms {

    private static Scanner scan = new Scanner(System.in);

    //wrong answer (time limited exceeded)

    public static void main(String[] args) {
        int n = scan.nextInt();

        int[] arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum  = sum +  scan.nextInt();
            arr[i] = sum;
        }

        //prefix sum
        int m = scan.nextInt();

        int [] arrm= new int[m];
        int [] arrt= new int[m];

        for(int i= 0; i< m; i++){
            arrm[i] = scan.nextInt();
            arrt[i]= arrm[i];
        }

        Arrays.sort(arrm);
        Hashtable<Integer, Integer> ht= new Hashtable<>();

        int a= 0; int b= 0;

        while(a < n && b < m){
            if(arr[a] >= arrm[b]){
                ht.put(arrm[b], a + 1);
                b++;
            }
            else{
                a++;
            }
        }

        for(int i= 0; i< arrt.length; i++){
            System.out.println(ht.get(arrt[i]));
        }
    }
}