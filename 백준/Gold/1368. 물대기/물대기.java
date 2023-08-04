import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N;
    static List<List<Edge>> graph = new ArrayList<>();
    static int ans;

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 1; i <= N; i++) graph.get(0).add(new Edge(0, i, Integer.parseInt(br.readLine())));
        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(stk.nextToken());
                if (i != j) graph.get(i).add(new Edge(i, j, cost));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        prim();
        System.out.println(ans);
    }

    private static void prim() {
        PriorityQueue<Edge> queue = new PriorityQueue<>(graph.get(0));
        boolean[] visited = new boolean[N + 1];
        visited[0] = true;
        int cnt = 0;
        while (cnt < N) {
            Edge curr = queue.poll();
            if(visited[curr.to]) continue;
            visited[curr.to] = true;
            ans += curr.cost;
            cnt++;
            for (Edge edge : graph.get(curr.to)) if (!visited[edge.to]) queue.add(edge);
        }
    }
}
