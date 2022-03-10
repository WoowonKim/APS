import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int[] dp = new int[N+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i]=99999;
		}
		dp[N] = 0;
		for(int i = N; i>=1; i--) {
			dp[i-1] = Math.min(dp[i]+1, dp[i-1]);
			if (i%2 == 0) dp[i/2] = Math.min(dp[i]+1, dp[i/2]);
			if (i%3 == 0) dp[i/3] = Math.min(dp[i]+1, dp[i/3]);
		}
		System.out.println(dp[1]);
	}

}
