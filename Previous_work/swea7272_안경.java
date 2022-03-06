import java.util.Scanner;

public class swea7272_안경 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String S1 = "CEFGHIJKLMNSTUVWXYZ";
		String S2 = "ADOPQR";
		String S3 = "B";
		for (int tc = 1; tc <= T; tc++) {
			String word1 = sc.next();
			String word2 = sc.next();
			if (word1.length() != word2.length()) {
				System.out.println("#" + tc + " DIFF");
				continue;
			}
			int w1 = 0;
			int w2 = 0;
			boolean flag = false;
			for (int i = 0; i < word1.length(); i++) {
				if (S1.contains(word1.charAt(i) + "")) {
					w1 = 1;
				} else if (S2.contains(word1.charAt(i) + "")) {
					w1 = 2;
				} else if (S3.contains(word1.charAt(i) + "")) {
					w1 = 3;
				}
				if (S1.contains(word2.charAt(i) + "")) {
					w2 = 1;
				} else if (S2.contains(word2.charAt(i) + "")) {
					w2 = 2;
				} else if (S3.contains(word2.charAt(i) + "")) {
					w2 = 3;
				}
				if(w1==w2) flag = true;
				else {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("#" + tc + " SAME");
			} else {
				System.out.println("#" + tc + " DIFF");
			}
		}
		sc.close();
	}

}
