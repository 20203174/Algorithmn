import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int[] TEST_CASES = {
            1,
            60,
            256,
            325,
            20_160,
            3_456_789
            // 10_000_001,
            // 1_234_567_890
    };

    private static final String[] TEST_CASES_RESULT = {
            "1 = 1",
            "2 * 2 * 3 * 5 = 60",
            "2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 = 256",
            "5 * 5 * 13 = 325",
            "2 * 2 * 2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 = 20160",
            "3 * 7 * 97 * 1697 = 3456789"
            // "11 * 909091 = 10000001",
            // "2 * 3 * 3 * 5 * 3607 * 3803 = 1234567890"
    };

    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASES_RESULT[i]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
    }

    private static double correct = 0;

    private static boolean test(int input, String result) {
        if (solution2(input).equals(result)) {
            correct++;
            return true;
        }

        return false;
    }

    public static String solution(int num) {
        int origin = num;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        

        for(int i = 1; i < num; i++ ) {
            if(isPrime(i) == 1){
                if(num % i == 0) {
                list.add(i);
            }
            }
        }
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size()-1){
                sb.append(" * ");
            }
        }
        sb.append(" = ");
        sb.append(num);
        System.out.println(sb);
        

        return sb.toString();
    }
    public static int isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return 0;
          }
        }
        return 1;
    }

    public static String solution2(int num) {
        int origin = num;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        if(num ==1 ){
            list.add(1);
        }

        // for(int i =2; i<=num; i++){
        //     while(num % i == 0) {
        //         list.add(i);

        //          num /= i;
        //     }
        // }
        recursion(list, num, 2);
        for(int i = 0; i < list.size(); i++) {
            sb.append((list.get(i)));
            if(i < list.size()-1) {
                sb.append(" * ");
            }
        }
        sb.append(" = ").append(origin);
        return sb.toString();

    }
    public static int recursion(List<Integer> list, int num, int i) {
        if(i > num) return 1;
        if(num %  i == 0){
            list.add(i);
            num = num/i;
        }
        else {
            i++;
            // while(isPrime(i) == 0){ //소수가 아니면
            //     i++;
            //     if(i > num) return 1;
            // }
        }
        return recursion(list, num, i);
    }
    public static StringBuilder factorize(int n, int i, StringBuilder builder) {
        if(n == 1) {
            return builder;
        }
        if(n%i == 0) {
            builder.append(i);
            n/=1;
        }
        else{
            i++;
        }
        return factorize(n, i, builder);

    }
    public static StringBuilder whileVersion(int n, StringBuilder builder) {
        int i = 2; 
        while(n != 1) {
            if(n % i == 0) {
                builder.append(i);
                n/=i;
            }
        }
        return builder;
    }
}