package Level_A;

import java.util.*;

public class FormingTeams {

    //this problem asks: how many loop do we have, we will count loops using bfs :))

    private static Scanner scan= new Scanner(System.in);

    public static void main(String [] args){
        int n= scan.nextInt();
        int m= scan.nextInt();

        Hashtable<Integer, HashSet<Integer>> ht= new Hashtable<>();

        int loopCount= 0;

        for(int i= 0; i< m; i++){
            int a= scan.nextInt();
            int b= scan.nextInt();

            ht.putIfAbsent(a, new HashSet<>());
            ht.putIfAbsent(b, new HashSet<>());

            ht.get(a).add(b);
            ht.get(b).add(a);
        }

        //search
        Queue<Integer> q= new LinkedList<>();
        HashSet<Integer> visited= new HashSet<>();

        for(int node: ht.keySet()){
            //for each connected component do we have loop?

            if(!visited.contains(node)){
                q.offer(node); //visited.add(node);
                boolean isLoop= false;
                //connected component
                while (!q.isEmpty()) {
                    int size= q.size();
                    HashSet<Integer> loopDetect= new HashSet<>();

                    while(size != 0){
                        Integer p= q.poll();
                        visited.add(p); loopDetect.add(p);

                        for(int neighbors: ht.get(p)){
                            if(!loopDetect.contains(neighbors) && !visited.contains(neighbors)){
                                q.offer(neighbors);
                            }
                            else if(loopDetect.contains(neighbors)){
                                isLoop= true;
                            }
                        }
                        size--;
                    }

                }

                if(isLoop){
                    loopCount++;
                }
            }

        }

        if((n - loopCount) % 2 != 0){
            System.out.println(loopCount + 1);
        }
        else{
            System.out.println(loopCount);
        }
    }
}
