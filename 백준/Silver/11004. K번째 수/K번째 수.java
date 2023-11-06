import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] list = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        list = Arrays.stream(list).sorted().toArray();
        System.out.println(list[K-1]);

    }
}