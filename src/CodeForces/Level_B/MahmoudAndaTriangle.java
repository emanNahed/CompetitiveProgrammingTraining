package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class MahmoudAndaTriangle {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(scan.readLine());

        TreeMap<Long, Integer> segments= new TreeMap<>();
        String [] readSegments= scan.readLine().split(" ");

        for(int i=0; i< n; i++){
            long item= Long.parseLong(readSegments[i]);
            segments.putIfAbsent(item, 0);
            segments.put(item, segments.get(item) + 1);
        }
        long a= 0; long b= 0; long c= 0;
        for(long item: segments.keySet()) {
            a = item;
            segments.put(a, segments.get(a) - 1);
            if (segments.floorKey(a) == null || segments.get(segments.floorKey(a)) == 0) {
                if (segments.lowerKey(a) == null || segments.get(segments.lowerKey(a)) == 0) {
                    segments.put(a, segments.get(a) + 1);
                    continue;
                }
                else{
                    c = segments.lowerKey(a);
                    segments.put(c, segments.get(c) - 1);
                }
            }
            else {
                c = segments.floorKey(a);
                segments.put(c, segments.get(c) - 1);
            }


            if (segments.lowerKey(a + c) == null){
                segments.put(a, segments.get(a) + 1);
                segments.put(c, segments.get(c) + 1);
                continue;
            }
            else if(segments.get(segments.lowerKey(a + c)) == 0){
                long walk= segments.lowerKey(a + c);
                if(segments.lowerKey(walk) == null || segments.get(segments.lowerKey(walk)) == 0){
                    segments.put(a, segments.get(a) + 1);
                    segments.put(c, segments.get(c) + 1);
                    continue;
                }
                else{
                    b= segments.lowerKey(walk);
                }
            }
            else {
                b = segments.lowerKey(a + c);
            }
            if (a + b > c && b + c > a && a + c > b) {
                System.out.println("YES");
                return;
            }
            else{
                segments.put(a, segments.get(a) + 1);
                segments.put(c, segments.get(c) + 1);
            }
        }

        System.out.println("NO");
    }
}
