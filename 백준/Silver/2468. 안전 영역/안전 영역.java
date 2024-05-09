import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 1;
        for(int height = 1; height <= 100; height++) {
            int tmp = solution(arr,height);
            if(max <= tmp) {
                max = tmp;
            }
        }
        System.out.println(max);

    }

    public static int solution(int[][] arr, int height) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(!visited[i][j] && arr[i][j] > height) {
                    dfs(arr, visited, i, j, height);
                    count ++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] arr, boolean[][] visited, int i, int j, int height) {
        visited[i][j] = true;
        if(i-1>=0 && !visited[i-1][j] && arr[i-1][j] > height) {
            dfs(arr, visited, i-1, j, height);
        }
        if(i+1 < arr.length && !visited[i+1][j] && arr[i+1][j] > height) {
            dfs(arr, visited, i+1, j, height);
        }
        if(j-1>=0 && !visited[i][j-1] && arr[i][j-1] > height) {
            dfs(arr, visited, i, j-1, height);
        }
        if(j+1 < arr.length && !visited[i][j+1] && arr[i][j+1] > height) {
            dfs(arr, visited, i, j+1, height);
        }
    }
}