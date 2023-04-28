import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(stk.nextToken()) - 1;
            int p = Integer.parseInt(stk.nextToken());
            if (i + t <= N) {
                dp[i + t] = Math.max(dp[i + t], max + p);
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
