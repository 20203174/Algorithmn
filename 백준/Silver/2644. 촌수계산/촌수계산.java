import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int start;
    static int end;
    static int[] visited;
    static Map<Integer, Set<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        visited = new int[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            putMap(key, value);
            putMap(value, key);

        }
        bfs(start);

        if(visited[end] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(visited[end] - 1);
        }

    }
    private static void putMap(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            Set<Integer> list = new HashSet<>();
            list.add(value);
            map.put(key, list);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] += 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == end) {
                break;
            }
            if(map.containsKey(cur)) {
                Set<Integer> list = map.get(cur);
                for(Integer i : list) {
                    if(visited[i] == 0) {
                        queue.add(i);
                        visited[i] += 1 + visited[cur];
                    }
                }
            }
        }
    }
}