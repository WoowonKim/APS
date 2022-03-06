import java.util.ArrayList;
import java.util.Scanner;

public class swea4698_테네스소수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> sosu = new ArrayList<>();

		for (int n = 2; n <= 1000003; n++) {
			boolean flag = true; // 소수인지 체크
			// 1 과 자기자신 제외 -> 2 부터 체크
			for (int i = 2, R = n / 2; i <= R; R = n / ++i) {
				if (n != i * R)
					continue; // 둘의 곱이 n 이 되지 않으면 i는 약수가 아님
				// 1과 자기자신 이외의 약수가 있는 녀석만 넘어옴
				flag = false; // 즉, 소수가 아님
				break;
			}
			// 소수일 경우
			if (flag) {
				sosu.add(n);
			}
		}

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0; // 특별한 소수의 개수
			int D = sc.nextInt(); // 포함했는지 체크해야할 수 1 ~ 9
			int A = sc.nextInt(); // A 이상 1 ~ 1000,000
			int B = sc.nextInt(); // B 이하의 수에서 탐색 1 ~ 1000,000

			for (int i = 0; sosu.get(i) <= B; i++) {
				if (A > sosu.get(i))
					continue;
				if (!(sosu.get(i) + "").contains(D + ""))
					continue;
				ans++;
			}

			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

}
