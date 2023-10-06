import java.util.LinkedList;
import java.util.Queue;


class Solution {
    
   public static int solution(int[][] maps) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = maps.length;
        int columns = maps[0].length;

        boolean[][] visited = new boolean[rows][columns];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int count = 1; // 시작 위치도 카운트에 포함

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                
                if (x == rows - 1 && y == columns - 1) {
                    return count; // 목적지에 도달했을 때 탐색 종료
                }

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (isValid(newX, newY, rows, columns) && maps[newX][newY] == 1 && !visited[newX][newY]) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            count++;
        }

        return -1; // 목적지에 도달하지 못한 경우
    }
    private static boolean isValid(int x, int y, int rows, int columns) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }
}