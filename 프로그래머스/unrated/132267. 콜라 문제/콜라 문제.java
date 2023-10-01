class Solution {
    public static int solution(int a, int b, int n) {
        int answer = recursion(a, b, n, 0);
        return answer;
    }

    public static int recursion(int a, int b, int n, int count) {
        if (n <= a) {
            count += (n / a) * b;
            return count;
        }
        return recursion(a, b, (n / a) * b + (n % a), count + (n / a) * b);
    }
}