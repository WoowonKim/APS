import java.util.*;

public class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static int N, M, K;
    static boolean[][] visited;
    static int[][] map;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        solve(0, 0);
        System.out.println(ans);
    }

    static public void solve(int cnt, int sum) {
        if (cnt == K) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if(isValid(i, j)) {
                        visited[i][j] = true;
                        solve(cnt + 1, sum + map[i][j]);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    static public boolean isValid(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                if(visited[nr][nc]) return false;
            }
        }
        return true;
    }
}


