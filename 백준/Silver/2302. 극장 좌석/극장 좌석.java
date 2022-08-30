import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        int tmp = 0;
        for(int i=0;i<m;i++) {
            int p = sc.nextInt();
            ans *= dp[p-tmp-1];
            tmp = p;
        }
        ans *= dp[n - tmp];
        System.out.println(ans);
    }
}