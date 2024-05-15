import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i =1; i <= N; i++) {
            int count = 0;
            T = Integer.parseInt(br.readLine());
            count += T;
            for(int j = 1; j <= T; j++) {
                count += (int)(Math.sqrt(Math.pow(T, 2) - Math.pow(j, 2)));
            }
            System.out.println("#"+ i + " " + (count * 4 + 1));
        }
    }
}