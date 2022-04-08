import java.util.Scanner;

public class Main {
	static int[] nums, op;
	static int N;
	static int max, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		op = new int[4];
		for (int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}
		recur(nums[0], 1);
		System.out.printf("%d\n%d", max, min);
		sc.close();
	}

	public static void recur(int val, int idx) {
		if (idx == N) {
			if (val > max)
				max = val;
			if (val < min)
				min = val;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				recur(cal(val, nums[idx], i), idx + 1);
				op[i]++;
			}
		}
	}

	public static int cal(int val, int val2, int i) {
		if (i == 0)
			return val + val2;
		if (i == 1)
			return val - val2;
		if (i == 2)
			return val * val2;
		else
			return val / val2;
	}

}
