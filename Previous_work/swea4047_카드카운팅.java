import java.util.Scanner;

public class swea4047_카드카운팅 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		out: for (int tc = 1; tc <= T; tc++) {
			String S = sc.next();
			int[][] deck = new int[4][14];
			System.out.print("#" + tc + " ");
			for (int i = 0, t = 0; i < S.length() / 3; i++, t += 3) {
				char c = S.charAt(t);
				int num = (S.charAt(t + 1) - '0') * 10 + (S.charAt(t + 2) - '0');
				switch (c) {
				case 'S':
					if (deck[0][num] == 0)
						deck[0][num] = 1;
					else {
						System.out.println("ERROR");
						continue out;
					}
					break;
				case 'D':
					if (deck[1][num] == 0)
						deck[1][num] = 1;
					else {
						System.out.println("ERROR");
						continue out;
					}
					break;
				case 'H':
					if (deck[2][num] == 0)
						deck[2][num] = 1;
					else {
						System.out.println("ERROR");
						continue out;
					}
					break;
				case 'C':
					if (deck[3][num] == 0)
						deck[3][num] = 1;
					else {
						System.out.println("ERROR");
						continue out;
					}
					break;
				}
			}
			for(int i = 0; i<4; i++) {
				int left = 13;
				for(int j = 1; j<=13;j++) {
					if( deck[i][j] == 1)left--;
				}
				System.out.printf("%d ",left);
			}
			System.out.println();
		}
		sc.close();
	}

}
