package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FilyaAndHomework {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(scan.readLine());

        String [] line= scan.readLine().split(" ");
        HashSet<Integer> numbers= new HashSet<>();

        for(int i= 0; i< n; i++){
            numbers.add(Integer.parseInt(line[i]));
        }

        if(numbers.size() < 3) {
            System.out.println("YES");
            return;
        }

        if(numbers.size() == 3){
            List<Integer> list= new ArrayList<>(numbers);
            Collections.sort(list);
            if(list.get(2) - list.get(1) == list.get(1) - list.get(0)){
                System.out.println("YES");
                return;
            }
            System.out.println("NO");
            return;
        }

        System.out.println("NO");
    }
}
