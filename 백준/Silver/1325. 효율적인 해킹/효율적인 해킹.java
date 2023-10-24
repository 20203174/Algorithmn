import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<List<Integer>> graph = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph.get(m).add(n);
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i < N+1; i++) {
            boolean[] visited = new boolean[N+1];
            int distance = 0;
            queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            while(!queue.isEmpty()) {
                distance++;
                int queuePoll = queue.poll();
                for(int a : graph.get(queuePoll)) {
                    if(!visited[a]) {
                        queue.add(a);
                        visited[a] = true;
                    }
                }
            }

            map.put(i, distance);
        }
        int max = 0;
        for(int a : map.values()) {
            if(max <= a) {
                max = a;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < map.size()+1; i++) {
            if(max == map.get(i)) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }
}