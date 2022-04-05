import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] map;
	static int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static int w, h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 & h == 0)
				break;
			List<Pos> list = new ArrayList<>();
			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						list.add(new Pos(i, j));
					}
				}
			}
			int ans = 0;
			for (Pos idx : list) {
				if(map[idx.r][idx.c]==1) {
					map[idx.r][idx.c]=2;
					dfs(idx.r, idx.c);
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 2)
						ans++;
				}
			}

			System.out.println(ans);
		}
		sc.close();
	}

	private static void dfs(int r, int c) {
		
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= h || nc < 0 || nc >= w)
				continue;
			if (map[nr][nc] == 0 || map[nr][nc] == 2)
				continue;
			map[nr][nc] = 0;
			dfs(nr, nc);
		}
	}
}
