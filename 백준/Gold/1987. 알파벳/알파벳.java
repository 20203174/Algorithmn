import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.out;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static int[][] visited;
    static int[] log;
    static int max = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new int[R + 1][C + 1];
        log = new int[200];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            map[i] = line.replace(" ", "").toCharArray();
        }
        visited[0][0] = 1;
        dfs(new Node(0, 0, 1));
        out.println(max);

    }

    private static void dfs(Node node) {
        if (log[map[node.x][node.y]] >= 1) {
            log[map[node.x][node.y]] += 1;
            max = Math.max(max, node.count - 1);
            return;
        }
        log[map[node.x][node.y]] += 1;

        for (int i = 0; i < 4; i++) {
            int x = node.x + dx[i];
            int y = node.y + dy[i];
            if (x >= 0 && x < R && y >= 0 && y < C && visited[x][y] == 0) {
                visited[x][y] = 1;
                dfs(new Node(x, y, node.count + 1));
                log[map[x][y]] -= 1;
                visited[x][y] = 0;
            }
        }
        max = Math.max(max, node.count);
    }
}