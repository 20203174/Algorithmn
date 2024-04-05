import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static boolean visitDFS[][]; 
	
	static int graph[][];
	
	static Queue<Integer> q = new LinkedList<>();
	
	static int V;// 정점 개수
	static Scanner sc =new Scanner(System.in); 
    static int sum = 0;
	
	public static void main(String[] args) {
        List<Integer> countList = new ArrayList();
		
		V = Integer.parseInt(sc.nextLine()); 
		
		visitDFS = new boolean[V][V];
		
		graph = new int[V][V]; //인접행렬 생성
		
		for(int i=0; i<V; i++) {
            String line = sc.nextLine();
			for(int j = 0; j < V; j++) {
                graph[i][j] = line.charAt(j) - 48;
            }
		}

        int count = 0;
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(graph[i][j] == 1 && !visitDFS[i][j]) {
                    count++;
                    dfs(i, j);
                    countList.add(sum);
                    sum = 0;
                }
            }
        }

    
        countList.sort((o1, o2) -> o1.compareTo(o2));

        System.out.println(count);
        for(int i = 0; i < count; i++) {
            System.out.println(countList.get(i));
        }
		sc.close();
		
	}
	
	public static void dfs(int i, int j)
	{	
		visitDFS[i][j] = true;
        sum++;

        if((i-1 >= 0) && graph[i-1][j] == 1 && !visitDFS[i-1][j]) {
            dfs(i-1, j);
        }
		if((j-1 >= 0) && graph[i][j-1] == 1 && !visitDFS[i][j-1]) {
            dfs(i, j-1);
        }
        if((i+1 < V) && graph[i+1][j] == 1 && !visitDFS[i+1][j]) {
            dfs(i+1, j);
        }
        if((j+1 < V) && graph[i][j+1] == 1 && !visitDFS[i][j+1]) {
            dfs(i, j+1);
        }
	} 
}