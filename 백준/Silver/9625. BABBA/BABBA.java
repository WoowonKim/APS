import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[][] dp = new int[46][2];
		dp[0][0] = 1;
		for(int i = 1; i <= K; i++) {
			dp[i][1] = dp[i-1][0] + dp[i-1][1];
			dp[i][0] = dp[i-1][1];
		}
		System.out.println(dp[K][0] + " " + dp[K][1]);
	}

}
