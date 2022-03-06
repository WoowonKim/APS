import java.util.Scanner;

public class BOJ3985_롤케익 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] rollcake = new int[L+1];
		int[] perscon = new int[N+1];
		int maxpre = 0;
		int maxact = 0;
		int preans = 0;
		int actans = 0;
		for (int i = 1; i < perscon.length; i++) {
			int cnt = 0;
			int st = sc.nextInt();
			int ed = sc.nextInt();
			if(maxpre<ed-st+1) {
				maxpre = ed-st+1;
				preans = i;
			}
			for (int j = st; j <= ed; j++) {
				if(rollcake[j]==0) {
					rollcake[j]=i;
					cnt++;
				}
				if(cnt>maxact) {
					maxact = cnt;
					actans = i;
				}
			}
		}
		System.out.println(preans);
		System.out.println(actans);
	}
}