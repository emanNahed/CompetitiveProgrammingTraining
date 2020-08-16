package CodeForces.Level_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Barcode {

    static int x, y;
    static long[][][] arr;
    static long [] dotCount; // to reduce time :((
    static List<List<Character>> picture;
    public static void main(String [] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] line= scan.readLine().split(" ");

        int n= Integer.parseInt(line[0]);
        int m= Integer.parseInt(line[1]);
        dotCount= new long[m];

        x= Integer.parseInt(line[2]);
        y= Math.min(m, Integer.parseInt(line[3]));

        picture= new ArrayList<>();

        for(int i= 0; i< n; i++){
            String str= scan.readLine();
            List<Character> l= new ArrayList<>();
            for(int j= 0; j< m; j++){
                l.add(str.charAt(j));
                if(str.charAt(j) == '.') dotCount[j]++;
            }
            picture.add(l);
        }

        if(x == 1 && y == m){
            System.out.println( sillySolution());
            return;
        }

       arr = new long[m][m][3];


        System.out.println(minChange(0, 2, 0));
    }

    private static long sillySolution() {
        long out= 0;
        for(int i= 0; i< picture.get(0).size(); i++)
            out += Math.min(picture.size() - dotCount[i], dotCount[i]);

        return out;
    }


    private static long minChange(int index, int previousColor, int num) {
        if(index == picture.get(0).size())
            if (num < x)
                return Integer.MAX_VALUE; //unacceptable sequence :)
            else
                return 0;


        boolean oneColorSame= (num < x && num != 0);
        boolean twoColors= ((num >= x && num < y) || num == 0);
        boolean oneColorDiff= (num >= y);


        if(oneColorSame && arr[index][num][previousColor] != 0)
            return  arr[index][num][previousColor];


        long min= Integer.MAX_VALUE;
        if(oneColorSame){
            long change= (previousColor == 0)? dotCount[index]: picture.size() - dotCount[index];
            min =arr[index][num][previousColor]=  Math.min(min, change +minChange(index + 1, previousColor, num + 1));
        }

        else if(twoColors){
            long change0= dotCount[index];
            long change1= picture.size() - dotCount[index];
            long a=  change0 + minChange( index + 1, 0, (previousColor == 0) ? num + 1 : 1);
            long b=  change1 + minChange(index + 1, 1, (previousColor == 1) ? num + 1 : 1);

            min = arr[index][num][previousColor]=Math.min(min,  Math.min(a, b));
        }

        else if (oneColorDiff){
            int prev= (previousColor == 0)? 1: 0;
            long change= (prev == 0)? dotCount[index]: picture.size() - dotCount[index];

            min = arr[index][num][previousColor]= Math.min(min, change + minChange(index + 1,prev,1));
        }


        return min;
    }


    private static void intializeArray(long[][][] rests) {
        for(int i= 0; i< rests.length; i++){
            long [][] b= new long[rests[0].length][3];
            for(int j= 0; j< rests[0].length; j++) {
                long[] a = new long[3];
                Arrays.fill(a, -1);
                b[j] = a;
            }
            rests[i]= b;
        }
    }

}
