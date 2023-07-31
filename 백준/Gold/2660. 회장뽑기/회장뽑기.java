import java.util.*;

class Main {
    static int N;
    static int[][] adj;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) {
                if (i != j) adj[i][j] = Integer.MAX_VALUE;
            }
        while (true) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if (num1 == -1 && num2 == -1) break;
            else {
                adj[num1][num2] = adj[num2][num1] = 1;
            }
        }
    }

    public static void main(String[] args) {
        input();
        floyd();
        System.out.println(ans());
    }


    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE) continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }

    private static StringBuilder ans() {
        StringBuilder sb = new StringBuilder();
        int[] dist = new int[N + 1];
        int score = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, adj[i][j]);
            }
            dist[i] = max;
            score = Math.min(score, max);
        }
        sb.append(score).append(" ");

        for (int i = 1; i <= N; i++) if (dist[i] == score) queue.add(i);
        sb.append(queue.size()).append("\n");
        while (!queue.isEmpty()) sb.append(queue.poll()).append(" ");

        return sb;
    }
}
