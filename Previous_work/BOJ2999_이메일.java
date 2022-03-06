import java.util.Scanner;

public class BOJ2999_이메일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.next();
		int len = s.length();
		int R = 0;
		int C = 0;
		for (int i = 1; i <= len; i++) {
			if (len % i == 0) {
				if (i > len / i)
					break;
				R = i;
				C = len / i;
			}
		}
		char[][] code = new char[R][C];
		int idx = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				code[i][j] = s.charAt(idx++);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(code[i][j]);
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
