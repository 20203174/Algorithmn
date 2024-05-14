import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static StringBuilder T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = new StringBuilder(br.readLine());
        int n = T.length();

        for(int i = n-1; i > S.length() - 1; i--) {
            if(T.charAt(i) == 'A') {
                T.deleteCharAt(i);
            } else {
                T.deleteCharAt(i);
                T.reverse();
            }
        }

        if(T.toString().equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}