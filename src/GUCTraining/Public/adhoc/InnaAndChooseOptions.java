package GUCTraining.Public.adhoc;


import java.util.Arrays;
import java.util.Scanner;

public class InnaAndChooseOptions {

    static Scanner scan = new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        int [][] arr= {{1, 12}, {2, 6}, {3, 4}, {4,3},{6,2}, {12,1}};
        boolean[] test= new boolean[arr.length];
        while (n-- != 0){
            String str= scan.next();

            for(int i= 0; i< arr.length; i++){
                int row= arr[i][0]; //1
                int col= arr[i][1]; //12

                boolean oneCol= false;
                for(int x= 0; x< col && !oneCol; x++){
                    oneCol = true;
                    for(int y= x; y< str.length(); y+= col)
                        if (str.charAt(y) != 'X') {
                            oneCol = false;
                            break;
                        }
                }
                test[i]= oneCol;
            }

            int count = 0;
            StringBuilder stringBuilder= new StringBuilder();
            for(int i= 0; i< test.length; i++){
                if(test[i]){
                    count++;
                    stringBuilder.append(arr[i][0]).append("x").append(arr[i][1]).append(" ");
                }
            }

            System.out.println(count+ " " + stringBuilder);
        }
    }
}
