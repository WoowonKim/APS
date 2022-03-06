import java.util.Scanner;

public class BOJ2941_크로아티아 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if(i+2<s.length()) {
				char y = s.charAt(i + 1);
				char z = s.charAt(i+2);
				if (x == 'd' && y=='z' && z=='=') {
					i+=2;
					cnt++;
					continue;
				}
			}
			if (i + 1 < s.length()) {
				char y = s.charAt(i + 1);
				if (x == 'c' && y=='=' || y=='-') {
					i++;
					cnt++;
					continue;
				}
				if (x == 'd' && y=='-') {
					i++;
					cnt++;
					continue;
				}
				if (x == 'l' && y=='j') {
					i++;
					cnt++;
					continue;
				}
				if (x == 'n' && y=='j') {
					i++;
					cnt++;
					continue;
				}
				if (x == 's' && y=='=') {
					i++;
					cnt++;
					continue;
				}
				if (x == 'z' && y=='=') {
					i++;
					cnt++;
					continue;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
