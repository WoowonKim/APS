import java.util.Scanner;

public class BOJ4779_칸토어 {

	public static StringBuilder recur(int N,int cnt, StringBuilder sb) {
		if(cnt==N) {
			return sb;
		}
		String pre = sb.toString();
		int len = sb.length();
		for (int j = 0; j < len; j++) {
			sb.append(' ');
		}
		sb.append(pre);
		return recur(N,++cnt,sb);
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			sb.setLength(0);
			int cnt = 0;
			int N = sc.nextInt();
			sb.append('-');
			System.out.println(recur(N,cnt,sb).toString());
		}
		sc.close();
	}
}
