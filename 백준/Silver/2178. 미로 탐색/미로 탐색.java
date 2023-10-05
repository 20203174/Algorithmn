import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    private static Queue<int[]> queue = new LinkedList<>();
    private static boolean[][] visited;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        visited = new boolean[matrix.length][matrix[0].length];



        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();
            String[] intArr = tmp.split("");
            matrix[i] = Stream.of(intArr).mapToInt(Integer::parseInt).toArray();
        }
        bfs(matrix);

        System.out.println(count);

    }

    public static void bfs(int[][] matrix) {
        queue.add(new int[]{0, 0});
        boolean isFinished = false;

        while(!isFinished) {
            int tmpSize = queue.size();
            for(int i = 0; i < tmpSize; i++) {
                int[] tmp = queue.poll();
                bfs(matrix, tmp[0], tmp[1]);
                if(tmp[0] == matrix.length-1 && tmp[1] == matrix[0].length-1) {
                    isFinished = true;
                }

            }
            count++;
        }
    }


    public static void bfs(int[][] matrix, int x, int y) {

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
