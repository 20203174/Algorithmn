package org.example._1001;

public class 콜라문제 {
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

    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20));
        System.out.println(solution(3, 1, 20));

    }
}
