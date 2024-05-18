import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution 
{
    static class Spot {
        int x, y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    public static void main( String[] args ) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[100];
            for(int j = 0; j < 100; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int big = 99;
            int small = 0;
            for(int j = 0; j < N; j++) {
                arr[big] -= 1;
                arr[small] += 1;
                if(arr[big]<arr[big-1]) {
                    big -= 1;
                } else {
                    big = 99;
                }
                if(arr[small]>arr[small+1]) {
                    small += 1;
                } else {
                    small = 0;
                }
            }
            System.out.println("#" + i + " " + (arr[big] - arr[small]));

        }
        
    }

}
