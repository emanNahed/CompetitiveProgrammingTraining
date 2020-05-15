package Level_A;

import java.util.HashSet;
import java.util.Scanner;

public class BoyOrGirl {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        HashSet<Character> count= new HashSet<>();

        String name= input.nextLine();

        for(int i= 0; i< name.length(); i++){
            count.add(name.charAt(i));
        }

        if(count.size() % 2 != 0){
            System.out.println("IGNORE HIM!");
        }
        else{
            System.out.println("CHAT WITH HER!");
        }

    }
}
