package Level_A;

import java.util.Hashtable;
import java.util.Scanner;

public class Football {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String[] args){
        int n= scan.nextInt();

        Hashtable<String,Integer> ht= new Hashtable<>();

        scan.nextLine();
        for(int i= 0; i < n; i++){
            String line= scan.nextLine();
            ht.putIfAbsent(line, 0);
            ht.put(line, ht.get(line) + 1);
        }
        int max= 0;
        String maxs= "";
        for(String str: ht.keySet()) {
            if(ht.get(str) > max){
                maxs= str;
                max= ht.get(str);
            }
        }
        System.out.println(maxs);
    }
}
