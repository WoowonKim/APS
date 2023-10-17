import java.util.*;
class Solution {
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static int[][] dist;
    public int solution(int[][] maps) {
        map = maps;
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];
        dist[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(canMoveTo(nr, nc) && dist[nr][nc] == 0) {
                    queue.add(new int[]{nr, nc});
                    dist[nr][nc] = dist[r][c] + 1;
                }
            }
            
        }
        
        return dist[n-1][m-1] != 0 ? dist[n-1][m-1] : -1;
    }
    
    public boolean canMoveTo(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m && map[r][c] == 1;
    }
}