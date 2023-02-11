import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static boolean[][] isWall;

    static class Node {
        int r, c, dist, k;

        Node(int r, int c, int dist, int k) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.k = k;
        }

        @Override
        public String toString() {
            if(this.dist == Integer.MAX_VALUE) return "-1";
            return String.valueOf(this.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        isWall = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                isWall[i][j] = str.charAt(j) - '0' == 1;
            }
        }
        BFS();
    }

    private static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));
        boolean[][][] visited = new boolean[N][M][K + 1];
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int r = curr.r;
            int c = curr.c;
            if(r == N -1 && c == M - 1) {
                System.out.println(curr.dist);
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(isWall[nr][nc]) {
                    if (curr.k < K && !visited[nr][nc][curr.k + 1]) {
                       visited[nr][nc][curr.k+1] = true;
                       queue.add(new Node(nr, nc, curr.dist+1, curr.k+1));
                    }
                } else if(!visited[nr][nc][curr.k]) {
                    visited[nr][nc][curr.k] = true;
                    queue.add(new Node(nr, nc, curr.dist+1, curr.k));
                }

            }
        }
        System.out.println(-1);
    }

}