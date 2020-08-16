package CodeForces.Level_B;

import java.io.*;
import java.rmi.server.ExportException;
import java.util.*;

public class KnightMoves {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while (!(line = scan.readLine()).isEmpty()) {
                String[] reads = line.split(" ");

                String start = reads[0];
                String reach = reads[1];

                Queue<String> q = new LinkedList<>();
                HashSet<String> visited = new HashSet<>();
                q.offer(start);
                visited.add(start);

                int count = -1;
                boolean found = false;
                while (!q.isEmpty()) {
                    int size = q.size();

                    while (size != 0) {
                        String p = q.poll();
                        if (p.equals(reach)) {
                            found = true;
                            break;
                        }

                        List<String> neighbors = addNeighbors(visited, p);

                        for (String neighbor : neighbors) {
                            q.offer(neighbor);
                        }

                        size--;
                    }
                    count++;
                    if (found) break;
                }

                System.out.println("To get from " + start + " to " + reach + " takes " + count + " knight moves.");
            }
        }
        catch (Exception e){}

    }

    private static List<String> addNeighbors(HashSet<String> visited, String p) {
        List<String> result= new ArrayList<>();

        int i= Integer.parseInt(p.charAt(1) + "");
        char j= p.charAt(0);



        if(i > 2 && j > 'a' && !visited.contains((Character.toChars(j - 1))[0]+"" + (i - 2))){
            result.add((Character.toChars(j - 1))[0]+"" + (i - 2));
            visited.add((Character.toChars(j - 1))[0]+"" + (i - 2));
        }
        if(i < 7  && j > 'a' && !visited.contains((Character.toChars(j - 1)[0])+"" + (i + 2))){
            result.add((Character.toChars(j - 1))[0]+"" + (i + 2));
            visited.add((Character.toChars(j - 1))[0]+"" + (i + 2));
        }

        if(j < 'h'&& i > 2 && !visited.contains(Arrays.toString(Character.toChars(j + 1)) +"" + (i-2))){
            result.add((Character.toChars(j + 1))[0]+"" + (i-2));
            visited.add((Character.toChars(j + 1))[0]+"" + (i-2));
        }

        if(j < 'h' && i < 7 && !visited.contains(Character.toChars(j + 1)[0] +"" + (i+2))){
            result.add(Character.toChars(j + 1)[0]+"" + (i+2));
            visited.add(Character.toChars(j + 1)[0]+"" + (i+2));
        }
        if(i > 1 && j > 'b' && !visited.contains((Character.toChars(j - 2))[0]+"" + (i - 1))){
            result.add((Character.toChars(j - 2))[0]+"" + (i - 1));
            visited.add((Character.toChars(j - 2))[0]+"" + (i - 1));
        }
        if(i < 8  && j > 'b' && !visited.contains((Character.toChars(j - 2)[0])+"" + (i + 1))){
            result.add((Character.toChars(j - 2))[0]+"" + (i + 1));
            visited.add((Character.toChars(j - 2))[0]+"" + (i + 1));
        }

        if(j < 'g'&& i > 1 && !visited.contains(Arrays.toString(Character.toChars(j + 2)) +"" + (i-1))){
            result.add((Character.toChars(j + 2))[0]+"" + (i-1));
            visited.add((Character.toChars(j + 2))[0]+"" + (i-1));
        }

        if(j < 'g' && i < 8 && !visited.contains(Character.toChars(j + 2)[0] +"" + (i+1))){
            result.add(Character.toChars(j + 2)[0]+"" + (i+1));
            visited.add(Character.toChars(j + 2)[0]+"" + (i+1));
        }


        return result;
    }
}