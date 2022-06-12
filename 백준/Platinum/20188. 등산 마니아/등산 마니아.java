import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static long result = 0;
	static int[] dp;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}

		Dp(1);
		System.out.println(result);
	}

	private static int Dp(int now) {
		// TODO Auto-generated method stub
		dp[now] = 1;

		for (int next : list[now]) {
			if (dp[next] == 0) {
				dp[now] += Dp(next);
			}
		}
		if (now != 1) {
			result += comb(N) - comb(N - dp[now]);
		}
		return dp[now];
	}

	private static long comb(int n) {
		return (long) n * (long) (n - 1) / 2;
	}

}