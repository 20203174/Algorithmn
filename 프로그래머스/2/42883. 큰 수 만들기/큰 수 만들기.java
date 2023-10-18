import java.util.Stack;

class Solution {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] arr = number.toCharArray();

        int removeNum = 0;
        int i = 0;
        while(i < arr.length) {
            if(stack.isEmpty()) {
                stack.add(arr[i]);
                i++;
            }
            if(stack.peek()-'0' < arr[i]-'0') {
                stack.pop();
                removeNum++;
            } else {
                stack.add(arr[i]);
                i++;
            }
            if(removeNum == k) {
                while(i < arr.length) {
                    stack.add(arr[i]);
                    i++;
                }
                break;
            }
        }
        if(removeNum != k) {
            while(removeNum < k) {
                stack.pop();
                removeNum++;
            }
        }
        while(!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }


        return answer.toString();
    }
}