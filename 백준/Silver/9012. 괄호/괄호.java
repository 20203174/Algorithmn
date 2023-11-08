import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];

        for(int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        for(String a : strings) {
            printResult(a);
        }

    }

    public static void printResult(String string) {
        char[] arr =string.toCharArray();
        Stack stack = new Stack();
        for(char a : arr) {
            if(a == '(') {
                stack.push(a);
            } else {
                if(stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
