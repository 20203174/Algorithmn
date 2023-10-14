package org.example._1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] roomArr = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            roomArr[i][0] = key;
            roomArr[i][1] = value;
        }
        int prev_end_time = 0;
        int count = 0;
        Arrays.sort(roomArr, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        for(int i = 0; i < N; i++) {
            if(roomArr[i][0] >= prev_end_time) {
                prev_end_time = roomArr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
