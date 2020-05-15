package Level_A;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class TeamOlympiad {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int n= input.nextInt();
        Hashtable<Integer, List<Integer>> gifted= new Hashtable<>();

        for(int i= 0; i< n; i++){
            int num= input.nextInt();

            gifted.putIfAbsent(num, new ArrayList<>());
            gifted.get(num).add(i+1);
        }

        int sizeOne= (gifted.get(1) == null)? 0 : gifted.get(1).size();
        int sizeTwo= (gifted.get(2) == null)? 0 :gifted.get(2).size();
        int sizeThree= (gifted.get(3) == null)? 0 :gifted.get(3).size();
        int minSize= Math.min(Math.min(sizeOne,sizeTwo),sizeThree);

        int index= 0;

        if(minSize == 0){
            System.out.println(0);
        }
        else {
            System.out.println(minSize);

        }
        while(minSize != 0){
            int indexOne= gifted.get(1).get(index);
            int indexTwo= gifted.get(2).get(index);
            int indexThree= gifted.get(3).get(index++);
            System.out.println(indexOne + " " + indexTwo + " " + indexThree);
            minSize--;
        }
    }
}
