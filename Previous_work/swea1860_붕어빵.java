import java.util.Arrays;
import java.util.Scanner;

public class swea1860_붕어빵 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		out:
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int k = sc.nextInt();
			int[] p = new int[N];
			int last = 0;
			for (int i = 0; i < N; i++) {
				p[i] = sc.nextInt();
				if (p[i]>last) last=p[i]; 
			}
			Arrays.sort(p);
			int bread = 0;
			int idx = 0;
			for (int time = 0; time<=last; time++) {
				if(time !=0 && time%M==0) {
					bread+=k;
				}
				while(time == p[idx]) {
					bread--;
					if(bread<0) {
						System.out.println("#"+tc+" Impossible");
						continue out;
					}
					idx++;
					if (idx==p.length) break;
				}
			}
			System.out.println("#"+tc+" Possible");
			
		}
		sc.close();
	}
}