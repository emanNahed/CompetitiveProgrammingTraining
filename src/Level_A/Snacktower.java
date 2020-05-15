package Level_A;

import java.util.*;

public class Snacktower {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();


        List<Integer> days= new ArrayList<>(n);
        TreeMap<Integer,StringBuilder> lines= new TreeMap<>();


        for(int i= 0; i< n; i++){
            days.add(0);
        }



        for(int i= 0; i< n; i++) {
          int num= input.nextInt();

          days.set(n - num, i+1);
        }

        for(int i= 1; i< days.size(); i++){
            if(days.get(i-1) > days.get(i)){
                days.set(i, days.get(i-1));
            }
        }

        int index= 0;
        for(int line= 0; line< n; line++){

            if(lines.get(days.get(line)) == null){
                lines.put(days.get(line),new StringBuilder((n - line) + ""));
            }
            else{
                lines.put(days.get(line), lines.get(days.get(line)).append(" ").append(n - line));
            }
        }

        for(int i= 1; i<= n; i++){
            System.out.print((lines.get(i) == null)? "": lines.get(i));
            if(i != n){
                System.out.println();
            }
        }
    }
}
