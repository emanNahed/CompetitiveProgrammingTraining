package GirlsACPC;

import java.io.*;
import java.util.*;
import Reusable_Peices.Reader;

public class HappyLand {

    public static void main(String[] args) throws IOException {
        Reader scan = new Reader("land.in");

        int t = scan.nextInt();

        while (t-- != 0) {
            int pairs = scan.nextInt();

            int c0 = scan.nextInt();
            int c1 = scan.nextInt();
            Hashtable<String, HashSet<String>> friends = new Hashtable<>();

            while (pairs-- != 0) {
                String[] fr = scan.readLine().split(" ");
                String a = fr[0];
                String b = fr[1];

                friends.putIfAbsent(a, new HashSet<>());
                if (!a.equals(b)) {
                    friends.putIfAbsent(b, new HashSet<>());

                    friends.get(a).add(b);
                    friends.get(b).add(a);
                }
            }

            Queue<String> q = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();

            List<Long> list = new ArrayList<>();

            long sum = 0;
            for (String str : friends.keySet()) {
                if (!visited.contains(str)) {
                    visited.add(str);
                    q.offer(str);

                    long con = 0;
                    while (!q.isEmpty()) {
                        String p = q.poll();

                        if (friends.get(p) != null)
                            for (String neighbors : friends.get(p)) {
                                if (!visited.contains(neighbors)) {
                                    visited.add(neighbors);
                                    q.offer(neighbors);
                                }
                            }

                        con++;
                    }
                    list.add(con);

                }
            }

            list.sort(Collections.reverseOrder());


            for (Long con : list) {
                if (c0 >= con) c0 -= con;
                else if (c1 >= con) c1 -= con;
                else sum += con;
            }

            System.out.println(sum);

        }
    }


}
