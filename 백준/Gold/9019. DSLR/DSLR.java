import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] visited;

    static class Node {
        int n;
        int d1;
        int d2;
        int d3;
        int d4;
        StringBuilder command;

        Node(int d1, int d2, int d3, int d4, StringBuilder command) {
            this.n = ((d1 * 10 + d2) * 10 + d3) * 10 + d4;
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
            this.d4 = d4;
            this.command = command;
        }

        Node(int n, StringBuilder command) {
            this.n = n;
            this.d1 = n / 1000;
            this.d2 = (n % 1000) / 100;
            this.d3 = (n % 100) / 10;
            this.d4 = n % 10;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            visited = new int[10000];
            bfs(A, B);
        }

    }

    private static void bfs(int A, int B) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(A, new StringBuilder("")));
        visited[A] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.n == B) {
                System.out.println(cur.command);
                break;
            }

            Node tmp = D(cur);
            if(visited[tmp.n] == 0) {
                visited[tmp.n] = 1;
                queue.add(tmp);
            }

            tmp = S(cur);
            if(visited[tmp.n] == 0) {
                visited[tmp.n] = 1;
                queue.add(tmp);
            }

            tmp = L(cur);
            if(visited[tmp.n] == 0) {
                visited[tmp.n] = 1;
                queue.add(tmp);
            }
            tmp = R(cur);
            if(visited[tmp.n] == 0) {
                visited[tmp.n] = 1;
                queue.add(tmp);
            }
        }
    }

    private static Node D(Node cur) {
        int n = cur.n * 2 > 9999 ? (cur.n * 2) % 10000 : cur.n * 2;
        return new Node(n, new StringBuilder(cur.command).append("D"));
    }

    private static Node S(Node cur) {
        int n = cur.n == 0 ? 9999 : cur.n - 1;
        return new Node(n, new StringBuilder(cur.command).append("S"));
    }

    private static Node L(Node cur) {
        return new Node(cur.d2, cur.d3, cur.d4, cur.d1, new StringBuilder(cur.command).append("L"));
    }

    private static Node R(Node cur) {
        return new Node(cur.d4, cur.d1, cur.d2, cur.d3, new StringBuilder(cur.command).append("R"));
    }
}