import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int a, b, weight;

        Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }

    static int[] root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Edge> graph = new ArrayList<>();
        root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int weight = Integer.parseInt(stk.nextToken());
                if (j > i) graph.add(new Edge(i, j, weight));
            }
        }
        graph.sort(((o1, o2) -> o1.weight - o2.weight));
        long ans = 0;
        for (Edge curr : graph) {
            if (find(curr.a) != find(curr.b)) {
                ans += curr.weight;
                union(curr.a, curr.b);
            }
        }
        System.out.println(ans);
    }

    private static int find(int curr) {
        if (root[curr] == curr) return curr;
        else return root[curr] = find(root[curr]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        root[y] = x;
    }
}
