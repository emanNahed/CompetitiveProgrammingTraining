package GirlsACPC;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class JoanClarke {

    public static void main(String [] args) throws IOException {
        Reader scan= new Reader("joan.in");

        int t= scan.nextInt();

        while(t-- != 0){
            int nd= scan.nextInt();

            Hashtable<Character, Integer> ht= new Hashtable<>();

            while(nd-- != 0){
                String str= scan.readLine();
                ht.putIfAbsent(str.charAt(0), 0);
                ht.put(str.charAt(0), ht.get(str.charAt(0)) + 1);
            }

            int c= scan.nextInt();

            List<String> output= new ArrayList<>();
            while(c-- != 0){
                String str= scan.readLine();


                boolean confunsing = false;
                boolean oops= false;
                for(int i= 0; i< str.length(); i++){
                    Integer a= ht.get(str.charAt(i));
                    if(a== null){
                        oops = true;
                        break;
                    }
                    else if(a != 1){
                        confunsing= true;
                    }
                }

                if(oops) output.add("Oops");
                else if(confunsing) output.add("Confusing");
                else output.add("Unique");
            }

            for(String str: output) System.out.println(str);
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
