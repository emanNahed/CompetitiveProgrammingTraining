package CodeForces.Level_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;

public class PresidentOffice {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String [] officeData= scan.readLine().split(" ");

        int n= Integer.parseInt(officeData[0]);
        int m= Integer.parseInt(officeData[1]);
        char r= officeData[2].charAt(0);

        char [][] office= new char[n][m];

        HashSet<Index> persidentIndecies= new HashSet<>();
        HashSet<Character> visited= new HashSet<>();

        for(int i= 0; i< n; i++){
            String read= scan.readLine();
            for(int j= 0; j< m; j++){
                char ch= read.charAt(j);
                if(ch == r) persidentIndecies.add(new Index(i,j));
                office[i][j]= ch;
            }
        }
        int count = 0;
        for(Index index: persidentIndecies){
            int s= index.row; int e= index.col;

            //add neighbors
            if(s > 0 && office[s-1][e] !='.' && office[s-1][e] != r && !visited.contains(office[s-1][e])){
                count++;
                visited.add(office[s-1][e]);
            }
            if(s < n - 1 && office[s+1][e] !='.' && office[s+1][e] != r && !visited.contains(office[s+1][e])){
                count++;
                visited.add(office[s+1][e]);
            }

            if(e > 0 && office[s][e - 1] !='.' && office[s][e - 1] != r && !visited.contains(office[s][e - 1])){
                count++;
                visited.add(office[s][e - 1]);
            }

            if(e < m- 1 && office[s][e + 1] !='.' && office[s][e + 1] != r && !visited.contains(office[s][e + 1])){
                count++;
                visited.add(office[s][e + 1]);
            }
        }

        System.out.println(count);
    }

    static class Index{
        int row;
        int col;

        Index(int row, int col){
            this.row= row;
            this.col= col;
        }
    }
}