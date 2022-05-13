import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] stars = new String[N];

		stars[0] = "  *  ";
		stars[1] = " * * ";
		stars[2] = "*****";

		for (int k = 1; 3 * Math.pow(2, k) <= N; k++) {
			getStar(k, stars);
		}
		for (int i = 0; i < N; i++)
			System.out.println(stars[i]);
	}

	private static void getStar(int k, String[] stars) {
		int end = 3 * (int) Math.pow(2, k);
		int middle = end / 2;

		for (int i = middle; i < end; i++) {
			stars[i] = stars[i - middle] + " " + stars[i - middle];
		}

		for (int i = 0; i < middle; ++i) {
			for (int j = 0; j < middle; j++)
				stars[i] = " " + stars[i] + " ";
		}
	}
}
