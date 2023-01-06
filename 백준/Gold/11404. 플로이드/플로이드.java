import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        final int INF = 10000001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            Arrays.fill(dist[i], INF);
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            graph[from].add(new Node(to, cost));
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dijkstra(i);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(dist[i][j] != INF ? dist[i][j] : 0);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void dijkstra(int st) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(st, 0));
        dist[st][st] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (!visited[curr.v]) visited[curr.v] = true;
            for (Node next : graph[curr.v]) {
                if (!visited[next.v] && dist[st][next.v] > curr.cost + next.cost) {
                    dist[st][next.v] = curr.cost + next.cost;
                    pq.add(new Node(next.v, dist[st][next.v]));
                }
            }
        }
    }
}