import java.util.Scanner;

public class swea1213_String {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// tc
		for (int tc = 1; tc <= 10; tc++) {
			// 입력
			int testCase = sc.nextInt();
			char[] pat = sc.next().toCharArray();
			char[] text = sc.next().toCharArray();

			int p = pat.length;
			int t = text.length;
			int cnt = 0;
			for (int i = 0; i < t - p + 1; i++) {
				boolean flag = true;
				for (int j = 0; j < p; j++) {
					if (pat[j] != text[i + j]) {
						flag = false;
						break;
					}
				}
				if (flag)
					cnt++;
			}

			System.out.println("#" + testCase + " " + cnt);
		} // tc
		sc.close();
	}// main
}// class
