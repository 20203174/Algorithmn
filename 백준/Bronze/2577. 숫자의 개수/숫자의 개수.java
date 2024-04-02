
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int A, B, C;
        String R;
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);

        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();

        R = String.valueOf(A * B * C);

        for(int i = 0; i < R.length(); i++) {
            array[R.charAt(i) - 48] += 1;
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }
}
