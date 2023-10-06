import java.util.LinkedList;
import java.util.Queue;


class Solution {
    
   public static int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] mapArr = maps;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        int count = 0;

        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
                int[] tmp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    if (tmp[0] + dx[i] >= 0 && tmp[0] + dx[i] < mapArr.length && tmp[1] + dy[i] >= 0 &&
                            tmp[1] + dy[i] < mapArr[0].length) {
                        if (mapArr[tmp[0] + dx[i]][tmp[1] + dy[i]] == 1 && !visited[tmp[0] + dx[i]][tmp[1] + dy[i]]) {
                            queue.add(new int[] {tmp[0] + dx[i], tmp[1] + dy[i]});
                            mapArr[tmp[0] + dx[i]][tmp[1] + dy[i]] += mapArr[tmp[0]][tmp[1]];
                            visited[tmp[0] + dx[i]][tmp[1] + dy[i]] = true;
                        }
                    }
                
            }

        }
        count = mapArr[maps.length-1][maps[0].length-1];
        if (count == 1) {
            count = -1;
        }
//        System.out.println(count);
        return count;
    }
}