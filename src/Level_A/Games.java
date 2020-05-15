package Level_A;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Games {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();

        Hashtable<Integer,Integer> homeTeam= new Hashtable<>();
        int [] guest= new int[n];

        for(int i= 0; i< n; i++){
            int a= input.nextInt();
            int b= input.nextInt();
            homeTeam.putIfAbsent(a,0);
            homeTeam.put(a,homeTeam.get(a) + 1);

            guest[i] = b;
        }

        int result= 0;

        for(int i= 0; i< guest.length; i++){
            if(homeTeam.get(guest[i]) != null){
                result += homeTeam.get(guest[i]);
            }
        }

        System.out.println(result);
    }
}
