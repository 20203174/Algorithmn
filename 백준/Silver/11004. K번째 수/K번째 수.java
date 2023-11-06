
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] list = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        pivotSort(list, 0, list.length-1);
        System.out.println(list[K-1]);

    }

    public static void pivotSort(int[] a, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        int pivot = partition(a, lo, hi);
        pivotSort(a, lo, pivot);
        pivotSort(a, pivot + 1, hi);
    }
    public static int partition(int[] a, int left, int right) {
        int lo = left -1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];

        while(true) {
            do {
                lo++;
            } while (a[lo] < pivot);

            do {
                hi--;
            } while (a[hi] > pivot && lo <= hi);

            if(lo >= hi) {
                return hi;
            }

            swap(a, lo, hi);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
