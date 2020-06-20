package Level_A;

import java.util.Scanner;

public class ValeraAndX {

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
         int n= scan.nextInt();
         scan.nextLine();


         String [] lines= new String[n];

         for(int i= 0; i< n; i++){
             lines [i] = scan.nextLine();
         }

         char a= lines[0].charAt(0);
         char b= lines[0].charAt(1);

         if(a == b){
             System.out.println("NO");
             return;
         }

         for(int i= 0; i< n; i++){
             if(lines[i].charAt(i) != a || lines[i].charAt(n - i - 1) != a){
                 System.out.println("NO");
                 return;
             }

             for(int j= 0; j< n; j++){
                 if(j != i && j != n - i - 1){
                     if(lines[i].charAt(j) != b){
                         System.out.println("NO");
                         return;
                     }
                 }
             }
         }

        System.out.println("YES");
    }
}
