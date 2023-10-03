package org.example._0930;

import java.util.Arrays;

public class 서울에서_김서방_찾기 {
    public String solution(String[] seoul) {
        String answer = "";
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = String.valueOf(i);
            }
        }

        return answer;
    }
    public static int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while(left <= right) {
            mid = (left + right) / 2;
            if(arr[mid] < n) left = mid + 1;
            else if(arr[mid] > n) right = mid - 1;
            else return mid;
        }
        return -1;
    }
}
