import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int total = 0, N = 0;
        int[] array;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i = 1; i <= total; i++) {
            N = Integer.parseInt(br.readLine());
            array = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                array[j+1] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(array, N));
        }
    }

    public static int solution(int[] array, int N) {
        int cycle = 0;
        boolean[] visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            if(!visited[i] && i != array[i]) {
                visited[i] = true;
                int j = array[i];
                while(i != array[j]) {
                    visited[j] = true;
                    j = array[j];
                }
                visited[j] = true;
                cycle++;
            } else if(!visited[i] && i == array[i]) {
                visited[i] = true;
                cycle++;
            }
        }
        return cycle;
    }
}