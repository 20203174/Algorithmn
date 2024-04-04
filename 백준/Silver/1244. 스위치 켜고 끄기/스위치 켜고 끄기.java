

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, S, gender, index;
        N = scanner.nextInt();
        int[] array = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            array[i] = scanner.nextInt();
        }
        S = scanner.nextInt();
        for(int i = 0; i < S; i++) {
            gender = scanner.nextInt();
            index = scanner.nextInt();

            if(gender == 1) {
                for(int j = index; j < N+1; j = j + index) {
                    reserve(array, j);
                }
            } else {
                int max = index -1 < N - index ? index - 1 : N - index;
                reserve(array, index);
                for(int j = 1; j <= max; j++) {
                    if(array[index - j] == array[index + j]) {
                        reserve(array, index - j);
                        reserve(array, index + j);
                    } else {
                        break;
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.printf("%d ", array[i]);
            if(i % 20 == 0) {
                System.out.println();
            }
        }
    }
    public static void reserve(int[] array, int index) {
        if(array[index] == 0) {
            array[index] = 1;
        } else {
            array[index] = 0;
        }
    }
}
