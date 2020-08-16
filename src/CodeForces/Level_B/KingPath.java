package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KingPath {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] kingPositions= scan.readLine().split(" ");

        Node start= new Node(Integer.parseInt(kingPositions[0]), Integer.parseInt(kingPositions[1]));
        Node end= new Node(Integer.parseInt(kingPositions[2]), Integer.parseInt(kingPositions[3]));

        Hashtable<Integer, HashSet<int[]>> allowCells= new Hashtable<>();
        int n= Integer.parseInt(scan.readLine());
        for(int i= 0; i< n; i++){
            String [] periods= scan.readLine().split(" ");
            int r= Integer.parseInt(periods[0]);
            int s= Integer.parseInt(periods[1]);
            int e= Integer.parseInt(periods[2]);

            allowCells.putIfAbsent(r, new HashSet<>());
            allowCells.get(r).add(new int[]{s,e});
        }


        Queue<Node> q= new LinkedList<>();
        TreeSet<Node> visited= new TreeSet<>();
        q.offer(start); visited.add(start);

        int count= 0;

        while(!q.isEmpty()){
            int size= q.size();

            while(!q.isEmpty() && size != 0){
                Node p= q.poll();

                if(p.compareTo(end) == 0){
                    System.out.println(count);
                    return;
                }

                List<Node> neighbors= addNeighbors(p, visited, allowCells);
                for(Node neighbor: neighbors){
                    q.offer(neighbor);
                }
                size--;
            }
            count++;
        }

        System.out.println(-1);
    }

    private static List<Node> addNeighbors(Node p, TreeSet<Node> visited, Hashtable<Integer, HashSet<int[]>> allowCells) {
        List<Node> result= new ArrayList<>();

        int i= p.r;
        int j= p.c;

        if(i > 0){
            Node node= new Node(i - 1, j);
            if(!visited.contains(node)){
                if(allowCells.get(i - 1) != null){
                    for(int[] intervals: allowCells.get(i - 1)){
                        int a= intervals[0];
                        int b= intervals[1];
                        if (j >= a && j <= b) {
                            result.add(node);
                            visited.add(node);
                            break;
                        }
                    }
                }
            }
        }

        if(i < Math.pow(10, 9) - 1){
            Node node= new Node(i + 1, j);
            if(!visited.contains(node)) {
                if (allowCells.get(i + 1) != null) {
                    for (int[] intervals : allowCells.get(i + 1)) {
                        int a = intervals[0];
                        int b = intervals[1];
                        if (j >= a && j <= b) {
                            visited.add(node);
                            result.add(node);
                            break;
                        }
                    }
                }
            }
        }

        if(j > 0){
            Node node= new Node(i, j - 1);
            if(!visited.contains(node)){
                if(allowCells.get(i) != null) {
                    for (int[] intervals : allowCells.get(i)) {
                        int a = intervals[0];
                        int b = intervals[1];
                        if ((j - 1) >= a && (j - 1) <= b) {
                            visited.add(node);
                            result.add(node);
                            break;
                        }
                    }
                }
            }
        }

        if(j < Math.pow(10, 9) - 1){
            Node node= new Node(i, j + 1);
            if(!visited.contains(node)){
                if(allowCells.get(i) != null){
                    for(int[] intervals: allowCells.get(i)){
                        int a= intervals[0];
                        int b= intervals[1];
                        if ((j + 1) >= a && (j + 1) <= b) {
                            visited.add(node);
                            result.add(node);
                            break;
                        }
                    }
                }
            }
        }


        if(i > 0 && j > 0){
            Node node= new Node(i - 1, j - 1);
            if(!visited.contains(node)){
                if(allowCells.get(i - 1) != null){
                    for(int[] intervals: allowCells.get(i - 1)){
                        int a= intervals[0];
                        int b= intervals[1];
                        if ((j - 1) >= a && (j - 1) <= b) {
                            result.add(node);
                            visited.add(node);
                            break;
                        }
                    }
                }
            }
        }

        if(i < Math.pow(10, 9) - 1 && j > 0){
            Node node= new Node(i + 1, j - 1);
            if(!visited.contains(node)) {
                if (allowCells.get(i + 1) != null) {
                    for (int[] intervals : allowCells.get(i + 1)) {
                        int a = intervals[0];
                        int b = intervals[1];
                        if ((j - 1) >= a && (j - 1) <= b) {
                            visited.add(node);
                            result.add(node);
                            break;
                        }
                    }
                }
            }
        }

        if(j < Math.pow(10, 9) - 1  && i > 0 ){
            Node node= new Node(i - 1, j + 1);
            if(!visited.contains(node)){
                if(allowCells.get(i - 1) != null) {
                    for (int[] intervals : allowCells.get(i - 1)) {
                        int a = intervals[0];
                        int b = intervals[1];
                        if ((j + 1) >= a && (j + 1) <= b) {
                            visited.add(node);
                            result.add(node);
                            break;
                        }
                    }
                }
            }
        }

        if(j < Math.pow(10, 9) - 1 && i < Math.pow(10, 9) - 1){
            Node node= new Node(i + 1, j + 1);
            if(!visited.contains(node)){
                if(allowCells.get(i + 1) != null){
                    for(int[] intervals: allowCells.get(i + 1)){
                        int a= intervals[0];
                        int b= intervals[1];
                        if ((j + 1) >= a && (j + 1) <= b) {
                            visited.add(node);
                            result.add(node);
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }


    static class Node implements Comparable<Node>{
        int r;
        int c;

        Node(int r, int c){
            this.r= r;
            this.c= c;
        }


        @Override
        public int compareTo(Node node) {
            if(this.r - node.r != 0)
            return this.r - node.r;

            return this.c- node.c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
