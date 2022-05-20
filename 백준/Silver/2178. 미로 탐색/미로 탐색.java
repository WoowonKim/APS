import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];
		dist[0][0] = 1;
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
				if(map[nr][nc] == 0 || (nr == 0 && nc == 0)) continue;
				if(dist[nr][nc] == 0) {
					dist[nr][nc] = dist[r][c] + 1;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		System.out.println(dist[N-1][M-1]);
	}
}
