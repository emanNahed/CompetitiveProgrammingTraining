package CodeForces.Topiccs.stack_queue;

        import java.util.*;
public class PetyaAndCountryside {

    //to solve this question you can search about stock span problem
    //there is a more easy way to solve this problem, it acceptable in the codeforces, take O(n ^ 2).
    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();

        int [] arr= new int[n];

        for(int i= 0; i< n; i++){
            arr[i]= scan.nextInt();
        }

        Stack<Integer> stack= new Stack<>();
        int [] rankArray= new int[n];

        for(int i= 0; i< n; i++){
            if(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();


            rankArray[i] = (stack.isEmpty())? i + 1: i - stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i= n- 1; i>= 0; i--){
            if(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();

            rankArray[i] += (stack.isEmpty())? n - i - 1 : stack.peek() - i - 1 /* -1 because of duplicate*/;

            stack.push(i);
        }



        int max= 0;
        for(int i= 0; i< n; i++){
            max= Math.max(max, rankArray[i]);
        }

        System.out.println(max);
    }
}
