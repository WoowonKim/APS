import java.util.Scanner;

public class swea2805_농작물 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int ans = 0;
			String[] farm = new String[N]; 
			for (int i = 0; i < N; i++) {
				farm[i] = sc.next();
			}
			for(int i = 0; i<=N/2; i++) {
				for(int j=N/2-i; j<=N/2+i;j++) {
					ans += farm[i].charAt(j)-'0';
				}
			}
			int k = 1;
			for(int i=N/2+1; i<N; i++) {
				for(int j=0+k; j<N-k; j++) {
					ans += farm[i].charAt(j)-'0';
				}
				k++;
			}
			System.out.println("#" + tc + " " + ans);
		} // testCase
		sc.close();
	}
}
