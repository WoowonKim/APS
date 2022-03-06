
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			int len = sc.nextInt();
			int[][] table = new int[len][len];
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			int flag = 0;
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if (table[j][i] == 1) {
						flag = 1;
					}
					if (flag == 1 && table[j][i] == 2) {
						cnt++;
						flag = 0;
					}
				}
				flag = 0;
			}
			System.out.println("#" + testCase + " " + cnt);
		}
	}
}
