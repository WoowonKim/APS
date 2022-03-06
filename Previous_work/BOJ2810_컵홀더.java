import java.util.Scanner;

public class BOJ2810_컵홀더 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String S = sc.next();
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (S.charAt(i) == 'S') {
				cnt += 1;
			}
			if (S.charAt(i) == 'L') {
				cnt += 1;
				i += 1;
			}
		}
		int ans = (cnt > S.length()) ? S.length() : cnt;
		System.out.println(ans);
		sc.close();
	}

}
