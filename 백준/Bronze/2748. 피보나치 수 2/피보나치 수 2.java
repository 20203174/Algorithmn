import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        N = Integer.parseInt(br.readLine());
        long[] memo = new long[N+2];
        memo[0] = 0;
        memo[1] = 1;
        if(N >= 2) {
            for(int i = 2; i <= N; i++) {
                memo[i] = memo[i-1] + memo[i-2];
            }
        }
        System.out.println(memo[N]);

    }
}