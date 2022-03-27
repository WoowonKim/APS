import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		for(int i = 0; i < dp.length; i++) {
			dp[i] = 100000000;
		}
		dp[0] = 0;
		for(int i = 0; i<dp.length; i++) {
			for(int j = 1; i+j*j<dp.length; j++) {
				dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
			}
		}
		System.out.println(dp[N]);
		sc.close();
	}
}
