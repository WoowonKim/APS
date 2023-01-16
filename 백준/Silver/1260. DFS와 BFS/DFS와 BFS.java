import java.util.*;

public class Main {
    static int N, M, ST;
    static boolean[] visited;
    static StringBuilder sb;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        ST = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        for (ArrayList arr : graph) {
            Collections.sort(arr);
        }
        sb = new StringBuilder();
        DFS(ST);
        System.out.println(sb);
        sb = new StringBuilder();
        visited = new boolean[N + 1];
        BFS(ST);
        System.out.println(sb);
    }

    private static void BFS(int st) {
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visited[st] = true;
        sb.append(st).append(" ");
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph[curr]) {
                if (visited[next]) continue;
                visited[next] = true;
                sb.append(next).append(" ");
                q.add(next);
            }
        }
    }

    private static void DFS(int curr) {
        visited[curr] = true;
        sb.append(curr).append(" ");
        for (int next : graph[curr]) {
            if(!visited[next]) DFS(next);
        }

    }
}
