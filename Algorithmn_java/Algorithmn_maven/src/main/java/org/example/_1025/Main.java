package org.example._1025;

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
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < 3+1; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(3).add(2);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] values = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 3; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();


    }
}
