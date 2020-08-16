package CodeForces.Level_B;

import java.util.Scanner;

public class BurningMidnightOil {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int lines= scan.nextInt();
        int k= scan.nextInt();

        if(k > lines){
            System.out.println(lines); return;
        }

        int low = k;
        int high = lines;

        Integer min= Integer.MAX_VALUE;

        while(low < high){
            int mid= (low + high) / 2;

            double time= (( (lines * 1.0) / mid) * ( (1.0 / k) - 1))+ 1.0;
            if(time > 0.0) {
                time = 1.0 / time;

                time = ((Math.log(time) / Math.log(k))) - 1;
            }

            if(time >= 0.0){
                //calculate expression

                int timeB= 0;
                int m= 0;
                while (true){
                    m += (int) Math.floor(mid * Math.pow(1.0 / k, timeB));

                    if((int)Math.floor(mid * Math.pow(1.0 / k, timeB))== 0){
                        if(m >= lines){
                            min = Math.min(min, mid);
                            high = mid;
                        }
                        else{
                            low = mid + 1;
                        }
                        break;
                    }

                    timeB++;
                }
            }
            else {
                low = mid + 1;
            }

        }

        System.out.println(min);
    }
}
