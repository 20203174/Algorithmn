
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static int nV;
    private static int nE;
    private static ArrayList<Integer>[] realGraph;
    private static boolean[] visitArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());
        visitArr = new boolean[nV + 1];

        realGraph = new ArrayList[nV + 1];
        for(int i = 1; i < nV + 1; i++) {
            realGraph[i] = new ArrayList<Integer>();
        }


        for(int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            realGraph[tmp1].add(tmp2);
            realGraph[tmp2].add(tmp1);
        }

        System.out.println(countDfs(1));
    }
    public static void dfs(int vIdx) {
        visitArr[vIdx] = true;
        for(int i : realGraph[vIdx]) {
            if(visitArr[i] == false) {
                dfs(i);
            }
        }
    }

    public static int countDfs(int vIdx) {
        int count = 0;
        for(int i = 1; i < visitArr.length; i++) {
            if(!visitArr[i]) {
                count++;
                dfs(i);
            }
        }
        return count;
    }
}