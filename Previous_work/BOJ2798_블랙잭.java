import java.util.Scanner;

public class BOJ2798_블랙잭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i != j && i != k && j != k) {
						int sum = (card[i] + card[j] + card[k]);
						if (sum <= M && sum>max)
							max = sum;
					}
				}
			}
		}
		System.out.println(max);
		sc.close();
	}
}
