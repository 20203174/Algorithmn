import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) {
                break;
            }
            int[] arr = new int[N];
            boolean[] visited = new boolean[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            combination(arr, visited, 0, 6);
            System.out.println();
        }
    }

    public static void combination(int[] arr, boolean[] visited, int n, int r) {
        if(r==0) {
            print(arr, visited);
            return;
        } else {
            for(int i = n; i < arr.length; i++) {
                visited[i] = true;
                combination(arr, visited, i+1, r-1);
                visited[i] = false;
            }
        }
    }

    public static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true) {
                System.out.printf(arr[i] + " ");
            }
        }
        System.out.println();
    }


}