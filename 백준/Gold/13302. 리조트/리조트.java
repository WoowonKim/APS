import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int dp[][], N, M;
	static boolean rest[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		rest = new boolean[N + 1];
		while (M-- > 0) {
			rest[sc.nextInt()] = true;
		}
		dp = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(solve(1, 0));
	}

	private static int solve(int day, int coupon) {
		// TODO Auto-generated method stub
		if (day > N)
			return 0;

		if (dp[day][coupon] != -1)
			return dp[day][coupon];

		dp[day][coupon] = Integer.MAX_VALUE;
		if (rest[day]) {
			return dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 1, coupon));
		} else {
			if (coupon >= 3) {
				dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 1, coupon - 3));
			}
			dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 1, coupon) + 10000);
			dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 3, coupon + 1) + 25000);
			dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 5, coupon + 2) + 37000);
		}
		return dp[day][coupon];
	}
}