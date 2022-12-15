import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        ArrayList<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int r = sc.nextInt();
            adj[num1].add(new int[]{num2, r});
            adj[num2].add(new int[]{num1, r});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);
            visited[v] = true;
            
            int cnt = 0;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int[] edge : adj[curr]) {
                    if (!visited[edge[0]] && edge[1] >= k) {
                        queue.add(edge[0]);
                        visited[edge[0]] = true;
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}


