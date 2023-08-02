import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, M;
    static int[] ans, scores;
    static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        ans = new int[N + 1];
        scores = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        stk.nextToken();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());
        for (int i = 2; i <= N; i++) tree.get(Integer.parseInt(stk.nextToken())).add(i);

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            scores[Integer.parseInt(stk.nextToken())] += Integer.parseInt(stk.nextToken());
        }
        dfs(1, 0);
        for (int i = 1; i <= N; i++) System.out.print(ans[i] + " ");

    }

    private static void dfs(int num, int score) {
        ans[num] += score;
        for (int i : tree.get(num)) {
            dfs(i, score + scores[i]);
        }
    }
}