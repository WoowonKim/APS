import java.util.*;

public class Main {
	static int[] dp;
	static boolean[] visited;
	static Wire[] wires;
	static int N;
	
	static class Wire {
		int A, B, cnt;

		public Wire(int A, int B) {
			this.A = A;
			this.B = B;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		wires = new Wire[N];
		dp = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			wires[i]=new Wire(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(wires, (o1, o2) -> o1.A - o2.A);
		int max = 0;
		for(int i = 0; i <N; i++) {
			max = Math.max(recur(i), max);
		}
		System.out.println(N-max);
	}

	private static int recur(int n) {
		if(!visited[n]) {
			visited[n] = true;
			dp[n] = 1;
			for(int i = n+1; i < N; i++) {
				if(wires[n].B < wires[i].B) {
					dp[n] = Math.max(dp[n], recur(i) + 1);
				}
			}
		}
		return dp[n];
	}
}