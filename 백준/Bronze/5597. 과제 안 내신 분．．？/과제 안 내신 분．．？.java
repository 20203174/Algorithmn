import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[28];
        for(int i = 0; i < 28; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int label = 1;
        for(int i = 0; i < 28; i++) {
            if(label != list[i]) {
                System.out.println(label);
                i--;
            }
            label++;
        }
        if(label == 30) {
            System.out.println(label);
        }

    }

}