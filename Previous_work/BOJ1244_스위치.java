import java.util.Scanner;

public class BOJ1244_스위치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] bulb = new int[N];
		for (int i = 0; i < N; i++) {
			bulb[i] = sc.nextInt();
		}
		int stuN = sc.nextInt();

		for (int i = 0; i < stuN; i++) {
			int gender = sc.nextInt();
			int card = sc.nextInt();

			if (gender == 1) {
				for (int j = card - 1; j < N; j += card) {
					bulb[j] = -bulb[j] + 1;
				}
			}
			if (gender == 2) {
				bulb[card - 1] = -bulb[card - 1] + 1;
				for (int j = card - 1, k = 1; j + k < N && j - k >= 0; k++) {
					if (bulb[j - k] == bulb[j + k]) {
						bulb[j - k] = -bulb[j - k] + 1;
						bulb[j + k] = -bulb[j + k] + 1;
						continue;
					}
					break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (i % 20 == 0 && i != 0)
				System.out.println();
			System.out.printf("%d ", bulb[i]);
		}
		sc.close();
	}
}
