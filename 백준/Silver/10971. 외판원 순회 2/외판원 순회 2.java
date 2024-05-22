import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] visited;
    static int[][] map;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            dfs(i, i, 0, 0);
        }

        System.out.println(result);
    }

    private static void dfs(int start, int cur, int count, int sum) {
        if(count == N-1) {
            if(map[cur][start] > 0) {
                sum += map[cur][start];
                result = Math.min(sum, result);
            }
        }

        for(int i = 1; i <= N; i++) {
            if(visited[i] != 0) {
                continue;
            }
            if(i==start) {
                continue;
            }
            if(map[cur][i] == 0) {
                continue;
            }

            visited[i] = 1;
            dfs(start, i, count+1, sum + map[cur][i]);
            visited[i] = 0;
        }
    }
}