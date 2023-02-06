import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int num;
        ArrayList<Node> link;
        int subtreeCnt;

        public Node(int num) {
            this.num = num;
            this.subtreeCnt = 0;
            this.link = new ArrayList<>();
        }
    }

    static int N, R, Q;
    static Node[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());
        tree = new Node[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) tree[i] = new Node(i);
        for (int i = 1; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            Node node1 = tree[Integer.parseInt(stk.nextToken())];
            Node node2 = tree[Integer.parseInt(stk.nextToken())];
            node1.link.add(node2);
            node2.link.add(node1);
        }
        countSubTree(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(tree[q].subtreeCnt).append("\n");
        }
        System.out.println(sb);
    }

    private static int countSubTree(int num) {
        Node curr = tree[num];
        curr.subtreeCnt = 1;
        visited[curr.num] = true;
        for (Node link : curr.link) {
            if(visited[link.num]) continue;
            curr.subtreeCnt += countSubTree(link.num);
        }
        return curr.subtreeCnt;
    }
}