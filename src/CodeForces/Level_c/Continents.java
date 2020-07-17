package CodeForces.Level_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Continents {

    static Hashtable<Integer, Hashtable< Integer, Index>> indices0;

    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String line;
        try {
            while ((line = scan.readLine()) != null) {
                String[] mn = line.split(" ");

                int m = Integer.parseInt(mn[0]);
                int n = Integer.parseInt(mn[1]);

                List<List<Character>> list = new ArrayList<>();
                indices0 = new Hashtable<>();
                HashSet<Index> indices = new HashSet<>();
                for (int i = 0; i < m; i++) {
                    String str = scan.readLine();
                    List<Character> chs = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        chs.add(str.charAt(j));
                        Index current = new Index(i, j);

                        if (chs.get(j) != 'w') {
                            indices0.putIfAbsent(i, new Hashtable<>());
                            indices0.get(i).put(j, current);

                            indices.add(current);
                        }
                    }
                    list.add(chs);
                }

                String[] mijIndex = scan.readLine().split(" ");

                int a = Integer.parseInt(mijIndex[0]);
                int b = Integer.parseInt(mijIndex[1]);
                Index king = indices0.get(a).get(b);

                Queue<Index> q = new LinkedList<>();
                HashSet<Index> visited = new HashSet<>();

                long maxVal = 0;
                for (Index index : indices) {
                    if (visited.contains(index))
                        continue;

                    q.offer(index);
                    visited.add(index);

                    boolean kingCities = false;

                    long count = 0;
                    while (!q.isEmpty()) {
                        Index p = q.poll();
                        if (p == king)
                            kingCities = true;

                        List<Index> neighbors = addNeighbors(list, p);

                        for (Index nei : neighbors)
                            if (!visited.contains(nei)) {
                                q.offer(nei);
                                visited.add(nei);
                            }
                        count++;
                    }
                    if (!kingCities)
                        maxVal = Math.max(count, maxVal);
                }

                System.out.println(maxVal);
                scan.readLine();
            }
        }catch (Exception e){

        }
    }


    private static List<Index> addNeighbors(List<List<Character>> list, Index index) {
        int i= index.i;
        int j= index.j;

        List<Index> result= new ArrayList<>();
        if(i > 0 && list.get(i - 1).get(j) != 'w')
            result.add(indices0.get(i - 1).get(j));

        if(i < list.size() - 1 && list.get(i + 1).get(j) != 'w')
            result.add(indices0.get(i + 1).get(j));

        if(j > 0 && list.get(i).get(j - 1) != 'w')
            result.add(indices0.get(i).get(j - 1));

        if(j < list.get(0).size() - 1 && list.get(i).get(j+1) != 'w')
            result.add(indices0.get(i).get(j + 1));

        if(j >= list.get(0).size() - 1 && list.get(i).get(0) != 'w')
            result.add(indices0.get(i).get(0));

        if(j <= 0 && list.get(i).get(list.get(0).size()-1) != 'w')
            result.add(indices0.get(i).get(list.get(0).size()-1));

        return result;
    }

    private static class Index implements Comparable<Index>{
        int i;
        int j;

        Index(int i, int j){
            this.i= i;
            this.j= j;
        }



        @Override
        public String toString() {
            return "Index{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }

        @Override
        public int compareTo(Index index) {
            return (this.i == index.i && this.j == index.j)? 0: 1;
        }
    }
}
