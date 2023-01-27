import java.util.*;
import java.io.*;

public class Solution {
    static class Node {
        String data;
        int num, left, right;
        boolean isNum = true;

        public Node(String data, int num) {
            this.data = data;
            this.num = num;
            if ("+-*/".contains(data)) {
                this.isNum = false;
            }
        }
    }

    static Node[] tree;

    public static void main(String args[]) throws Exception {

        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        for (int tc = 1; tc <= 10; tc++) {
            int ans = 0;
            int N = Integer.parseInt(br.readLine());
            tree = new Node[N + 1];
            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(stk.nextToken());
                String data = stk.nextToken();
                Node node = new Node(data, num);
                if (stk.hasMoreTokens()) node.left = Integer.parseInt(stk.nextToken());
                if (stk.hasMoreTokens()) node.right = Integer.parseInt(stk.nextToken());
                tree[num] = node;
            }
            ans = solve(1);
            System.out.println("#" + tc + " " + ans);
        }
    }

    private static int solve(int num) {
        Node curr = tree[num];
        int cal = 0;
        if (!curr.isNum) {
            switch (curr.data) {
                case "+":
                    cal = solve(curr.left) + solve(curr.right);
                    break;
                case "-":
                    cal = solve(curr.left) - solve(curr.right);
                    break;
                case "*":
                    cal = solve(curr.left) * solve(curr.right);
                    break;
                case "/":
                    cal = solve(curr.left) / solve(curr.right);
                    break;
            }

        } else {
            cal = Integer.parseInt(curr.data);
        }
        return cal;
    }
}