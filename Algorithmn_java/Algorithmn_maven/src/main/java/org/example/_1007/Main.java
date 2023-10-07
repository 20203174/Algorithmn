package org.example._1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Integer::compare);

        int M = Integer.parseInt(br.readLine());
        List<Integer> keyValues = new ArrayList<>(M);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            keyValues.add(Integer.parseInt(st.nextToken()));
        }

        for(int key : keyValues) {
            if(binarySearch(list, key, 0, list.size()-1)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    public static boolean binarySearch(List<Integer> list, int key, int low, int high) {
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if(key == list.get(mid)) {
                return true;
            } else if(key < list.get(mid)) {
                high = mid - 1;
            } else if(key > list.get(mid)) {
                low = mid + 1;
            }
        }
        return false;
    }

}
