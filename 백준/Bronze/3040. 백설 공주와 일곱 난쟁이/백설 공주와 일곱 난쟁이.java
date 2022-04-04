import java.util.Scanner;

public class Main {
	static int[] minions;
	static int[] sel;
	static int N = 9, R = 7;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		minions = new int[N];
		sel = new int[R];
	
		for (int i = 0; i < N; i++) {
			minions[i] = sc.nextInt();
		}

		combination(0, 0);
		sc.close();
	}

	private static void combination(int idx, int sidx) {
		if (sidx == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += sel[i];
			}
			if (sum == 100) {
				for(int i=0; i < R;i++) System.out.println(sel[i]);
				return;
			}
			return;
		} 
		
		for(int i = idx; i <= N-R+sidx; i++) {
			sel[sidx] = minions[i];
			combination(i+1, sidx+1);
		}

	}
}
