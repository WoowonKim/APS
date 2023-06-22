import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int N;
    static char[][] map;
    static int[] ans;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N][2];
        ans = new int[2];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j][k]) {
                        ans[k]++;
                        bfs(i, j, map[i][j], k);
                    }
                    if (map[i][j] == 'G') map[i][j] = 'R';
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    static void bfs(int r, int c, char t, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (visited[curr[0]][curr[1]][k]) continue;
            visited[curr[0]][curr[1]][k] = true;
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if (isInMap(nr, nc) && map[nr][nc] == t) queue.add(new int[]{nr, nc});
            }
        }
    }

    static boolean isInMap(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}
