import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static final int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, L, R, unionP, unionN, unionIdx = 1;
	static int[][] pMap, uMap;
	static boolean[][] visited;
	static HashMap<Integer, Integer> union  = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		pMap = new int[N][N];
		uMap = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				pMap[i][j] = sc.nextInt();
			}
		}
		
		while (setUnion()) {
			ans++;
			move();
			unionIdx = 1;
			union = new HashMap<Integer, Integer>();
			uMap = new int[N][N];
			visited = new boolean[N][N];
		}
		System.out.println(ans);
	}

	private static boolean setUnion() {
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(uMap[i][j] != 0) continue;
				DFS(i, j);
				union.put(unionIdx, unionP/unionN);
				unionIdx++;
				unionP = 0;
				unionN = 0;
			}
		}
		if(union.size()==N*N) flag = false;
		return flag;
	}

	private static void move() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				pMap[i][j] = union.get(uMap[i][j]);
			}
		}

	}

	private static void DFS(int r, int c) {
		visited[r][c] = true;
		unionP += pMap[r][c];
		unionN += 1;
		uMap[r][c] = unionIdx;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (visited[nr][nc])
				continue;
			if (Math.abs(pMap[r][c] - pMap[nr][nc]) > R || Math.abs(pMap[r][c] - pMap[nr][nc]) < L)
				continue;
			
			DFS(nr, nc);
		}
	}
}
