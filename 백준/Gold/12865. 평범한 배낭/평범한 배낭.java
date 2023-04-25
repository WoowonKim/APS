import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] weight = new int[N+1];
		int[] worth = new int[N+1];
		int[] dp = new int[K+1];
		
		for(int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			worth[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = K; j >= weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-weight[i]]+worth[i]);
			}
		}
		System.out.println(dp[K]);
	}

}
