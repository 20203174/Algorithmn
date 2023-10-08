package org.example._1008;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cardMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            cardMap.put(card, cardMap.getOrDefault(card, 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(cardMap.getOrDefault(key, 0));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//import org.example._0926.TreeNode;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] list = new int[N];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            list[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(list);
//
//        int M = Integer.parseInt(br.readLine());
//        int[] keyValues = new int[M];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < M; i++) {
//            keyValues[i] = (Integer.parseInt(st.nextToken()));
//        }
//        int count = 0;
//
//        for (int key : keyValues) {
//            int first = binaryFirst(list, key, 0, N - 1);
//            int last = 0;
//            if(first == -1) {
//                count = 0;
//                System.out.printf("%d ",count);
//            } else {
//                last = binaryLast(list, key, first, N - 1);
//                count = last - first + 1;
//                System.out.printf("%d ",count);
//            }
//        }
//
//    }
//
//    public static int binaryFirst(int[] list, int key, int low, int high) {
//        int mid;
//
//        while(low <= high) {
//            mid = (low + high) / 2;
//            if(list[mid] == key) {
//                if(mid != 0 && list[mid-1] ==key) {
//                    high = mid -1;
//                } else {
//                    return mid;
//                }
//            } else if(list[mid] < key) {
//                low = mid + 1;
//            } else if(list[mid] > key) {
//                high = mid - 1;
//            }
//        }
//        return -1;
//    }
//    public static int binaryLast(int[] list, int key, int low, int high) {
//        int mid;
//
//        while(low <= high) {
//            mid = (low + high) / 2;
//            if(list[mid] == key) {
//                if(mid != list.length-1 && list[mid+1] ==key) {
//                    low = mid +1;
//                } else {
//                    return mid;
//                }
//            } else if(list[mid] < key) {
//                low = mid + 1;
//            } else if(list[mid] > key) {
//                high = mid - 1;
//            }
//        }
//        return -1;
//    }
//}
