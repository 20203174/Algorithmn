package org.example._1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visitedDfs;
    private static boolean[] visitedBfs;
    private static Queue<Integer> queue = new LinkedList<>();
    private static int N;
    private static int M;
    private static int start;
    private static List<Integer>[] realGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visitedDfs = new boolean[N];
        visitedBfs = new boolean[N];

        realGraph = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            realGraph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            realGraph[a-1].add(b);
            realGraph[b-1].add(a);
        }
        for(List<Integer> list : realGraph) {
            list.sort(Integer::compareTo);
        }
        dfs(start);
        System.out.println();
        bfs(start);

    }

    public static void dfs(int index) {
        if(visitedDfs[index-1]) {
            return;
        }
        visitedDfs[index-1] = true;
        System.out.printf("%d ", index);
        for(int i = 0; i < realGraph[index-1].size(); i++) {
            if(!visitedDfs[realGraph[index-1].get(i)-1]) {
                dfs(realGraph[index-1].get(i));
            }
        }
    }

    public static void bfs(int index) {
        visitedBfs[index-1] = true;
        queue.add(index);
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            System.out.printf("%d ", tmp);
            for(int i = 0; i < realGraph[tmp-1].size(); i++) {
                if(!visitedBfs[realGraph[tmp-1].get(i)-1]) {
                    queue.add(realGraph[tmp-1].get(i));
                    visitedBfs[realGraph[tmp-1].get(i)-1] = true;
                }
            }
        }

    }
}
