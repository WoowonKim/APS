import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] houses;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		houses = new int[N];
		int C = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			houses[i] = sc.nextInt();
		}
		
		Arrays.sort(houses);
		int left = 1;
		int right = houses[N - 1] - houses[0];

		while (left < right) {
			int mid = (left + right) / 2;

			if (installWiFi(mid) < C) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		if(C == 2) System.out.println(houses[N-1] - houses[0]);
		else System.out.println(left - 1);
	}

	private static int installWiFi(int dist) {
		int cnt = 1;
		int previous = houses[0];
		for (int i = 1; i < N; i++) {
			int curr = houses[i];
			if (curr - previous >= dist) {
				cnt++;
				previous = curr;
			}
		}
		return cnt;
	}

}