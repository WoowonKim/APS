import java.util.Scanner;

public class BOJ2851_마리오 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int sum2 = 0;
		for (int i = 0; i < 10; i++) {
			sum += sc.nextInt();
			if (sum >= 100) {
				if (sum2 == 100 || sum == 100) {
					System.out.println(100);
					return;
				}
				if (sum - 100 <= (sum2 - 100) * -1) {
					System.out.println(sum);
					return;
				}
				System.out.println(sum2);
				return;
			}
			sum2 = sum;
		}
		System.out.println(sum);
	}

}
