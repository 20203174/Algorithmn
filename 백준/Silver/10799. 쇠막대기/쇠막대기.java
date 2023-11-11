
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < string.length(); i++ ) {
            char tmp = string.charAt(i);
            if(tmp == ')'&&!stack.isEmpty()) {
                if(string.charAt(i-1) == '(') {
                    //레이저임
                    //하나 빼주고 카운트
                    stack.pop();
                    count += stack.size();
                } else {
                    //하나만 빼고 하나 카운트
                    stack.pop();
                    count += 1;
                }
            } else {
                stack.push('(');
            }
        }

        System.out.println(count);
    }
}
