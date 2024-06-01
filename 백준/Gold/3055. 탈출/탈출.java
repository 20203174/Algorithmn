import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Node start;
    static int min = -1;
    static Map<Integer, int[][]> water;

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
        map = new int[R][C];
        visited = new int[R + 1][C + 1];
        water = new HashMap<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine().replace(" ", "");
            for (int j = 0; j < C; j++) {
                char ch = line.charAt(j);
                if (ch == 'S') {
                    start = new Node(i, j, 0);
                }
                map[i][j] = ch;
            }
        }
        water.put(0, map);

        bfs();

        if(min == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(min);
        }

    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (map[node.x][node.y] == 'D') {
                min = node.count;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                calWater(node.count + 1);
                if (x >= 0 && x < R && y >= 0 && y < C && visited[x][y] == 0 && (water.get(node.count+1)[x][y] == '.' || water.get(node.count+1)[x][y] == 'D')) {
                    visited[x][y] = 1;
                    queue.add(new Node(x, y, node.count + 1));
                }
            }
        }
    }

    private static void calWater(int count) {
        if (water.containsKey(count)) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        int[][] tmp = water.get(count - 1);
        int[][] create = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (tmp[i][j] == '*') {
                    queue.add(new Node(i, j, count - 1));
                }
                create[i][j] = tmp[i][j];
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                if (x >= 0 && x < R && y >= 0 && y < C && tmp[x][y] == '.') {
                    create[x][y] = '*';
                }
            }
        }
        water.put(count, create);
    }
}