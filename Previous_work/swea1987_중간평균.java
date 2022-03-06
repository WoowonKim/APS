import java.util.Scanner;

public class swea1987_중간평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {

			int[] nums = new int[10];
			for (int i = 0; i < 10; i++) {
				nums[i] = sc.nextInt();
			}

			for (int idx = 0; idx < 9; idx++) {

				int minIdx = idx;
				for (int i = idx + 1; i < 10; i++) {

					if (nums[i] < nums[minIdx]) {
						minIdx = i;
					}
				}
				int tmp = nums[idx];
				nums[idx] = nums[minIdx];
				nums[minIdx] = tmp;
			}
			int ans = 0;
			for (int i=1; i<9; i++) {
				ans += nums[i];
			}
			System.out.printf("#%d %.0f\n",testCase,ans/8.0);
		}
	}
}
