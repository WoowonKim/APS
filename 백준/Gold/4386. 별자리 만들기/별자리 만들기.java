import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Star {
		float x, y;

		public Star(float x, float y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int st;
		int ed;
		float cost;

		public Edge(int st, int ed, float cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Float.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Star[] stars = new Star[N];
		for(int i = 0; i < N; i++) {
			stars[i] = new Star(sc.nextFloat(),sc.nextFloat());
		}
		List<Edge>[] adjList = new ArrayList[N];
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				float dist = getDist(stars[i],stars[j]);
				adjList[i].add(new Edge(i,j,dist));
				adjList[j].add(new Edge(j,i,dist));
			}
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		visited[0] = true;
		pq.addAll(adjList[0]); 

		int cnt = 1;
		float ans = 0;

		while (cnt != N) {
			Edge edge = pq.poll();	
			if (visited[edge.ed])
				continue;
			ans += edge.cost;
			pq.addAll(adjList[edge.ed]);
			visited[edge.ed] = true;
			cnt++;
		}

		System.out.printf("%.2f",ans);

		sc.close();
	}

	private static float getDist(Star star, Star star2) {
		float diffX = star.x - star2.x;
		float diffY = star.y - star2.y;
		return (float) Math.sqrt((diffX*diffX)+(diffY*diffY));
	}
	
}
