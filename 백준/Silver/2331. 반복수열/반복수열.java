import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int A = 0, P = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;

        int findKey = 0;
        while(!map.containsKey(findKey)) {
            findKey = solution(A, P);
            map.put(A, count);
            A = findKey;
            count ++;
        }
        System.out.println(map.get(findKey) - 1);

    }

    public static int solution(int A, int P) {
        int result = 0;
        while(A / 10 != 0) {
            result += (int) Math.pow((A % 10), P);
            A = A / 10;
        }
        result += (int) Math.pow((A % 10), P);

        return result;
    }
}