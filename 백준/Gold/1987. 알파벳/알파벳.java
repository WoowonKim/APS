import java.io.FileInputStream;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int ans, R, C;
    static int[][] map;
    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) - 'A';
            }
        }
        ans = 0;
        visited = new boolean[26];
        travel(0, 0, 0);
        System.out.println(ans);

    }

    private static void travel(int r, int c, int gifts) {
        if (visited[map[r][c]]) {
            ans = Math.max(ans, gifts);
            return;
        }
        visited[map[r][c]] = true;
        gifts += 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
                travel(nr, nc, gifts);
            } else {
                ans = Math.max(ans, gifts);
            }
        }
        visited[map[r][c]] = false;
        gifts -= 1;
    }

}
