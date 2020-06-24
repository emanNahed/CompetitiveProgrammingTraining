package CodeForces.Level_c;

import java.util.Scanner;

public class PerfectTeam {
    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args) {
        int q= scan.nextInt();

        while(q != 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            if (a == 0 || b == 0) {
                System.out.println(0);
                q--;
                continue;
            }
            int teams = 0;
            int num= Math.min(b, Math.min(c, a));
            teams += num;
            a -= num;
            b -= num;
            c = 0;

            if(a != b){
                if(a > b){
                    c += Math.min(b, a - b);
                    teams += c;
                    a = b;
                    b -= c;
                    a -= c;
                }
                else{
                    c += Math.min(a,b - a);
                    teams += c;
                    b = a;
                    b -= c;
                    a -= c;
                }
            }

            if(a == 0 || b == 0){
                System.out.println(teams);
                q--;
                continue;
            }

            int howTeam= (a + b) / 3;

            System.out.println(teams + howTeam);


            q--;
        }
    }
}
