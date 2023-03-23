import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {//[16955] 오목, 이길 수 있을까?

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[10][];
        for (int i = 0; i < 10; i++) {
            map[i] = br.readLine().toCharArray();
        }
        boolean ans = false;
        out:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'X';
                    if (isFive(map, i, j)) {
                        ans = true;
                        break out;
                    }
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(ans ? 1 : 0);
    }

    static final int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
    static final int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};

    private static boolean isFive(char[][] map, int r, int c) {
        for (int i = 0; i < 8; i += 2) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[10][10];
            q.add(new int[]{r, c});
            int cnt = 0;
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                if (visited[curr[0]][curr[1]]) continue;
                visited[curr[0]][curr[1]] = true;
                cnt++;
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if (!isOut(nr, nc) && map[nr][nc] == 'X') {
                    q.add(new int[]{nr, nc});
                }
                nr = curr[0] + dr[i + 1];
                nc = curr[1] + dc[i + 1];
                if (!isOut(nr, nc) && map[nr][nc] == 'X') {
                    q.add(new int[]{nr, nc});
                }
            }
            if (cnt >= 5) return true;
        }
        return false;
    }

    private static boolean isOut(int r, int c) {
        return r < 0 || c < 0 || r >= 10 || c >= 10;
    }

}
