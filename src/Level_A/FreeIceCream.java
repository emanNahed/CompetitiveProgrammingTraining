package Level_A;

import java.util.Scanner;

public class FreeIceCream {

    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){
        int lines= input.nextInt();

        long packs= input.nextInt();

        int distressed= 0;

        input.nextLine();
        while(lines != 0){
            String str= input.next();
            int currentPack= input.nextInt();
            if(str.charAt(0)== '+'){
                packs += currentPack;
            }
            else{
                if(currentPack > packs){
                    distressed++;
                }
                else{
                    packs -= currentPack;
                }
            }

            lines--;
        }

        System.out.println(packs + " " + distressed);
    }
}
