import java.util.Scanner;

public class Main {
	static int[][] image;
	static StringBuffer sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());
		image = new int[N][N];
		sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < N; j++) {
				image[i][j] = Integer.parseInt(line.charAt(j)+"");
			}
		}
		zip(N, 0, 0);
		System.out.println(sb.toString());
		sc.close();
	}

	public static void zip(int N, int stR, int stC) {
		int CurrR = stR;
		int CurrC = stC;
		
		if (same(N, stR, stC)) {
			sb.append(image[stR][stC]);
			return;
		}
		sb.append("(");
		for (int idx = 0; idx < 4; idx++) {
			CurrR = stR + (N / 2) * (idx / 2);
			CurrC = stC +(N / 2) * (idx % 2);
			
			zip(N / 2, CurrR, CurrC);
		}
		sb.append(")");
	}

	public static boolean same(int N, int stR, int stC) {
		boolean flag = true;
		for (int i = stR; i <  stR + N; i++) {
			for (int j = stC; j < stC + N; j++) {
				if (image[stR][stC] != image[i][j])
					flag = false;
			}
		}
		return flag;
	}
}
