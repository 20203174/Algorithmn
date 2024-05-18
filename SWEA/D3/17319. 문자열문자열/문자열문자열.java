import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public static void main( String[] args ) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            int length = Integer.parseInt(br.readLine());
            String line = br.readLine();
            if(!check(length, line)) {
                System.out.println("#" + i + " No");
            } else {
                System.out.println("#" + i + " Yes");
            }
        }
        
    }

    private static boolean check(int length, String line) {
        if(length % 2 != 0) {
            return false;
        }
        String first = line.substring(0, length/2);
        String second = line.substring(length/2);
        return first.equals(second);
    }
}
