import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int[] nums = {1, 5, 10, 50};
	static Set<Integer> set;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		set = new HashSet<Integer>();
		N = sc.nextInt();
		
		combination(0, 0, 0);
		System.out.println(set.size());
		sc.close();
	}
	private static void combination(int cnt, int idx, int sum) {
		if (cnt == N) {
			set.add(sum);
			return;
		}
		for (int i = idx; i < 4; i++) {
			combination(cnt + 1, i, sum+nums[i]);
		}
	}
}
