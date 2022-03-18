import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] cost = new int[N][3];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		int ans = Integer.MAX_VALUE;
		dp[0][0] += cost[0][0];
		dp[0][1] += cost[0][1];
		dp[0][2] += cost[0][2];

		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1] , dp[i-1][2] ) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0] , dp[i-1][2] ) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0] , dp[i-1][1] ) + cost[i][2];
		}
		for (int i = 0; i < 3; i++) {
			if (ans > dp[N-1][i])
				ans = dp[N-1][i];
		}
		System.out.println(ans);
	}
}
