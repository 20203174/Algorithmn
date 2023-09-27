package org.example._0906;

public class Main {

    private static double correctCount = 0;

    private static final String[][] TESTCASES = new String[][] {
            {"123", "123", "246"},
            {"1000", "1", "2"},
            {"456", "789", "1461"},
            {"5", "5", "1"},
            {"11112", "54321", "65433"},
            {"3829", "1300", "4139"}
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2]));

        System.out.println("정답률 = " + (int) (correctCount / TESTCASES.length * 100) + "%");
    }

    private static boolean test(String input, String input2, String answer) {
        int first = Integer.parseInt(input);
        int second = Integer.parseInt(input2);

        boolean res = String.valueOf(solution(first, second)).equals(answer);
        if (res)
            correctCount++;
        return res;
    }

    // solution
    public static int solution(int a, int b) {
        return reverseResursive(reverseResursive(a) + reverseResursive(b));
        // return reverseNoString(reverseNoString(a) + reverseNoString(b));

        // String aStr = String.valueOf(a);
        // String bStr = String.valueOf(b);
        // String tmp = "";

        // char[] aChar = aStr.toCharArray();
        // char[] bChar = bStr.toCharArray();
        // aStr = "";
        // bStr = "";

        // for(int i = aChar.length -1; i >= 0; i--){
        //     aStr += aChar[i];
        // }
        // for(int i =bChar.length-1; i >= 0; i--){
        //     bStr += bChar[i];
        // }
        // System.out.println(bStr);
        // tmp = String.valueOf(Integer.parseInt(aStr) + Integer.parseInt(bStr));
        // char[] tmpChar = tmp.toCharArray();
        // tmp = "";
        // for(int i =tmpChar.length-1; i >= 0; i--){
        //     tmp += tmpChar[i];
        // }

        // return Integer.valueOf(tmp);

    }
    public static int reverse(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = arr.length - 1; i > -1; i--) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public static int reverseNoString(int n) {
        int[] arr = new int[10];
        int i = 0;
        int result = 0; 
        while(n > 0){
            arr[i] = (n % 10);
            n /= 10;
            i++;
        }
        
        int j =0;
        for(j = 0; j< arr.length - 1; j++){
            result += arr[j] * Math.pow(10,i-1);
            i--;
        }
        result += arr[j];
        return result;
    }

    public static int reverseResursive(int n){
        return recursive(0,n);
    }
    public static int recursive(int res, int n){
        if(n == 0){
            return res;
        }
        else{
            res = res * 10 + n % 10;
            return recursive(res, n/10);
        }

        // int tmp = n;
        // int i = 0;
        // while(tmp > 0){
        //     tmp /= 10;
        //     i++;
        // }
        // i = i -1;
        // if(i == -1)return 0;
        // res = (int)((n%10)*Math.pow(10,i));
        // return res + recursive(0, n/10);
    }
}