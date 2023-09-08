import java.util.Arrays;

public class Main {

    private static final int[] TEST_CASES = {
            4,
            5,
            10
    };

    private static final int[][][] TEST_CASES_RESULT = {
            {
                    {1, 2, 3, 4},
                    {12, 13, 14, 5},
                    {11, 16, 15, 6},
                    {10, 9, 8, 7}
            },
            {
                    {1, 2, 3, 4, 5},
                    {16, 17, 18, 19, 6},
                    {15, 24, 25, 20, 7},
                    {14, 23, 22, 21, 8},
                    {13, 12, 11, 10, 9}
            },
            {
                    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                    {36, 37, 38, 39, 40, 41, 42, 43, 44, 11},
                    {35, 64, 65, 66, 67, 68, 69, 70, 45, 12},
                    {34, 63, 84, 85, 86, 87, 88, 71, 46, 13},
                    {33, 62, 83, 96, 97, 98, 89, 72, 47, 14},
                    {32, 61, 82, 95, 100, 99, 90, 73, 48, 15},
                    {31, 60, 81, 94, 93, 92, 91, 74, 49, 16},
                    {30, 59, 80, 79, 78, 77, 76, 75, 50, 17},
                    {29, 58, 57, 56, 55, 54, 53, 52, 51, 18},
                    {28, 27, 26, 25, 24, 23, 22, 21, 20, 19}
            }
    };


    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASES_RESULT[i]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }

    private static double correct = 0;

    private static boolean test(int input, int[][] result) {
        if (Arrays.deepEquals(solution(input), result)) {
            correct++;
            return true;
        }

        return false;
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];

        // int i = 0;
        // int j = 0;
        // int value = 1;
        // int tmp = n;


        // for(j = 0; j < tmp; j++){
        //     answer[i][j] = value;
        //     value++;
        // }
        // tmp--;
        // System.out.println("실행됨");
        // for(i =0; i<n;i++) {
        //     for(j=0;j<n;j++) {
        //         System.out.print(answer[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // j--;

        // while(tmp >1){
        //     System.out.println("tmp: "+tmp);
        //     for(i = 1; i < tmp; i++) {
        //         answer[i][j] = value;
        //         value++;
        //     }
        //     i--;
        // }
        //     for(j = tmp-1; j >= 0; j--) {
        //         answer[i][j] = value;
        //         value++;
        //     }j++;
        //     tmp--;
        //    
        // }
        //     if(tmp == 1)break;

        //     for(i = tmp-1; i >= 0; i--) {
        //         System.out.println(i + " " + tmp);
        //         answer[i][j] = value;
        //         value++;
        //     }
        //     i++;
        //     System.out.println("실행됨");
        //     for(i =0; i<n;i++) {
        //     for(j=0;j<n;j++) {
        //         System.out.print(answer[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        //     for(j = 0; j < tmp; j++) {
        //         answer[i][j] = value;
        //         value++;
        //     }
        //     j--;
        //     System.out.println("실행됨");
        //     for(i =0; i<n;i++) {
        //     for(j=0;j<n;j++) {
        //         System.out.print(answer[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // }
        // for(i =0; i<n;i++) {
        //     for(j=0;j<n;j++) {
        //         System.out.print(answer[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // return answer;



        int number = 1;
        int x = 0;
        int y = -1;
        int direction = 1;

        while(n > 0) {
            for(int i =0; i< n; i++) {
                y += direction;
                answer[x][y] = number++;
            }
            n--;

            for(int i = 0; i < n; i++) {
                x += direction;
                answer[x][y] = number++;
            }
            direction *= -1;
        }

        return answer;
    }
}