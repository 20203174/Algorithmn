import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answers = new int[N];
        int[] memo = new int[11];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        memo[4] = 7;
        memo[5] = 13;
        memo[6] = 24;
        for(int i = 7; i < 11; i++) {
            solution(memo, i);
        }

        for(int i = 0; i < N; i++) {
            answers[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < N; i++) {
            System.out.println(memo[answers[i]]);
        }

    }

    private static void solution(int[] memo, int n) {

        int result = 0;
        if(n < 7) {
            return;
        }
        for(int i = 1; i <= 3; i++) {
            result += memo[n-i];
        }
        memo[n] = result;
    }

}