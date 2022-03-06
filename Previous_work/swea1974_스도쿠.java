import java.util.Scanner;

public class swea1974_스도쿠 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[][] sdoku = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sdoku[i][j] = sc.nextInt();
				}
			}
			System.out.println("#" + tc + " " + check(sdoku));
		}
		sc.close();
	}

	static int check(int[][] sdoku) {

		for (int i = 0; i < 9; i++) {
			int sumRow = 0, sumCol = 0;
			for (int j = 0; j < 9; j++) {
				sumRow += sdoku[i][j];
				sumCol += sdoku[j][i];
			}
			if (sumRow != 45 || sumCol != 45) {
				return 0;
			}
		}
		for (int k = 0; k < 9; k += 3) {
			int sumSqr = 0;
			for (int i = k; i < k+3; i++) {
				for (int j = k; j < k+3; j++) {
					sumSqr += sdoku[i][j];
				}
				}
			if (sumSqr != 45) {
				return 0;
			}
		}
		return 1;
	}
}
