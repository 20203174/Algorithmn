import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[N + 3];
        memo[0] = 0;
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;
        if (N > 3) {
            for (int i = 4; i <= N; i++) {
                solution(memo, i);
            }
        }
        System.out.println(memo[N]);

    }

    private static void solution(int[] memo, int n) {
        int min = 1000000;
        if (n % 3 == 0) {
            int tmp = n / 3;
            if(memo[tmp] < min) {
                min = memo[tmp];
            }
        }
        if (n % 2 == 0) {
            int tmp = n / 2;
            if(memo[tmp] < min) {
                min = memo[tmp];
            }
        }
        int tmp = n - 1;
        if(memo[tmp] < min) {
            min = memo[tmp];
        }
        memo[n] = min + 1;
    }
}