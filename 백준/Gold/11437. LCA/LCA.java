import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int num, depth;
        Node parent;
        ArrayList<Node> links = new ArrayList<>();
        Node(int num) {
            this.num = num;
        }
    }

    static int N;
    static Node[] tree;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) tree[i] = new Node(i);
        for (int i = 0; i < N - 1; i++) {
            stk = new StringTokenizer(br.readLine());
            Node node1 = tree[Integer.parseInt(stk.nextToken())];
            Node node2 = tree[Integer.parseInt(stk.nextToken())];
            node1.links.add(node2);
            node2.links.add(node1);
        }

        makeTree();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            solve(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }

        System.out.println(sb);

    }

    private static void makeTree() {
        Node root = tree[1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.depth = 0;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            visited[curr.num] = true;
            for (Node link : curr.links) {
                if(visited[link.num]) continue;
                link.parent = curr;
                link.depth = curr.depth + 1;
                queue.add(link);
            }
        }
    }

    private static void solve(int num1, int num2) {
        Node node1 = tree[num1];
        Node node2 = tree[num2];
        while (node1.depth != node2.depth) {
            if(node1.depth > node2.depth) node1 = node1.parent;
            else node2 = node2.parent;
        }
        while (node1 != node2) {
            node1 = node1.parent;
            node2 = node2.parent;
        }
        sb.append(node1.num).append("\n");

    }

}
