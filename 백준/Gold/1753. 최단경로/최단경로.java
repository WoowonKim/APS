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
		int ed, weight;

		public Node(int ed, int weight) {

			this.ed = ed;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stk.nextToken());
		int E = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(br.readLine());
		List<Node>[] adjArr = new ArrayList[V + 1];
		boolean[] visited = new boolean[V + 1];
		int[] dist = new int[V + 1];
		for (int i = 0; i <= V; i++)
			adjArr[i] = new ArrayList<Node>();

		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stk.nextToken());
			int ed = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			Node node = new Node(ed, w);
			adjArr[st].add(node);
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Arrays.fill(dist, Integer.MAX_VALUE);

		pq.add(new Node(K, 0));
		dist[K] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.ed])
				continue;
			visited[curr.ed] = true;
			for (Node node : adjArr[curr.ed]) {
				// 이미 알고 있는 거리보다 더 가깝게 도달 할 수 있다면
				if (!visited[node.ed] && dist[node.ed] > dist[curr.ed] + node.weight) {
					dist[node.ed] = dist[curr.ed] + node.weight;
					pq.add(new Node(node.ed, dist[node.ed]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if(dist[i]== Integer.MAX_VALUE)System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}

}
