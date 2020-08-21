package GUCTraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CircumferenceofaTree {

    static int [] diameter;

    public static void main(String [] args) throws IOException {
        SScanner scan= new SScanner(System.in);
        int n= scan.nextInt();

        Hashtable<Integer, HashSet<Integer>> tree= new Hashtable<>();

        if(n == 1){
            System.out.println(0); return;
        }
        int t= n - 1;
        int random= -1;
        while (t-- != 0){
            int a= scan.nextInt();
            int b= scan.nextInt();

            random= random == -1? a: random;
            tree.putIfAbsent(a, new HashSet<>());
            tree.putIfAbsent(b, new HashSet<>());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        //find diameter
        diameter= new int[300004];

        //take random node and find farthest node from it, it will be leaf
        int farthestLeaf= Bfs(tree, random, true);
        Arrays.fill(diameter,0);
        System.out.println(diameter[Bfs(tree, farthestLeaf, false)] * 3);
    }

    private static int Bfs(Hashtable<Integer, HashSet<Integer>> tree, int random, boolean n) {
        HashSet<Integer> visited= new HashSet<>();
        visited.add(random);

        Queue<Integer> q= new LinkedList<>();
        q.offer(random);

        int max= 0;
        int node= 0;

        while(!q.isEmpty()) {
            int p= q.poll();

            if(diameter[p] > max){
                max= diameter[p];
                node = p;
            }
            for(Integer neighbors: tree.get(p)){
                if(!visited.contains(neighbors)){
                    q.offer(neighbors);
                    diameter[neighbors] += diameter[p] + 1;
                    visited.add(neighbors);
                }
            }
        }

        //max diameter


        return node;
    }
}

class SScanner {
    StringTokenizer st;
    BufferedReader br;

    public SScanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String p= br.readLine();
            if(p == null)
                throw new IOException();
            st = new StringTokenizer(p);

        }

        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }

    public double nextDouble() throws IOException {
        String x = next();
        StringBuilder sb = new StringBuilder("0");
        double res = 0, f = 1;
        boolean dec = false, neg = false;
        int start = 0;
        if (x.charAt(0) == '-') {
            neg = true;
            start++;
        }
        for (int i = start; i < x.length(); i++)
            if (x.charAt(i) == '.') {
                res = Long.parseLong(sb.toString());
                sb = new StringBuilder("0");
                dec = true;
            } else {
                sb.append(x.charAt(i));
                if (dec)
                    f *= 10;
            }
        res += Long.parseLong(sb.toString()) / f;
        return res * (neg ? -1 : 1);
    }

    public boolean ready() throws IOException {
        return br.ready();
    }


}