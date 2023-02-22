import java.util.*;
import java.io.*;

public class Main {
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int N, M, ans;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        ans = 0;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) continue;
                ans++;
                bfs(i, j);
            }
        }
        System.out.println(ans);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nr = (curr[0] + dr[i] + N ) % N;
                int nc = (curr[1] + dc[i] + M) % M;
                if(map[nr][nc] == 1) continue;
                map[nr][nc] = 1;
                queue.add(new int[]{nr,nc});
            }
        }
    }
}
