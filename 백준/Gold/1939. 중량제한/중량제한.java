import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.weight, this.weight);
		}
	}
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;
	static int[] path;
	static int facSt, facEd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		V = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		adjList = new ArrayList[V + 1];
		dist = new int[V+1];
		path = new int[V+1];
		Arrays.fill(dist, -1);
		for (int i = 0; i <= V; i++)
			adjList[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stk.nextToken());
			int ed = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			adjList[st].add(new Node(ed, w));
			adjList[ed].add(new Node(st, w));
		}
		stk = new StringTokenizer(br.readLine());
		facSt = Integer.parseInt(stk.nextToken());
		facEd = Integer.parseInt(stk.nextToken());

		dikstra(facSt);
		System.out.println(dist[facEd]);

	}

	private static void dikstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		pq.add(new Node(st,INF));
		dist[st] = INF;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visited[curr.v]) continue;
			visited[curr.v] = true;
			for(Node node : adjList[curr.v]) {
				int w = Math.min(curr.weight, node.weight);
				if(dist[node.v] < w) {
					dist[node.v] = w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
		
	}
}
