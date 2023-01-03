import java.util.*;

public class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static int N, M, cheeseCnt;
    static int[] ans = {0, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) cheeseCnt++;
            }
        }
        while (cheeseCnt > 0) {
            ans[0]++;
            ans[1] = cheeseCnt;
            visited = new boolean[N][M];
            meltCheese();
        }
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    private static void meltCheese() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 0) {
                        queue.add(new int[]{nr, nc});
                    } else {
                        cheeseCnt--;
                        map[nr][nc] = 0;
                    }
                }
            }
        }
    }

}


