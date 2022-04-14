import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int N, M;
	static List<int[]> virus;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		virus = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}
		getWall(0);
		System.out.println(ans);
		sc.close();
	}

	private static void getWall(int cnt) {
		if (cnt == 3) {
			virus_bfs();
			return;
			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					getWall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	private static void virus_bfs() {
		int[][] copyMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		for (int[] vi : virus) {
			q.add(vi);
		}
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (copyMap[nr][nc] == 0) {
					copyMap[nr][nc] = 2;
					q.add(new int[] { nr, nc });
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0)
					cnt++;
			}
		}
		ans = Math.max(ans, cnt);
	}
}
