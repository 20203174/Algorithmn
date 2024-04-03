import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int N, M;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        int[] array = new int[N];

        for(int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        
        Arrays.sort(array);

        int front = 0, end = 0;
        front += array[0] < 0 ? -array[0] : 0;
        end += array[N-1] > 0 ? array[N-1] : 0;
        for(int i = 0; i < N; i += M) {
            sum += (array[i] < 0) ? -(array[i]*2) : 0;
            sum += array[N-i-1] > 0 ? array[N-i-1] * 2 : 0;
         }
        if(front > end) {
            sum -= (-array[0]);
        } else {
            sum -= array[N-1];
        }
        System.out.println(sum);
    }
}
