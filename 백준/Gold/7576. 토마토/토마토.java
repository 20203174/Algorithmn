import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int count = 0;
    static int[][] map;
    static int total;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int currentCount = 0;

    static class Node {
        int x;
        int y;
        int count;
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        total = M * N;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 1) {
                    count++;
                } else if(tmp == -1) {
                    total--;
                }
            }
        }

        bfs();

        if(count == total) {
            System.out.println(currentCount);
        } else {
            System.out.println(-1);
        }

    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    queue.add(new Node(i, j, 0));
                }
            }
        }
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            currentCount = cur.count;

            for(int i = 0; i < 4; i++) {
                if(cur.x + dx[i] >= 0 && cur.x + dx[i] < N
                && cur.y + dy[i] >= 0 && cur.y + dy[i] < M
                && map[cur.x + dx[i]][cur.y + dy[i]] == 0) {
                    map[cur.x + dx[i]][cur.y + dy[i]] = 1;
                    count++;
                    queue.add(new Node(cur.x + dx[i], cur.y + dy[i], cur.count + 1));
                }
            }
        }
    }


}