package GirlsACPC;

import java.io.*;
import java.util.*;

public class HappyLand {

    public static void main(String [] args) throws IOException {
        Reader scan= new Reader("land.in");

        int t= scan.nextInt();

        while(t-- != 0){
            int pairs= scan.nextInt();

            int c0= scan.nextInt();
            int c1= scan.nextInt();
            Hashtable<String, HashSet<String>> friends= new Hashtable<>();

            while(pairs-- != 0){
                String [] fr= scan.readLine().split(" ");
                String a= fr[0]; String b= fr[1];

                friends.putIfAbsent(a, new HashSet<>());
                if(!a.equals(b)){
                    friends.putIfAbsent(b, new HashSet<>());

                    friends.get(a).add(b);
                    friends.get(b).add(a);
                }
            }

            Queue<String> q= new LinkedList<>();
            HashSet<String> visited= new HashSet<>();

            List<Long> list= new ArrayList<>();

            long sum=0;
            for(String str: friends.keySet()){
                if(!visited.contains(str)){
                    visited.add(str);
                    q.offer(str);

                    long con= 0;
                    while (!q.isEmpty()){
                        String p= q.poll();

                        if(friends.get(p) != null)
                        for(String neighbors: friends.get(p)){
                            if(!visited.contains(neighbors)){
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


            for(Long con: list){
                if(c0 >= con) c0 -= con;
                else if(c1 >= con) c1 -= con;
                else sum += con;
            }

            System.out.println(sum);

        }
    }



    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

}
