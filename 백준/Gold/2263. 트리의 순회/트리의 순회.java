import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int N;
    static int[] in, inIdx, post;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        in = new int[N + 1];
        inIdx = new int[N + 1];
        post = new int[N + 1];
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            in[i] = Integer.parseInt(stk.nextToken());
            inIdx[in[i]] = i;
        }
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) post[i] = Integer.parseInt(stk.nextToken());
        getPre(1, N, 1, N);
        System.out.println(sb);
    }

    private static void getPre(int inSt, int inEd, int postSt, int postEd) {
        if (inSt > inEd) return;

        int root = post[postEd];
        sb.append(root).append(" ");

        int rootIdx = inIdx[root];
        int left = rootIdx - inSt;

        getPre(inSt, rootIdx - 1, postSt, postSt + left - 1);
        getPre(rootIdx + 1, inEd, postSt + left, postEd - 1);
    }
}