import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int N, cnt;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    pq.add(cnt);
                }
            }
        }
        System.out.println(pq.size());
        while (!pq.isEmpty()) System.out.println(pq.poll());
    }

    private static void dfs(int r, int c) {
        map[r][c] = 0;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isInMap(nr, nc) && map[nr][nc] == 1) dfs(nr, nc);
        }
    }

    private static boolean isInMap(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
