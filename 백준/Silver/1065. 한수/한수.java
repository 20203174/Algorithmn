import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();

        if (N.length() == 1) {
            System.out.println(N);
        } else if (N.length() == 4) {
            System.out.println(144);
        }else if (N.length() == 2) {
            System.out.println(N);
        } else if (N.length() == 3) {
            int first = N.charAt(0) - '0';
            int second = N.charAt(1) - '0';
            int third = N.charAt(2) - '0';

            count += 99;

            solution(first, second, third);

            if(second > first || (second == first && third >= first)) {
                count -= first;
            } else {
                count -= first - 1;
            }

            System.out.println(count);
        }

    }

    private static void solution(int first, int second, int third) {

        for(int i = 1; i <= first; i++) {
            for(int j = 0; j <= 4; j++) {
                if((i+j+j) <= 9 && (i * 100) + ((i + j) * 10) + (i + j + j) <= Integer.parseInt(N)) {
                    count++;
                }
                if((i-j-j)>=0 && i * 100 + (i - j) * 10 + (i - j - j) <= Integer.parseInt(N)) {
                    count++;
                }
            }
        }
    }
}