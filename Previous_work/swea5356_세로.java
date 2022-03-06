import java.util.Scanner;

public class swea5356_세로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String[] s = new String[5];
			int[] length = new int[5];
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				s[i] = sc.next();
				length[i] = s[i].length();
				sum += length[i];
			}
			System.out.print("#" + tc + " ");
			int cnt = 0, k = 0;
			while (cnt != sum) {
				for (int i = 0; i < 5; i++) {
					if (k >= length[i])
						continue;
					System.out.print(s[i].charAt(k));
					cnt++;
				}
				k++;
			}
			System.out.println();
		}
		sc.close();
	}

}
