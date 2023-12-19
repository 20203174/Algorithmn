import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] timeList = new int[N];
        int[] moneyList = new int[N];
        int[] dp = new int[N+1];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timeList[i] = Integer.parseInt(st.nextToken());
            moneyList[i] = Integer.parseInt(st.nextToken());
        }
        int i = 0;
        for(i = 0; i < N; i++) {
            if(i+timeList[i] <= N) {
                dp[i + timeList[i]] = Math.max(dp[i + timeList[i]], dp[i] + moneyList[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);


    }
}
