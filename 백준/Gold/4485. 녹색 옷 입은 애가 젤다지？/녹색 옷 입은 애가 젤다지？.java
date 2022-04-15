import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node> {
		int vx, vy, weight;

		public Node(int vx, int vy, int weight) {
			this.vx = vx;
			this.vy = vy;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	static final int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, ans;
	static int[][] map, dist;

	public static void main(String[] args) {
		int tc = 1;
		Scanner sc = new Scanner(System.in);
		while (true) {
			N = sc.nextInt();
			if (N == 0)
				break;
			map = new int[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dijkstra(0, 0);
			System.out.printf("Problem %d: %d\n", tc++, ans);
		}
		sc.close();
	}

	private static void dijkstra(int stR, int stC) {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[0][0] = map[stR][stC];
		pq.add(new Node(stR, stC, map[stR][stC]));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.vx][curr.vy])
				continue;
			visited[curr.vx][curr.vy] = true;
			for (int i = 0; i < 4; i++) {
				int nr = curr.vx + dr[i];
				int nc = curr.vy + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if(dist[nr][nc] > dist[curr.vx][curr.vy] + map[nr][nc]) {
					dist[nr][nc] = dist[curr.vx][curr.vy] + map[nr][nc];
					pq.add(new Node(nr,nc,dist[nr][nc]));
				}
			}
		}
		ans = dist[N-1][N-1];
	}
}
