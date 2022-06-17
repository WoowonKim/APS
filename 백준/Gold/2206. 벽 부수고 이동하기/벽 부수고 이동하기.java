import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	static class Loc {
		int r;
		int c;
		int dist;
		boolean destroyed;
		
		public Loc(int r, int c, int dist, boolean destroyed) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.destroyed = destroyed;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		Queue<Loc> q = new LinkedList<Main.Loc>();
		q.add(new Loc(0, 0, 1, false));
		
		while(!q.isEmpty()) {
			Loc now = q.poll();
			
			if(now.r == N-1 && now.c == M-1 ) {
				System.out.println(now.dist);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				int dist = now.dist + 1;
				
				if(map[nr][nc]==0) {
					if(now.destroyed && !visited[nr][nc][1]) {
						q.add(new Loc(nr,nc,dist,true));
						visited[nr][nc][1] = true;
					} else if(!now.destroyed && !visited[nr][nc][0]) {
						q.add(new Loc(nr,nc,dist,false));
						visited[nr][nc][0] = true;
					}
				}else {
					if(!now.destroyed) {
						q.add(new Loc(nr,nc,dist,true));
						visited[nr][nc][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}

}