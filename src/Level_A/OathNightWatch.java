package Level_A;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeMap;

public class OathNightWatch {


    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){

        int n= input.nextInt();

        TreeMap<Integer,Integer> ht= new TreeMap<>();

        for(int i= 0; i< n; i++){
            int num= input.nextInt();
            ht.putIfAbsent(num,0);
            ht.put(num,ht.get(num) + 1);
        }

        int output= 0;
        for(int i: ht.keySet()){
            if(i != ht.lastKey() && i != ht.firstKey()){
                output += ht.get(i);
            }
        }

        System.out.println(output);
    }
}
