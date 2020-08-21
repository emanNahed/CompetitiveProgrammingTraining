package GUCTraining.Public.adhoc;

import java.util.Hashtable;
import java.util.Scanner;

public class BusesBetweenCities {
    static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int a= scan.nextInt();
        int ta= scan.nextInt();

        int b= scan.nextInt();
        int tb= scan.nextInt();

        String []time= scan.next().split(":");
        int hr= Integer.parseInt(time[0]);
        int min= Integer.parseInt(time[1]);

        Hashtable<Integer, Integer> waitingList= new Hashtable<>();

        int simonTime= hr*60 + min;
        int reachSimon= simonTime + ta;
        int count = 0;
        for(int hour= 5; hour <= 23; hour++){
            for(int minute= 0; minute <= 59; minute++){
                int currentTime= hour * 60 + minute;

                if((currentTime - 5 * 60) % b == 0) {
                    waitingList.putIfAbsent(currentTime + tb, currentTime);
                    if(currentTime > simonTime && currentTime < reachSimon) count++;
                }
                if(waitingList.get(currentTime) != null)
                    waitingList.remove(currentTime);

                if(currentTime == simonTime)
                    count+= waitingList.size();
                if(currentTime == reachSimon) {
                    hour = 25;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
