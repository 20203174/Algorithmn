package org.example._1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int sum = 0;

        for(int i = 0; i < N; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        while(priorityQueue.size() > 1) {
            int tmpSum = priorityQueue.poll() + priorityQueue.poll();
            priorityQueue.add(tmpSum);
            sum += tmpSum;
        }
        System.out.println(sum);

    }
}
