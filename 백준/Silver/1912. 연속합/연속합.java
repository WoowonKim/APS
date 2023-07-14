import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            int curr = sc.nextInt();
            dp[i] = Math.max(dp[i - 1] + curr, curr);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
