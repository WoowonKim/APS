import java.util.Scanner;

public class swea1979_어디단어 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int k = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						cnt++;
					if (map[i][j] == 0 || j == N - 1) {
						if (cnt == k)
							ans++;
						cnt = 0;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (map[j][i] == 1)
						cnt++;
					if (map[j][i] == 0 || j == N - 1) {
						if (cnt == k)
							ans++;
						cnt = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

}
