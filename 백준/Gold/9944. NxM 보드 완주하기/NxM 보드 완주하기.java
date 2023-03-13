
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int N, M, ans, remain;
	static final int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			try {
				init();
				solve();
				if(remain == 1) ans = 0;
				System.out.println("Case " + tc++ + ": " + (ans == Integer.MAX_VALUE ? -1 : ans));
			} catch (Exception e) {
				break;
			}
		}
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					for (int k = 0; k < 4; k++) {
						map[i][j] = 1;
						dfs(i, j, 1, 1, k);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	private static void dfs(int r, int c, int cnt, int score, int dir) {
		if (cnt == remain) {
			ans = Math.min(score, ans);
			return;
		}
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		if (!isOutSide(nr, nc) && map[nr][nc] == 0) {
			map[nr][nc] = 1;
			dfs(nr, nc, cnt + 1, score, dir);
			map[nr][nc] = 0;
		} else {
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (!isOutSide(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					dfs(nr, nc, cnt + 1, score + 1, i);
					map[nr][nc] = 0;
				}
			}
		}
	}

	private static boolean isOutSide(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M)
			return true;
		return false;
	}

	private static void init() throws IOException {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		remain = N * M;
		map = new int[N][M];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '*') {
					map[i][j] = 1;
					remain--;
				}
			}
		}
	}

}
