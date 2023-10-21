import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bridge = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] left = new int[N + 1];
        int[] right = new int[N + 1];

        for (int i = 0; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                if (i == j) {
                    bridge[i][j] = 1;
                }
                if (i == 1) {
                    bridge[i][j] = j;
                }
                bridge[0][j] = 1;
            }
        }
        for (int i = 1; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                if (i == j || i == 1 || j == 1) {
                    continue;
                }
                if (i > j) {
                    continue;
                }
                int tmpi = i;
                int tmpj = j;
                while (tmpj >= tmpi) {
                    bridge[i][j] += bridge[tmpi - 1][tmpj - 1];
                    tmpj--;
                }
            }
        }


        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            left[i] = Integer.parseInt(st.nextToken());
            right[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(bridge[left[i]][right[i]]).append('\n');
        }
        System.out.println(sb);
    }
}
