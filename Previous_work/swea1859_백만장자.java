import java.util.Scanner;

public class swea1859_백만장자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] price = new int[N];
			for (int i = 0; i < N; i++) {
				price[i] = sc.nextInt();
			}
			long ans = 0;
			int max = 0;
			for(int i = N-1; i>=0;i--) {
				if(max < price[i]) {
					max = price[i];
					continue;
				}
				ans += max-price[i];
			}
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}
}
