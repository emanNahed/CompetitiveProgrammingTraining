package Level_A;

import java.util.Hashtable;
import java.util.Scanner;

public class Keyboard {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        String [] str= {"qwertyuiop",
                        "asdfghjkl;",
                        "zxcvbnm,./"};


        Hashtable<Character,int []> ht= new Hashtable<>();

        for(int i= 0; i< 3; i++){
            for(int j= 0; j< str[i].length(); j++){
                ht.put(str[i].charAt(j),new int[]{i,j});
            }
        }


        String n= input.next();
        String s= input.next();

        StringBuilder sb= new StringBuilder(s);
        int move= 0;
        if(n.equals("R")){
            move = -1;
        }
        else{
            move = 1;
        }


        for(int i= 0; i< s.length(); i++){
            int row= ht.get(s.charAt(i))[0];
            int col= ht.get(s.charAt(i))[1];
            sb.setCharAt(i,str[row].charAt(col+move));
        }

        System.out.println(sb);
    }
}
