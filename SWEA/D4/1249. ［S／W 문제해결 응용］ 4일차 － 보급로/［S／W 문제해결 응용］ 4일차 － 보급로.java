import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution 
{
    static class Spot {
        int x, y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    public static void main( String[] args ) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            int length = Integer.parseInt(br.readLine());
            int[][] arr = new int[length][length];
            int[][] visited = new int[length][length];

            for(int j = 0; j < length; j++) {
                String line = br.readLine();
                for(int z = 0; z < length; z++) {
                    arr[j][z] = line.charAt(z) - '0';
                    visited[j][z] = 999999999;
                }
            }
            System.out.println("#" + i + " " + bfs(arr, visited, length));
        }
        
    }

    private static int bfs(int[][] arr, int[][] visited, int length) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
    
        Queue<Spot> queue = new LinkedList<>();

        queue.offer(new Spot(0, 0));
        visited[0][0] = arr[0][0];
        while(!queue.isEmpty()) {
            Spot curr = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx < 0 || nx >= length || ny < 0 || ny >= length)continue;
                if (visited[nx][ny] > visited[curr.x][curr.y] + arr[nx][ny]) {
                    visited[nx][ny] = visited[curr.x][curr.y] + arr[nx][ny];
                    queue.offer(new Spot(nx, ny));
                }
            }
        }
        return visited[length-1][length-1];
    }

}
