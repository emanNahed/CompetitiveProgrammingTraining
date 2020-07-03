package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class StudentsAndShoelaces {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] line= scan.readLine().split(" ");

        int n= Integer.parseInt(line[0]);
        int g= Integer.parseInt(line[1]);

        Hashtable<Integer, HashSet<Integer>> ties= new Hashtable<>();

        for(int i= 0; i< g; i++){
            String [] tie= scan.readLine().split(" ");

            int a= Integer.parseInt(tie[0]);
            int b= Integer.parseInt(tie[1]);

            ties.putIfAbsent(a, new HashSet<>());
            ties.putIfAbsent(b, new HashSet<>());

            ties.get(a).add(b);
            ties.get(b).add(a);
        }
        boolean found;
        long count = -1;
        do {
            found= false;
            List<List<Integer>> outGroup= new ArrayList<>();
            for(Integer item: ties.keySet()){
                if(ties.get(item).size() == 1){
                    found= true;
                    List<Integer> list= new ArrayList<>();
                    list.add(item);
                    list.addAll(ties.get(item));
                    outGroup.add(list);
                }
            }


            for(List<Integer> out: outGroup){
                ties.remove(out.get(0));
                if(ties.get(out.get(1)) != null)
                ties.get(out.get(1)).remove(out.get(0));
            }
            count++;
        }while(found);

        System.out.println(count);

    }
}
