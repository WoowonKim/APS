import java.util.Scanner;

public class Main {
    static final int div = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        long[][] dp = new long[n + 1][2];
        dp[0][0] =1;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = ((dp[i - 1][0] + dp[i - 1][1]) * (a[i] + b[i - 1] - 1) + dp[i - 1][0]) % div;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * b[i] % div;
        }
        System.out.println(dp[n][0]);
    }
}