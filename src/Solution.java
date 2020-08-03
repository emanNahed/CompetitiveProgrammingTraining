import java.util.*;


class Solution{
    public static void main(String [] args){
        Scanner scan= new Scanner(System.in);

        long n= scan.nextLong();
        int m= scan.nextInt();
        int s= scan.nextInt();
        int q= scan.nextInt();

        TreeMap<Long, Integer> balls= new TreeMap<>();
        for(int i= 0; i< m; i++)
            balls.putIfAbsent(scan.nextLong(), 1);

        while(s-- != 0){
            long a= scan.nextLong();
            long b= scan.nextLong();

            if(balls.get(a) == null && balls.get(b) != null){
                balls.remove(b);
                balls.putIfAbsent(a, 1);
            }
            else if(balls.get(a) != null && balls.get(b) == null){
                balls.remove(a);
                balls.putIfAbsent(b, 1);
            }
        }


        //prefix sum
        for(Long item: balls.keySet())
            balls.put(item, balls.get(item) + (balls.lowerKey(item) != null? balls.get(balls.lowerKey(item)): 0));

        System.out.println(balls);
        while(q-- != 0){
            long a= scan.nextLong();
            long b= scan.nextLong();

            long print= balls.floorKey(b) != null? balls.get(balls.floorKey(b)): 0;
            print -= balls.lowerKey(a) != null? balls.get(balls.lowerKey(a)): 0;
            print = print < 0? 0: print;
            System.out.print(print + " ");
        }
        System.out.println();
    }
}