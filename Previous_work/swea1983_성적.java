import java.util.Arrays;
import java.util.Scanner;

public class swea1983_성적 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] grades = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int k = sc.nextInt() - 1;
			float[] sum = new float[N];
			for (int i = 0; i < N; i++) {
				sum[i] += sc.nextFloat() * 0.35 + sc.nextFloat() * 0.45 + sc.nextFloat() * 0.2;
			}
			float score = sum[k];
			Arrays.sort(sum);
			int st = -1;
			for (int i = 0; i < N; i++) {
				if (sum[i] == score) {
					st = i;
					break;
				}
			}
			st = N - 1 - st;
			System.out.println("#" + tc + " " + grades[st / (N / 10)]);
		}
		sc.close();
	}
}
