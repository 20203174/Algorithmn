import java.util.LinkedList;
import java.util.Queue;


class Solution {
    
   public static int solution(int[][] maps){
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean isFinished = false;
        int count =0;

        while(!queue.isEmpty()) {
            int tmpSize = queue.size();
            for(int i = 0; i < tmpSize; i++) {
                int[] tmp = queue.poll();
                bfs(queue, visited, maps, tmp[0], tmp[1]);
                if(tmp[0] == maps.length-1 && tmp[1] == maps[0].length-1) {
                    count++;
                    return count;
                }

            }
            
            count++;
        }
        return -1;
    }


    public static void bfs(Queue<int[]>queue, boolean[][] visited, int[][] matrix, int x, int y) {

        if(x + 1 < matrix.length && matrix[x + 1][y] == 1 && !visited[x + 1][y]) {
            queue.add(new int[]{x+1, y});
            visited[x+1][y] = true;
        }
        if(x - 1 >= 0 && matrix[x - 1][y] == 1 && !visited[x - 1][y]) {
            queue.add(new int[]{x-1, y} );
            visited[x - 1][y] = true;
        }
        if(y + 1 < matrix[0].length && matrix[x][y+1] == 1 && !visited[x][y+1]) {
            queue.add(new int[]{x, y+1});
            visited[x][y+1] = true;
        }
        if(y - 1 >= 0 && matrix[x][y-1] == 1 && !visited[x][y-1]) {
            queue.add(new int[]{x, y-1});
            visited[x][y-1] = true;
        }
        visited[x][y] = true;
    }

}