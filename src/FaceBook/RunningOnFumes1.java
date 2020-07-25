package FaceBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RunningOnFumes1 {

    static int m;
    static long[] costs;
    static List<List<Long>> dp;
    public static void main(String [] args) throws IOException {
        SScanner scan = new SScanner(new FileInputStream("input.txt"));
        FileWriter fr = new FileWriter("output.out");

        int t= Integer.parseInt(scan.nextLine());
        int current= 0;
        while (current != t){
            int n= scan.nextInt();
            m= scan.nextInt();

            costs= new long[n];
            for(int i= 0; i< n; i++)
                costs[i]= scan.nextLong();

            dp= new ArrayList<>();
            for(int i= 0; i< n; i++) {
                List<Long> longs= new ArrayList<>();
                for(int j= 0; j< m + 1; j++){
                    longs.add( (long)-1);
                }
                dp.add(longs);
            }
            long result= minCost(0, m);

            current++;
            fr.write("Case #" + current+ ": " +(result < 0? -1: result ));

            if(current != t) fr.write("\n");
        }
        fr.close();
    }

    private static long minCost(int idx, int gallons) {
        if(idx == costs.length) return 0;
        if(gallons < 0) return Long.MAX_VALUE; //ignore this path as you can

        if(dp.get(idx).get(gallons) != -1) return dp.get(idx).get(gallons);

        if(costs[idx] == 0) return minCost(idx + 1, gallons - 1);

        long take= costs[idx] + minCost(idx + 1, m - 1);
        long leave= minCost(idx + 1, gallons - 1);

        dp.get(idx).set(gallons, Math.min(take, leave));
        return   Math.min(take, leave);
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