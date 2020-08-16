package CodeForces.Level_A;

import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String str = input.nextLine();

        int numbersLength = (int) Math.ceil(str.length() / 2.0);
        int[] arr = new int[numbersLength];
        int index = 0;
        for (int i = 0; i < str.length(); i += 2) {
            arr[index++] = Integer.parseInt(str.charAt(i) + "");
        }

        //why not to remember how to apply merge sort :P
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print('+');
            }
        }
    }
}