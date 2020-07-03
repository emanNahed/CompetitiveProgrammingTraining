package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Hashtable;

public class DreamoonAndWiFi {
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String send = scan.readLine();
        String receive = scan.readLine();

        Hashtable<Character, Integer> sendSignals = new Hashtable<>();
        Hashtable<Character, Integer> receiveSignals = new Hashtable<>();


        for (Character ch : send.toCharArray()) {
            sendSignals.putIfAbsent(ch, 0);
            sendSignals.put(ch, sendSignals.get(ch) + 1);
        }

        for (Character ch : receive.toCharArray()) {
            receiveSignals.putIfAbsent(ch, 0);
            receiveSignals.put(ch, receiveSignals.get(ch) + 1);
        }

        if (receiveSignals.get('?') == null) {
            int a = (receiveSignals.get('+') != null) ? receiveSignals.get('+') : 0;
            int b = (sendSignals.get('+') != null) ? sendSignals.get('+') : 0;

            int c = (receiveSignals.get('-') != null) ? receiveSignals.get('-') : 0;
            int d = (sendSignals.get('-') != null) ? sendSignals.get('-') : 0;

            if (a == b && c == d) {
                System.out.printf("%.9f", (float) 1);
            } else {
                System.out.printf("%.9f", (float) 0);
            }

            return;
        }

        if (receiveSignals.get('+') != null)
            while (receiveSignals.get('+') != 0) {
                if (sendSignals.get('+') == null || sendSignals.get('+') == 0) {
                    System.out.printf("%.9f", (float) 0);
                    return;
                }

                sendSignals.put('+', sendSignals.get('+') - 1);
                receiveSignals.put('+', receiveSignals.get('+') - 1);
            }

        if (receiveSignals.get('-') != null)
            while (receiveSignals.get('-') != 0) {
                if (sendSignals.get('-') == null || sendSignals.get('-') == 0) {
                    System.out.printf("%.9f", (float) 0);
                    return;
                }

                sendSignals.put('-', sendSignals.get('-') - 1);
                receiveSignals.put('-', receiveSignals.get('-') - 1);
            }

        int places = receiveSignals.get('?');
        int a= (sendSignals.get('+') == null)? 0: sendSignals.get('+');
        int b= (sendSignals.get('-') == null)? 0: sendSignals.get('-');

        // combination rule (places! / (a! * b!)) / 2 ^ places

        double out= 1;

        for(int i= places ; i> Math.max(a, b); i--){
            out *= i;
        }

        double out2= 1;
        for(int i= Math.min(a, b); i>= 1; i--){
            out2 *= i;
        }

        out /= (out2 * Math.pow(2, places));

        System.out.printf("%.9f", out);
    }
}
