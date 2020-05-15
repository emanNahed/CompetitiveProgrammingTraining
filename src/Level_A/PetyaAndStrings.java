package Level_A;


import java.util.Scanner;

public class PetyaAndStrings {
    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        String a= input.nextLine();

        String b= input.nextLine();


        int compare= a.compareToIgnoreCase(b);

        compare = (compare == 0)? compare: (int)(compare * Math.abs(1.0/compare));
        System.out.println(compare);
    }
}
