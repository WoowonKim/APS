import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int V, E;
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            stk = new StringTokenizer(br.readLine());
            V = Integer.parseInt(stk.nextToken());
            E = Integer.parseInt(stk.nextToken());
            adj = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();
            for (int i = 1; i <= E; i++) {
                stk = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(stk.nextToken());
                int num2 = Integer.parseInt(stk.nextToken());
                adj[num1].add(num2);
                adj[num2].add(num1);
            }
            System.out.println(solve() ? "YES" : "NO");
        }
    }

    private static boolean solve() {
        int[] visited = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, 1);
            }
        }
        for (int i = 1; i <= V; i++) {
            for (int j : adj[i]) {
                if (visited[i] == visited[j]) return false;
            }
        }
        return true;
    }

    private static void dfs(int x, int[] visited, int t) {
        visited[x] = t;
        for (int c: adj[x]) {
            if (visited[c] == 0) dfs(c, visited, 3 - t);
        }
    }
}
