
import java.io.*;
import java.util.*;

public class Main {

	static final int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, R, C, day;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> waterQ, swanQ;
	static int[] target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		waterQ = new LinkedList<>();
		swanQ = new LinkedList<>();

		boolean flag = false;
		for (int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				// -1 : 빙하, 0 바다
				if (str[j] == '.') {
					waterQ.add(new int[] { i, j });
					continue;
				}
				if (str[j] == 'X')
					map[i][j] = -1;
				else if (!flag) {
					swanQ.add(new int[] { i, j });
					waterQ.add(new int[] { i, j });
					flag = true;
					visited[i][j] = true;
				} else {
					target = new int[] { i, j };
					waterQ.add(new int[] { i, j });
				}
			}
		}

		day = 0;
		while (true) {
			if (union())
				break;
			;
			melt();
		}

		System.out.println(day);

	}

	private static void melt() {
		Queue<int[]> waterTmp = new LinkedList<>();
		while (!waterQ.isEmpty()) {
			int[] curr = waterQ.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				if (map[nr][nc] == -1) {
					map[nr][nc] = 0;
					waterTmp.add(new int[] { nr, nc });
				}
			}
		}
		waterQ = waterTmp;
		day++;
	}

	private static boolean union() {
		Queue<int[]> swanTmp = new LinkedList<>();
		while (!swanQ.isEmpty()) {
			int[] curr = swanQ.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				if (map[nr][nc] == -1)
					swanTmp.add(new int[] { nr, nc });
				else
					swanQ.add(new int[] { nr, nc });
				if (nr == target[0] && nc == target[1])
					return true;
			}
		}
		swanQ = swanTmp;
		return false;
	}

}
