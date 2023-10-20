
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 0;
            }
        }
        dp[0][0] = 1;
        for(int i = 0; i < N; i++ ) {
            for(int j = 0; j < N; j++) {
                int tmp = arr[i][j];
                if(tmp == 0) break;
                if(i+tmp <N) {
                    dp[i+tmp][j] += dp[i][j];
                }
                if(j+tmp < N) {
                    dp[i][j+tmp] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);

    }

}