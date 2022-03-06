import java.util.Scanner;

public class swea_view {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 10; testCase++) {
			int T;
			T = sc.nextInt();

			int[] apt = new int[T];
			for (int i = 0; i < T; i++) {
				apt[i] = sc.nextInt();
			}
			int ans = 0;
			for (int aptNum = 2; aptNum < T - 2; aptNum++) {
				int minDiff = 255;
				for (int aptSur = aptNum - 2; aptSur <= aptNum + 2; aptSur++) {
					if (aptSur == aptNum)
						continue;
					int diff = apt[aptNum] - apt[aptSur];
					if (diff <= minDiff) {
						minDiff = diff;
					}
				}
				if (minDiff <= 0)
					continue;
				ans += minDiff;
			}
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
