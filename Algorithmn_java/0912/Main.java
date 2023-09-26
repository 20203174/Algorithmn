package Algorithmn_java.0912;
public class Main {

    private static final int[] TEST_CASES = {
            10,
            20,
            30,
            40
    };

    private static final int[] TEST_CASES_RESULT = {
            20
    };

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES, TEST_CASES_RESULT[i]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / 1 * 100));
    }

    private static double correct = 0;

    private static boolean test(int[] input, int result) {
        if (solution(input) == (result)) {
            correct++;
            return true;
        }

        return false;
    }

    // public static void main(String[] args) {
    // int[] values = {10, 20, 30, 40};
    // System.out.println(solution(values));
    // }

    public static int solution(int[] input) {
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length - 1; j++) {
                if (max < euclid(input[i], input[j])) {
                    max = euclid(input[i], input[j]);
                }
            }
        }
        return max;
    }

    public static int euclid(int big, int small) {
        int res = small;
        while (big != 0) {
            if (big < res) {
                res = big;
                big = res;
            }
            big -= res;
        }
        return res;
    }
}