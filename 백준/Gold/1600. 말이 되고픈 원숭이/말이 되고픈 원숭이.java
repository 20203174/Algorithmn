import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int W;
    static int H;
    static int[][][] visited;
    static int[][] map;
    static int flag = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] hx = {-2, -1, 2, 1, 1, 2, -2, -1};
    static int[] hy = {-1, -2, 1, 2, -2, -1, 1, 2};

    public static class Node {
        int i;
        int j;
        int count;
        int K;
        public Node(int i, int j, int count, int K) {
            this.i = i;
            this.j = j;
            this.K = K;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new int[H][W][K+1];

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                int obstacle = Integer.parseInt(st.nextToken());
                map[i][j] = obstacle;
                if(obstacle == 1) {
                    for(int k = 0; k <= K; k++) {
                        visited[i][j][k] = -1;
                    }
                }
            }
        }

        bfs(0, 0, 0, K);
        if(flag == 0) {
            System.out.println(-1);
        }


    }

    private static void bfs(int i, int j, int count, int K) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j, count, K));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.i == H - 1 && cur.j == W - 1) {
                System.out.println(cur.count);
                flag = 1;
                break;
            }

            for(int index = 0; index < hx.length; index++) {
                if(cur.K > 0 && cur.j+hy[index] < W && cur.j+hy[index] >= 0
                        && cur.i+hx[index] < H && cur.i+hx[index] >= 0
                        && visited[cur.i+hx[index]][cur.j+hy[index]][cur.K - 1] == 0) {
                    visited[cur.i+hx[index]][cur.j+hy[index]][cur.K-1] = 1;
                    q.add(new Node(cur.i+hx[index], cur.j+hy[index], cur.count + 1, cur.K - 1));
                }
            }

            for(int index = 0; index < 4; index++) {
                if(cur.j+dy[index] < W && cur.j+dy[index] >= 0
                        && cur.i+dx[index] < H && cur.i+dx[index] >= 0
                        && visited[cur.i+dx[index]][cur.j+dy[index]][cur.K] == 0) {
                    visited[cur.i+dx[index]][cur.j+dy[index]][cur.K] = 1;
                    q.add(new Node(cur.i+dx[index], cur.j+dy[index], cur.count + 1, cur.K));
                }
            }
        }
    }
}