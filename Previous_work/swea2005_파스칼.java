import java.util.Scanner;

public class swea2005_파스칼 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			System.out.println("#" + tc);
			int[][] fibo = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i + 1; j++) {
					if (j == 0) {
						fibo[i][j] = 1;
						System.out.print(1 + " ");
						if(i == 0) System.out.println();
						continue;
					}
					if (j == i) {
						fibo[i][j] = 1;
						System.out.println(1);
						continue;
					}
					fibo[i][j] = fibo[i - 1][j] + fibo[i - 1][j - 1];
					System.out.printf("%d ", fibo[i][j]);
				}
			}

		}
		sc.close();
	}

}
