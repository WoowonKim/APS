import java.util.Scanner;

public class swea1926_369 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			
			String num = String.valueOf(i);
			boolean flag = false;
			for (int j = 0; j < num.length(); j++) {
				if ((num.charAt(j) - '0') % 3 == 0 && num.charAt(j) != '0') {
					System.out.printf("-");
					flag = true;
					continue;
				}
			}
			if (flag) {
				System.out.printf(" ");
				flag = false;
			}
			else System.out.printf("%d ",i);
		}
	}
}
