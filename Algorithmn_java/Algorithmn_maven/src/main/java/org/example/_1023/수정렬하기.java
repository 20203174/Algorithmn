package org.example._1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        for(int i = 0; i < N; i++) {
            list[i] = (Integer.parseInt(br.readLine()));
        }

        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();

        for(int a : list) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}
