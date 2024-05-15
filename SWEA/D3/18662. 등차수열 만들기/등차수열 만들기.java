import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        for(int i =1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Integer.parseInt(st.nextToken());
            double y = Integer.parseInt(st.nextToken());
            double z = Integer.parseInt(st.nextToken());
            double min = 1000;

            min = Math.min(Math.abs((x + z)/2.0 - y), Math.abs((y + (y - x)) - z));
            min = Math.min(min, Math.abs((y - (z - y)) - x));

            System.out.println("#" + i + " " + min);

        }
    }
}