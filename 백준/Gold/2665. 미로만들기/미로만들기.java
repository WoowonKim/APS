import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map, dist;
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            String stk = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = (stk.charAt(j) - '0');
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dijkstra();
        System.out.println(dist[N-1][N-1]);
    }

    private static void dijkstra() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < N && nc < N && dist[nr][nc] > dist[r][c]) {
                    dist[nr][nc] = dist[r][c] + (map[nr][nc] - 1) * -1;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
    }

}