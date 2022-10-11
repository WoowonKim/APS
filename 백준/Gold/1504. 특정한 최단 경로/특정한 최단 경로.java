import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 200000000;
    static class Node implements Comparable<Node>{
        int ed, w;
        public Node( int ed, int w) {
            this.ed = ed;
            this.w = w;
        }
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());
        ArrayList<Node>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<Node>();

        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            graph[st].add(new Node(ed, w));
            graph[ed].add(new Node(st, w));
        }

        stk = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(stk.nextToken());
        int v2 = Integer.parseInt(stk.nextToken());

        int[][] dijkstra = new int[4][n+1];
        for (int i = 1; i <= 3; i++) {
            Arrays.fill(dijkstra[i], INF);
        }
        for (int i = 1; i <= 3; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[n+1];
            int[] dist = dijkstra[i];
            int start = i == 1 ? 1 : i == 2 ? v1 : v2 ;
            dist[start] = 0;
            pq.add(new Node(start, 0));

            while(!pq.isEmpty()) {
                Node curr = pq.poll();
                if(visited[curr.ed]) continue;
                visited[curr.ed] = true;
                for(Node next : graph[curr.ed]){
                    if(dist[next.ed] > next.w + curr.w) {
                        dist[next.ed] = next.w + curr.w;
                        pq.add(new Node(next.ed, dist[next.ed]));
                    }
                }
            }
        }
        //v1 : 2  v2 : 3
        int ans = Math.min(dijkstra[1][v1] + dijkstra[2][v2] + dijkstra[3][n],dijkstra[1][v2] + dijkstra[3][v1] + dijkstra[2][n]);
        System.out.println(ans < INF? ans : -1);
    }
}