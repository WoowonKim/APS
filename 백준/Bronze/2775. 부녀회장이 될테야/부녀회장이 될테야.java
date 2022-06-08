import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] map = new int[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (i == 0) {
					map[i][j] = j+1;
					continue;
				}
				if (j == 0)
					map[i][j] = 1;
				else {
					map[i][j] = map[i-1][j] + map[i][j-1];
				}
			}
		}
		for (int tc = 0; tc < T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(map[k][n-1]);
		}
	}
}