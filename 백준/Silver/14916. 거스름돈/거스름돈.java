import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int m, r;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();

        if(m == 1 || m == 3) {
            System.out.println(-1);
            return;
        }
        if((m % 5) % 2 == 0) {
            r = m/5 + (m%5/2);
        } else {
            r = m/5 - 1 + ((m%5 + 5)/2);
        }

        System.out.println(r);
    }
}