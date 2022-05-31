import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] st = new int[2];
		int[] ed = new int[2];
		int T = sc.nextInt();
		while(T-- > 0) {
			st[0] = sc.nextInt();
			st[1] = sc.nextInt();
			ed[0] = sc.nextInt();
			ed[1] = sc.nextInt();
			int ans = 0;
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				boolean flag = false;
				int rX = sc.nextInt();
				int rY = sc.nextInt();
				int r = sc.nextInt();
				if((st[0]-rX)*(st[0]-rX) + (st[1]-rY)*(st[1]-rY) < r*r) {
					flag = true;
					ans++;
				}
				if((ed[0]-rX)*(ed[0]-rX) + (ed[1]-rY)*(ed[1]-rY) < r*r) {
					if(flag) ans--;
					else ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
