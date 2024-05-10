import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int x;
        int y;

        public Node(int i, int j) {
            x = i;
            y = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Node> map = new HashMap<>();
        boolean[][] visited = new boolean[6][6];
        int bingoCount = 0;
        StringTokenizer st = null;
        for(int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                map.put(Integer.parseInt(st.nextToken()), new Node(i, j));
            }
        }
        for(int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                Node position = map.get(Integer.parseInt(st.nextToken()));
                visited[position.x][position.y] = true;
                bingoCount += checkBingo(visited, position);
                if(bingoCount >= 3) {
                    System.out.println((i-1) * 5 + j);
                    return;
                }
            };
        }
    }
    private static int checkBingo(boolean[][] visited, Node position) {
        int bingo = 0;
        if(position.x == position.y) {
            //대각선도 검사
            for(int i = 1; i <= 5; i++) {
                if(!visited[i][i]) {
                    break;
                }
                if(i == 5) {
                    bingo++;
                }
            }
        }
        if((position.x ==5 && position.y == 1) || (position.x == 4 && position.y == 2) ||
                (position.x == 3 && position.y == 3) || (position.x == 2 && position.y == 4) || (position.x == 1 && position.y == 5)) {
            for(int i = 1; i <= 5; i++) {
                if(!visited[i][6 - i]) {
                    break;
                }
                if(i == 5) {
                    bingo++;
                }
            }
        }
        for(int i = 1; i <= 5; i++) {
            if(!visited[i][position.y]) {
                break;
            }
            if(i == 5) {
                bingo++;
            }
        }
        for(int i = 1; i <= 5; i++) {
            if(!visited[position.x][i]) {
                break;
            }
            if(i == 5) {
                bingo++;
            }
        }

        return bingo;
    }

}