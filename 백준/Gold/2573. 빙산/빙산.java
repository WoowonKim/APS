import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 변수 선언
	static int[][] map;
	static int N, M;
	static boolean[][] visited;
	static int ans = 0;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 이차원 배열의 크기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		while (true) {
			year++;
			visited = new boolean[N][M];
			if(meltIce()) ans = cntIsland();
			if(ans ==-1) {
				ans = 0;
				break;
			} else if(ans >= 2) {
				ans = year;
				break;
			}
		}
		System.out.println(ans);
	}

	private static boolean meltIce() {
		boolean flag = false;
		int[][] meltedMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;
				int ocean = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if (nr >= N || nc >= M || nr < 0 || nc < 0 || map[nr][nc] != 0)
						continue;
					ocean++;
				}
				meltedMap[i][j] = map[i][j] - ocean;
				if (meltedMap[i][j] <= 0) {
					meltedMap[i][j] = 0;
					flag = true;
				} 
			}
		}
		map = meltedMap;
		return flag;
	}

	private static int cntIsland() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i,j);
					cnt++;
				}
			}
		}
		if (cnt == 0) cnt = -1;
		return cnt;
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr >= N || nc >= M || nr < 0 || nc < 0 || map[nr][nc] == 0 || visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				q.add(new int[] {nr,nc});
			}
		}
	}
}