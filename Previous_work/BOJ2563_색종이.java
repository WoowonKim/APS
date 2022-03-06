import java.util.Scanner;

public class BOJ2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] whiteP = new int[100][100];
		int paper = sc.nextInt();
		for (int i = 0; i < paper; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					whiteP[j][k] = 1;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (whiteP[i][j] == 1) {
					ans += 1;
				}
			}
		}
		System.out.println(ans);
		sc.close();

	}
}
