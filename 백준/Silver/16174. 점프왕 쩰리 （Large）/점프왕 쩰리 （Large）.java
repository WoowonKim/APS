import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static final int[] dr = {1, 0}, dc = {0, 1};
	static boolean ans = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			if(i+map[i][N-1] == N-1) flag = true;
			if(i+map[N-1][i] == N-1) flag = true;
		}
		if(!flag) System.out.println("Hing"); 
		else {
			DFS(0,0);
			if(ans) System.out.println("HaruHaru");
			else System.out.println("Hing");
		}
		sc.close();
	}
	private static void DFS(int stR, int stC) {
		if(stR == N-1 && stC == N-1) {
			ans = true;
			return;
		}
		for(int i = 0; i < 2; i++) {
			int nr = stR + dr[i]*map[stR][stC];
			int nc = stC + dc[i]*map[stR][stC];
			if(nr >= N || nc >= N) continue;
			if(ans) return;
			DFS(nr,nc);
		}
		
	}

}
