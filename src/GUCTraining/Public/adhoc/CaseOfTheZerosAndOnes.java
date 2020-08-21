package GUCTraining.Public.adhoc;

import java.util.Scanner;

public class CaseOfTheZerosAndOnes {

    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        String str= scan.next();

        int countZeros= 0, countOnes= 0;
        for(int i= 0; i< str.length(); i++)
            if(str.charAt(i) == '0') countZeros++;
            else countOnes++;

        System.out.println(str.length() - 2* Math.min(countOnes, countZeros));
    }
}
