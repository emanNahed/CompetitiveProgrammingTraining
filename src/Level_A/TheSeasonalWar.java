package Level_A;

import java.util.*;

public class TheSeasonalWar {


    private static Scanner input= new Scanner(System.in);

    public static void main(String [] args){

        int games= 1;
        while(input.hasNext()) {
            int n = input.nextInt();

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String str = input.next();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(str.charAt(j) + "");
                }
            }


            boolean[][] visited = new boolean[n][n];

            Queue<Cell> q = new LinkedList<>();

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        q.offer(new Cell(i, j));

                        while (!q.isEmpty()) {
                            Cell current = q.poll();

                            if (!visited[current.i][current.j]) {
                                visited[current.i][current.j] = true;
                            }
                            List<Cell> neighbourCells = neighbour(arr, current);

                            for (Cell c : neighbourCells) {
                                if (!visited[c.i][c.j])
                                    q.offer(c);
                            }
                        }

                        count++;
                    }
            }

            System.out.println("Image number " + games + " contains " + count + " war eagles.");
            games++;
        }
    }

    private static List<Cell> neighbour(int[][] arr, Cell current) {
        List<Cell> n= new ArrayList<>();

        int rc= current.i;
        int cc= current.j;

        //right n
        if(cc < arr.length - 1 && arr[rc][cc+1] == 1){
            n.add(new Cell(rc,cc+1));
        }
        //buttom
        if(rc < arr.length - 1 && arr[rc + 1][cc] == 1){
            n.add(new Cell(rc+1,cc));
        }
        //b right
        if(rc < arr.length - 1 &&cc < arr.length - 1&& arr[rc + 1][cc+1] == 1){
            n.add(new Cell(rc+1,cc+1));
        }
        //b left
        if(rc < arr.length - 1 && cc > 0 && arr[rc+1][cc-1] == 1){
            n.add(new Cell(rc+1,cc-1));
        }
        return n;
    }

    static class Cell{
        int i;
        int j;

        Cell(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
