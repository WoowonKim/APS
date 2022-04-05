import java.util.LinkedList;
import java.util.Queue;
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[][] tomatos = new int[N][M];
		int ans = 0;
		Queue<Pos> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int tomato = sc.nextInt();
				tomatos[i][j] = tomato;
				if (tomato == 1)
					queue.add(new Pos(i, j));
			}
		}
		while (!queue.isEmpty()) {
			Pos curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (tomatos[nr][nc] == 0) {
					tomatos[nr][nc] = tomatos[curr.r][curr.c] + 1;
					queue.add(new Pos(nr, nc));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomatos[i][j]==0) {
					System.out.println(-1);
					return;
				}
				if(ans<tomatos[i][j]) ans = tomatos[i][j];
			}
		}
		System.out.println(ans-1);
		sc.close();
	}

}
