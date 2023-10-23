import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] answer = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        for(int i = 0; i<= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }

        int distance = 1;
        queue.add(X);
        visited[X] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int tmpPoll = queue.poll();
                for(int a : graph.get(tmpPoll)) {
                    if(!visited[a]) {
                        answer[a] = distance;
                        visited[a] = true;
                        queue.add(a);
                    }
                }
            }
            distance++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < N+1; i++) {
            if(answer[i] == K) {
                ans.add(i);
            }
        }
        if(ans.size() == 0) {
            System.out.println("-1");
        } else {
            for(int a : ans) {
                System.out.println(a);
            }
        }

    }
}