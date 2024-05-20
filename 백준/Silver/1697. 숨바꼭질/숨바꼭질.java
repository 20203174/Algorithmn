import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        bfs(N);
    }
    private static void bfs(int N) {
        int next = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == K) {
                System.out.println(visited[curr]);
                break;
            }

            for(int i = 0; i < 3; i++) {
                if(i == 0) {
                    next = curr + 1;
                } else if(i == 1) {
                    next = curr - 1;
                } else {
                    next = curr * 2;
                }

                if(next <= 100000 && next >= 0 && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[curr] + 1;
                }

            }
        }
    }
}