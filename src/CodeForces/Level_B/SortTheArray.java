package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortTheArray {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(scan.readLine());

        String [] arrayRead= scan.readLine().split(" ");
        int [] arr= new int[n];
        for(int i = 0; i< n; i++){
            arr[i]= Integer.parseInt(arrayRead[i]);
        }

        int startIndex= 0;
        int endIndex= 0;
        boolean someVal = false;
        for(int i= 1; i< n; i++){
            if(arr[i] < arr[i - 1]){
                endIndex= i;
                if(!someVal) {
                    startIndex = i - 1;
                    someVal = true;
                }
            }
            else if(endIndex != startIndex){
                break;
            }
        }

        reveseSegment(arr,startIndex, endIndex);

        if(checkSorted(arr)){
            System.out.println("yes");
            System.out.println((startIndex + 1) + " " + (endIndex + 1));
        }
        else{
            System.out.println("no");
        }

    }

    private static boolean checkSorted(int[] arr) {
        for(int i= 1; i< arr.length; i++){
            if(arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    private static void reveseSegment(int[] arr, int startIndex, int endIndex) {
        int [] reverse= arr.clone();

        int index= startIndex;

        for(int i= endIndex; i >= startIndex; i--){
            arr[i] = reverse[index++];
        }

    }
}