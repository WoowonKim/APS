import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visited = new boolean[n];
        int m = sc.nextInt();
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            adj[num1].add(num2);
            adj[num2].add(num1);
        }
        for (int i = 0; i < n; i++) {
            if(dfs(i,1)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean dfs(int curr, int depth) {
        if(depth == 5) {
            return true;
        }
        visited[curr] = true;
        for(int next : adj[curr]) {
            if(visited[next]) continue;
            if(dfs(next, depth+1)) return true;
        }
        visited[curr] = false;
        return false;
    }
}


