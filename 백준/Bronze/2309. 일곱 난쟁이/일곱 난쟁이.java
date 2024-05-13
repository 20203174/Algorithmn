import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int N = 9;
    static int[] input = new int[N];
    static int R = 7;
    static int[] password = new int[R];
    static int count = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        comb(0, 0);
    }

    private static void comb(int cnt, int start){
        if(cnt == R) {
            if(100 == Arrays.stream(password).sum() && !flag) {
                Arrays.sort(password);
                flag = true;
                Arrays.stream(password).forEach(n -> System.out.println(n));
                return;
            }
            count++;
            return;
        }
        for(int i = start; i < N; i++) {
            password[cnt] = input[i];
            comb(cnt + 1, i+1);
        }
    }
}