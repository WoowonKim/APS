import java.util.Scanner;

public class swea1954_달팽이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int N = sc.nextInt();
			int[][] ans = new int[N][N];

			int k = N;
			int change = 1;
			int x = 0, y = -1;
			int num = 0;
			while (true) {
				for (int i = 0; i < k; i++) {
					y += change;
					ans[x][y] = ++num;
				}
				k--;
				if (k == 0)
					break;
				for (int i = 0; i < k; i++) {
					x += change;
					ans[x][y] = ++num;
				}
				change *= -1;
			}
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("%d ", ans[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
