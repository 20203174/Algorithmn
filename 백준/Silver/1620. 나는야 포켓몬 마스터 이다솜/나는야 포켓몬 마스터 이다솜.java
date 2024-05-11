import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] dict = new String[N+1];
        Map<String, Integer> map  = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            dict[i] = br.readLine();
            map.put(dict[i], i);
        }

        for(int i = 0; i < M; i++) {
            String word = br.readLine();
            try {
                int number = Integer.parseInt(word);
                System.out.println(dict[number]);
            } catch (NumberFormatException e) {
                System.out.println(map.get(word));
            }
        }
    }
}