import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static int res = 0;
    static Map<Integer, Set<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            putMap(a, b);
            putMap(b, a);
        }

        for(int i = 1; i <= N; i++) {
            int bacon = 0;
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    continue;
                }
                bacon += bfs(i, j);
            }
            if(bacon < min) {
                min = bacon;
                res = i;
            }
        }
        System.out.println(res);

    }
    private static int bfs(int start, int end) {
        int[] visited = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == end) {
                return visited[cur] - 1;
            }
            for(int i : map.get(cur)) {
                if(visited[i] == 0) {
                    queue.add(i);
                    visited[i] = visited[cur] + 1;
                }
            }
        }
        return -1;
    }
    private static void putMap(int a, int b) {
        if(!map.containsKey(a)) {
            Set<Integer> set = new HashSet<>();
            set.add(b);
            map.put(a, set);
        } else {
            Set<Integer> set = map.get(a);
            set.add(b);
            map.put(a, set);
        }
    }

}