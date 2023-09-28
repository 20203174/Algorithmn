import java.util.*;

public class Solution {
    public static int[] solution(int []arr) {
        int i = 0;
        Stack<Integer> stack = new Stack();
        stack.push(arr[i]);
        for(int j = 1; j < arr.length; j++) {
            if(stack.peek() != arr[j]) {
                stack.push(arr[j]);
            }
        }
        int[] answer = new int[stack.size()];
        for(i = answer.length-1; i >= 0; i --) {
            answer[i] = stack.pop();
        }



        return answer;
    }
}