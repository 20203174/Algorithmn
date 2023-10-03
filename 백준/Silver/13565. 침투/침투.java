import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] figure = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        boolean result = false;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < N; j++) {
                figure[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int j = 0; j < N; j++) {
            if (figure[0][j] == 0 && !visited[0][j]) {
                dfs(visited, figure, 0, j);
            }
        }

        for (int i = 0; i < N; i++) {
            if (visited[M - 1][i]) {
                result = true;
            }
        }
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void dfs(boolean[][] visited, int[][] figure, int i, int j) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (i + 1 < figure.length && figure[i + 1][j] == 0 && !visited[i + 1][j]) {
            dfs(visited, figure, i + 1, j);
        }
        if (j - 1 >= 0 && figure[i][j - 1] == 0 && !visited[i][j - 1]) {
            dfs(visited, figure, i, j - 1);
        }
        if (j + 1 < figure[0].length && figure[i][j + 1] == 0 && !visited[i][j + 1]) {
            dfs(visited, figure, i, j + 1);
        }
        if (i - 1 >= 0 && figure[i - 1][j] == 0 && !visited[i - 1][j]) {
            dfs(visited, figure, i - 1, j);
        }
    }
}
