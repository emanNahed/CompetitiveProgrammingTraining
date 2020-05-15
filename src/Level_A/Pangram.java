package Level_A;

        import java.util.HashSet;
        import java.util.Hashtable;
        import java.util.Scanner;

public class Pangram {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){

        int n= input.nextInt();

        String str= input.next();

        if(str.length() < 26){
            System.out.println("NO");
        }

        else{
            HashSet<Character> hs= new HashSet<>();

            for(int i= 0; i< str.length(); i++){
                hs.add(Character.toLowerCase(str.charAt(i)));
            }

            if(hs.size() < 26){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
