import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Dequw {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args) {
       LinkedList<Character> l= new LinkedList<>();
        boolean start= false;
        boolean end= true;
        boolean key= true;
        int walk= 0;
       String s= scan.nextLine();
       for(int i= 0; i< s.length(); i++){
           if(s.charAt(i)== '*') {if(i > 0) if(walk == 0) l.removeLast(); else l.remove(walk-- - 1);}
           else if(s.charAt(i) == '<') {start= true;}
           else if(s.charAt(i) == '>') {start = false; walk = 0;}
           else if(s.charAt(i) == '#') key= !key;

           else if(Character.isDigit(s.charAt(i))){
               if(key){
                   if(!start){
                       l.addLast(s.charAt(i));
                   }
                   else{
                       l.add(walk++, s.charAt(i));
                   }
               }
           }
           else{
               if(!start){
                   l.addLast(s.charAt(i));
               }
               else{
                   l.add(walk++, s.charAt(i));
               }
           }
       }

        System.out.println( l);
    }
}
