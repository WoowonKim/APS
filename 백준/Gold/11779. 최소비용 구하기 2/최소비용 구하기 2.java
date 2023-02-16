import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] dist;
    static int[] previous;
    static ArrayList<Edge>[] adj;

    static class Edge {
        int st, ed, w;

        Edge(int st, int ed, int w) {
            this.st = st;
            this.ed = ed;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        previous = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int ed = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            adj[st].add(new Edge(st, ed, w));
        }
        stk = new StringTokenizer(br.readLine());
        djikstra(Integer.parseInt(stk.nextToken()));
        printAns(Integer.parseInt(stk.nextToken()));
    }

    private static void djikstra(int st) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[st] = 0;
        pq.add(new int[]{st, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited[curr[0]]) continue;
            visited[curr[0]] = true;
            for (Edge next : adj[curr[0]]) {
                if (dist[next.ed] > curr[1] + next.w) {
                    dist[next.ed] = curr[1] + next.w;
                    previous[next.ed] = curr[0];
                    pq.add(new int[]{next.ed, curr[1] + next.w});
                }
            }
        }
    }
    private static void printAns(int ed) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        sb.append(dist[ed]).append("\n");
        int curr = ed;
        while(previous[curr] != 0) {
            stk.push(curr);
            curr = previous[curr];
        }
        stk.push(curr);
        sb.append(stk.size()).append("\n");
        while (!stk.isEmpty()) sb.append(stk.pop()).append(" ");
        System.out.println(sb);
    }

}