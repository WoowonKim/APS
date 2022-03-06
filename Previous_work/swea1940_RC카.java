import java.util.Scanner;

public class swea1940_RC카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int v = 0;
			int d = 0;
			for (int i = 0; i < N; i++) {
				int c = sc.nextInt();
				switch (c) {
				case 0:
					d += v;
					break;
						
				case 1:
					v += sc.nextInt();
					d += v;
					break;

				case 2:
					v -= sc.nextInt();
					if (v < 0)
						v = 0;
					d += v;
					break;
				}
			}
			System.out.println("#" + tc + " " + d);
		}
		sc.close();
	}
}
