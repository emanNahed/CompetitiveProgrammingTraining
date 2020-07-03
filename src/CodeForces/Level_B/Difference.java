package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Difference {

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String l;
        int cases= 1;
        while(!(l= scan.readLine()).equals("0 0")) {
            String[] line = l.split(" ");

            int jobs = Integer.parseInt(line[0]);
            int dependencies = Integer.parseInt(line[1]);

            int[] times = new int[jobs];
            String[] timesLine = scan.readLine().split(" ");

            long totalTimes = 0;



            for (int i = 0; i < jobs; i++) {
                times[i] = Integer.parseInt(timesLine[i]);
                totalTimes += times[i];
            }

            Hashtable<Integer, HashSet<Integer>> inEdge = new Hashtable<>();
            Hashtable<Integer, HashSet<Integer>> outEdge = new Hashtable<>();

            for (int i = 0; i < dependencies; i++) {
                String[] depLine = scan.readLine().split(" ");
                int out = Integer.parseInt(depLine[0]);
                int in = Integer.parseInt(depLine[1]);

                outEdge.putIfAbsent(out, new HashSet<>());
                inEdge.putIfAbsent(in, new HashSet<>());

                outEdge.get(out).add(in); // out depend on in
                inEdge.get(in).add(out);
            }

            int n= Integer.parseInt(scan.readLine());
            String [] queries= scan.readLine().split(" ");
            System.out.println("Case #" + cases+":");

            for (String query : queries) {
                int jobItem = Integer.parseInt(query);

                long diffTotal = totalTimes - BFS(inEdge, times, jobItem) - times[jobItem - 1];
                long depTime = BFS(outEdge, times, jobItem);

                System.out.println(diffTotal - depTime);
            }

            System.out.println();
            scan.readLine();
            cases++;
        }
    }

    private static long BFS(Hashtable<Integer, HashSet<Integer>> inEdge, int[] times, int jobItem) {
        long result= 0;

        Queue<Integer> q= new LinkedList<>();
        HashSet<Integer> visited= new HashSet<>();

        q.offer(jobItem); visited.add(jobItem);

        while(!q.isEmpty()){
            int p= q.poll();
            result += (p != jobItem)? times[p - 1]: 0;

            if(inEdge.get(p) != null)
            for(int neighbors: inEdge.get(p)){
                if(!visited.contains(neighbors)){
                    q.offer(neighbors);
                    visited.add(neighbors);
                }
            }
        }

        return result;
    }
}
