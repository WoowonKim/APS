import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static final int[] dr = {1, -1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, DFS(i, j));
            }
        }
        System.out.println(ans);
    }

    private static int DFS(int r, int c) {
        if (dp[r][c] == 0) {
            dp[r][c] = 1;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    if (map[r][c] < map[nr][nc]) {
                        dp[r][c] = Math.max(dp[r][c], DFS(nr, nc) + 1);
                    }
                }
            }
        }
        return dp[r][c];
    }
}
