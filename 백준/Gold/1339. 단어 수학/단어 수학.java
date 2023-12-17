import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Character, Double> elementSum = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();
            int count = tmp.length()-1;
            int index = 0;
            while(count > -1) {
                if(!elementSum.containsKey(tmp.charAt(index))) {
                    elementSum.put(tmp.charAt(index), 0.0);
                }
                elementSum.put(tmp.charAt(index), elementSum.get(tmp.charAt(index)) + Math.pow(10, count));
                count--;
                index++;
            }
        }
        int sum = 0;
        int multiplyValue = 9;
        List<Double> list = elementSum.values().stream().sorted().collect(Collectors.toList());
        for(int i = elementSum.size()-1; i >= 0; i--) {
            double value = list.get(i);
            if(value != 0.0) {
                sum += list.get(i)*multiplyValue;
                multiplyValue--;
            }

        }
        System.out.println(sum);
    }
}
